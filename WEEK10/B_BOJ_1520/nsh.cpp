#include <iostream>
#include <algorithm>
using namespace std;

int field[501][501];
int road[501][501];
int dr[4] = {0, 1, 0, -1};
int dc[4] = {1, 0, -1, 0};

int dfs(int m, int n, int cr, int cc)
{
    if(road[cr][cc] >= 0) return road[cr][cc];
    if(cr == m - 1 && cc == n - 1) return 1;

    road[cr][cc] = 0;
    for(int i = 0; i < 4; i++)
    {
        int nr = cr + dr[i];
        int nc = cc + dc[i];
        if(nr < 0 || nr >= m || nc < 0 || nc >= n)
            continue;
        if(field[nr][nc] < field[cr][cc])
            road[cr][cc] = max(dfs(m, n, nr, nc) + road[cr][cc], road[cr][cc]);
    }
    return road[cr][cc];
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int m, n;
    cin >> m >> n;
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            road[i][j] = -1;
            cin >> field[i][j];
        }
    }

    road[0][0] = dfs(m, n, 0, 0);
    cout << road[0][0];
    return 0;
}