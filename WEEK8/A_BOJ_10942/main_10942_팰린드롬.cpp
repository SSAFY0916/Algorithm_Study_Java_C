// 10942 팰린드롬?

#include <iostream>
#define SIZE 2001
using namespace std;

int n, m, s, e;
int nums[SIZE];
bool dp[SIZE][SIZE]; // i ~ j의 펠린드롬 여부

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> nums[i];
	}

	// len = 1
	for (int i = 1; i <= n; i++) {
		dp[i][i] = true;
	}
	// len = 2
	for (int i = 1; i < n; i++) {
		if (nums[i] == nums[i + 1]) dp[i][i + 1] = true;
	}
	// len = 3~
	for (int l = 3; l <= n; l++) { // l: len
		for (int i = 1; i <= n - l + 1; i++) { // s
			int j = i + l - 1; // e
			if (nums[i] == nums[j] && dp[i + 1][j - 1])
				dp[i][j] = true;
		}
	}

	cin >> m;
	while (m-- > 0) {
		cin >> s >> e;
		if (dp[s][e]) cout << "1\n";
		else cout << "0\n";
	}

	return 0;
}
