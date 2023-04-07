// 1963 소수 경로

#include <iostream>
#include <queue>
#include <cmath>
#include <string.h>
#define MAX 10000
using namespace std;

bool checked[MAX];
bool prime[MAX]; // 소수: true
queue<int> q;

void push_next(int n) {
	int nums[4];

	int cp = n;
	for (int i = 0; i < 4; i++) {
		nums[i] = cp % 10;
		cp /= 10;
	}
	for (int i = 0; i < 3; i++) {
		int cur = n - nums[i] * pow(10, i);
		for (int j = 0; j < 10; j++) {
			if (j == nums[i]) continue;
			int nxt = cur + j * pow(10, i);
			if (prime[nxt] && !checked[nxt]) {
				q.push(nxt);
				checked[nxt] = true;
			}
		}
	}
	int cur = n - nums[3] * pow(10, 3);
	for (int j = 1; j < 10; j++) {
		if (j == nums[3]) continue;
		int nxt = cur + j * pow(10, 3);
		if (prime[nxt] && !checked[nxt]) {
			q.push(nxt);
			checked[nxt] = true;
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	
	memset(prime, true, MAX);
	prime[0] = false;
	prime[1] = false;
	for (int i = 2; i < MAX; i++) {
		if (!prime[i]) continue;
		for (int j = i * 2; j < MAX; j += i) {
			prime[j] = false;
		}
	}
	
	int T = 0;
	cin >> T;
	while (T-- > 0) {
		int a, b, c = -1;
		cin >> a >> b;
		
		while (!q.empty()) q.pop();
		memset(checked, false, MAX);
		checked[a] = true;
		q.push(a);
		int cnt = 0;
		while (c == -1) {
			int sz = q.size();
			while (sz-- > 0 && c == -1) {
				int cur = q.front();
				q.pop();
            	if (cur == b) {
					c = cnt;
				}
				push_next(cur);
			}
			cnt++;
		}

		if (c == -1) cout << "Impossible\n";
		else cout << c << "\n";
	}

	return 0;
}
