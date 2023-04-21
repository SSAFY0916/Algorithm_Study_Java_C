#include <iostream>
#include <queue>
#include <vector>
using namespace std;

vector<int> hp;
int attack[18] = {9, 3, 1, 9, 1, 3, 3, 1, 9, 3, 9, 1, 1, 9, 3, 1, 3, 9};
int visit[61][61][61];
int ret;

void bfs()
{
    queue<vector<int>> q;
    q.push(hp);
    visit[hp[0]][hp[1]][hp[2]] = 1;
    while(!q.empty())
    {
        int qSize = (int)q.size();
        ret++;
        for(int i = 0; i < qSize; i++)
        {
            vector<int> cur = q.front();
            q.pop();

            for(int j = 0; j < 6; j++)
            {
                vector<int> nc = cur;
                for(int k = 0; k < (int)nc.size(); k++)
                {
                    nc[k] -= attack[3 * j + k];
                    if(nc[k] < 0) nc[k] = 0;
                }
                if(visit[nc[0]][nc[1]][nc[2]] == 1) continue;
                for(int k = 0; k < (int)nc.size(); k++)
                {
                    if(nc[k] > 0) break;
                    if(k == (int)nc.size() - 1) return;
                }
                visit[nc[0]][nc[1]][nc[2]] = 1;
                q.push(nc);
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    for(int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        hp.push_back(tmp);
    }
    for(int i = n; i < 3; i++)
        hp.push_back(0);
    bfs();
    cout << ret;
    return 0;
}