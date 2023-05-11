// 13904 과제

#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>

using namespace std;

int N, d, w;
int answer[1001];
vector<pair<int, int>> hw;

bool compare(pair<int, int> a, pair<int, int> b) {
	return a.second > b.second; // 점수 내림차순
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> d >> w;
		hw.push_back({ d, w });
	}

	sort(hw.begin(), hw.end(), compare);
	for (int i = 0; i < N; i++) {
		for (int j = hw[i].first; j > 0; j--) {
			if (answer[j] == 0) {
				answer[j] = hw[i].second;
				break;
			}
		}
	}

	int total = 0;
	for (int i = 1; i < 1001; i++) {
		total += answer[i];
	}
	cout << total;

	return 0;
}