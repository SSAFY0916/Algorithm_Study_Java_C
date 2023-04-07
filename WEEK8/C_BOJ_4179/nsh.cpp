#include <iostream>
#include <string>
#include <queue>
#include <vector>
using namespace std;

typedef pair<int, int> co;

int map[1001][1001];
int visit[1001][1001];
queue<co> q;
queue<co> fire;
int dr[4] = {1, 0, -1, 0};
int dc[4] = {0, 1, 0, -1};
int ret;

void bfs(int r, int c)
{
    bool flag = false;
    while(!q.empty())
    {
        int qs = q.size();
        ret++;
        for(int i = 0; i < qs; i++)
        {
            co cur = q.front();
            q.pop();
            if(map[cur.first][cur.second] == 'F') continue;
            for(int i = 0; i < 4; i++)
            {
                int nr = cur.first + dr[i];
                int nc = cur.second + dc[i];
                if(nr >= r || nr < 0 || nc >= c || nc < 0)
                {
                    flag = true;
                    break;
                }
                if(visit[nr][nc] == 1 || map[nr][nc] == '#' || map[nr][nc] == 'F')
                    continue;
                visit[nr][nc] = 1;
                q.push({nr, nc});
            }
            if(flag) break;
        }
        if(flag) break;
        int fs = fire.size();
        for(int i = 0; i < fs; i++)
        {
            co f = fire.front();
            fire.pop();
            for(int i = 0; i < 4; i++)
            {
                int nr = f.first + dr[i];
                int nc = f.second + dc[i];
                if(nr >= r || nr < 0 || nc >= c || nc < 0)
                    continue;
                if(map[nr][nc] == '#' || map[nr][nc] == 'F')
                    continue;
                fire.push({nr, nc});
                map[nr][nc] = 'F';
            }
        }
    }
    if(flag) cout << ret;
    else cout << "IMPOSSIBLE";
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int r, c;
    cin >> r >> c;
    for(int i = 0; i < r; i++)
    {
        string tmp;
        cin >> tmp;
        for(int j = 0; j < c; j++)
        {
            map[i][j] = tmp[j];
            if(map[i][j] == 'J')
            {
                q.push({i, j});
                visit[i][j] = 1;
            }
            else if(map[i][j] == 'F')
                fire.push({i, j});
        }
    }
    
    bfs(r, c);
    return 0;
}