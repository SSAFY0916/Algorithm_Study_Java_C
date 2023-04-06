// 7579 앱

#include <iostream>
#include <algorithm>

using namespace std;

int N, M, tc;
int app[101][2];
int dp[101][10001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	// ~100 ~10000
	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		cin >> app[i][0]; // memory
	}
	for (int i = 1; i <= N; i++) {
		cin >> app[i][1]; // cost
		tc += app[i][1]; // total cost
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 0; j <= tc; j++) {
			dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			if (j >= app[i][1]) {
				dp[i][j] = max(dp[i][j], dp[i - 1][j - app[i][1]] + app[i][0]);
			}
		}
	}

	for (int i = 1; i <= tc; i++) {
		if (dp[N][i] >= M) {
			cout << i;
			return 0;
		}
	}

	return 0;
}
