#include <iostream>
#include <algorithm>
using namespace std;

int memo[101];
int cost[101];
int dp[101][10001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int n, m, costSum = 0;
    cin >> n >> m;
    for(int i = 1; i <= n; i++)
        cin >> memo[i];
    for(int i = 1; i <= n; i++)
    {
        cin >> cost[i];
        costSum += cost[i];
    }
    
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= costSum; j++)
        {
            if(j >= cost[i])
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memo[i]);
            else
                dp[i][j] = dp[i - 1][j];            
        }
    }
    
    int minCost = 10001;
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= costSum; j++)
        {
            if(dp[i][j] >= m && minCost > j)
                minCost = j;
        }
    }
    cout << minCost;
    return 0;
}