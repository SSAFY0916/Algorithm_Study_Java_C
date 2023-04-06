#include <iostream>
#include <queue>
#include <string>
using namespace std;

int primeNumber[10000];

void bfs(string a, string b)
{
    int visit[10000] = {0};
    int d[10000];
    for(int i = 1000; i <= 9999; i++)
        d[i] = -1;
    queue<string> q;
    q.push(a);
    visit[stoi(a)] = 1;
    d[stoi(a)] = 0;

    while(!q.empty())
    {
        string cur = q.front();
        q.pop();
        if(cur.compare(b) == 0) break;
        for(int i = 0; i <= 3; i++)
        {
            for(int j = 0; j <= 9; j++)
            {
                if(i == 0 && j == 0) continue;
                string ncur = cur;
                ncur[i] = j + '0';
                if(visit[stoi(ncur)] == 0 && primeNumber[stoi(ncur)] == 0)
                {
                    q.push(ncur);
                    visit[stoi(ncur)] = 1;
                    d[stoi(ncur)] = d[stoi(cur)] + 1;
                }
            }
        }
    }
    if(d[stoi(b)] == -1) cout << "Impossible\n";
    else cout << d[stoi(b)] << "\n";
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    for(int i = 2; i <= 9999; i++)
    {
        if(primeNumber[i] == 0)
        {
            for(int j = i + i; j <= 9999; j += i)
                primeNumber[j] = 1;
        }
    }
    int t;
    cin >> t;

    while(t--)
    {
        string a, b;
        cin >> a >> b;

        bfs(a, b);
    }
    return 0;
}