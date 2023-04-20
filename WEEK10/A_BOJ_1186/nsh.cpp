#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

typedef pair<pair<int, int>, pair<int, int>> square;
typedef pair<int, int> area;
vector<area> tmparv;
vector<square> sqv;
vector<area> realArea(55, {0, 0});

bool compare(area a, area b)
{
    if(a.first == b.first) return a.second < b.second;
    else return a.first > b.first;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, k;
    cin >> n >> k;
    for(int i = 1; i <= n; i++)
    {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        sqv.push_back({{x1, y1}, {x2, y2}});
        tmparv.push_back({(x2 - x1) * (y2 - y1), i});
        int Ssize = (int)sqv.size();
        for(int j = 0; j < Ssize - 1; j++)
        {
            int px1 = sqv[j].first.first;
            int px2 = sqv[j].second.first;
            int py1 = sqv[j].first.second;
            int py2 = sqv[j].second.second;

            if(px2 <= x1 || px1 >= x2 || py2 <= y1 || py1 >= y2)
                continue;
            if(px1 >= x1 && px2 <= x2 && py1 >= y1 && py2 <= y2)
            {
                sqv[j] = {{-50000, -50000}, {-50000, -50000}};
                tmparv[j] = {0, tmparv[j].second};
            }
            else
            {
                int nx1 = max(px1, x1);
                int nx2 = min(px2, x2);
                int ny1 = max(py1, y1);
                int ny2 = min(py2, y2);
                int sign = -1;
                if(tmparv[j].first != 0)
                    sign = tmparv[j].first / abs(tmparv[j].first);

                int newArea = (-1) * sign * (nx2 - nx1) * (ny2 - ny1);
                if(newArea + tmparv[j].first != 0)
                {
                    sqv.push_back({{nx1, ny1}, {nx2, ny2}});
                    tmparv.push_back({newArea, tmparv[j].second});
                }
                else
                    tmparv[j].first = 0;
            }
        }
    }

    for(int i = 0; i < (int)tmparv.size(); i++)
    {
        int curI = tmparv[i].second;
        int curA = tmparv[i].first;
        realArea[curI].second = curI;
        realArea[curI].first += curA;
    }
    sort(realArea.begin(), realArea.begin() + n + 1, compare);

    vector<int> ret;
    int count = 0, aa = 0;
    while(count < k)
    {
        if(realArea[aa].second != 0)
        {
            ret.push_back(realArea[aa].second);
            count++;
        }
        aa++;
    }

    sort(ret.begin(), ret.end());
    for(int i = 0; i < k; i++)
        cout << ret[i] << " ";
    return 0;
}