#include <iostream>
#include <cmath>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) {
	return a.first < b.first;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int N, K, A = 0;
	cin >> N >> K;

	int g, x;
	vector<pair<int, int>> pos;
	for (int i = 0; i < N; i++) {
		cin >> g >> x;
		pos.push_back({ x, g });
	}

	sort(pos.begin(), pos.end(), compare);
	
	if (pos[N - 1].first - pos[0].first <= K * 2) {
		for (int i = 0; i < N; i++) {
			A += pos[i].second;
		}
	}
	else {
		int total = 0;
		int l = 0, r = 1;
		int lp = pos[l].first;
		int rp = pos[r].first;
		total += pos[l].second;

		while (lp + K * 2 >= rp) {
			total += pos[r].second;
			rp = pos[++r].first;
		}
		A = max(A, total);

		while (r < N) {
			while (lp + K * 2 < rp) {
				total -= pos[l].second;
				lp = pos[++l].first;
			}
			while (lp + K * 2 >= rp) {
				total += pos[r].second;
				if (++r == N) break;
				rp = pos[r].first;
			}
			A = max(A, total);
		}
	}

	cout << A;
	return 0;
}
