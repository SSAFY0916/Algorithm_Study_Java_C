// 1052 물병

#include <iostream>
using namespace std;

int N, K;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> N >> K;
	if (K >= N) {
		cout << 0;
		return 0;
	}

	int answer = 0;
	while (true) {
		int cnt = 0;
		int tmp = N;
		while (tmp > 0) {
			if (tmp % 2 != 0) {
				cnt++;
			}
			tmp /= 2;
		}
		if (K >= cnt)
			break;
		N++;
		answer++;
	}
	cout << answer;
	return 0;
}
