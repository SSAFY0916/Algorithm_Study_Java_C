#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <cmath>
using namespace std;

typedef pair<int, int> home;
typedef long long int ll;
map<int, int> check;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int n, k;
    int count = 0;
    ll ret = 0;
    queue<home> q;
    cin >> n >> k;
    for(int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        check[tmp] = 1;
        q.push({1, tmp});
        q.push({-1, tmp});
    }

    while(!q.empty())
    {
        home cur = q.front();
        q.pop();

        int diff = cur.first;
        int h = cur.second;
        int direc = -1;
        if(diff > 0) direc = 1;

        if(check.find(h + diff) == check.end())
        {
            q.push({diff + direc, h});
            check[h + diff] = 1;
            count++;
            ret += abs(diff);
            if(count == k)
                break;
        }
    }
    cout << ret;
    return 0;
}