#include <iostream>
using namespace std;

int seq[2001];
int dp[2001][2001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int n, m;
    cin >> n;
    for(int i = 1; i <= n; i++)
        cin >> seq[i];
    for(int i = 1; i <= n; i++)
    {
        if(i <= n - 1 && seq[i] == seq[i + 1])
            dp[i][i + 1] = 1;
        dp[i][i] = 1;
    }

    for(int i = 3; i <= n; i++)
        for(int j = 1; j <= n - i + 1; j++)
            if(seq[j] == seq[j + i - 1] && dp[j + 1][j + i - 2] == 1)
                dp[j][j + i - 1] = 1;

    cin >> m;
    while(m--)
    {
        int s, e;
        cin >> s >> e;
        cout << dp[s][e] << "\n";
    }
    return 0;
}