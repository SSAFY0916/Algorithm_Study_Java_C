// 18869 멀티버스 Ⅱ

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

int m, n, t;
vector<pair<int, int>> univ[100];
vector<pair<int, int>> same[100];

bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.second == b.second) return a.first < b.first;
	else return a.second < b.second;
}

bool similar(int a, int b) {
	if (same[a].size() != same[b].size())
        return false;
	int sz = same[a].size();
	for (int i = 0; i < sz; i++) {
		if (same[a][i].first != same[b][i].first || same[a][i].second != same[b][i].second)
			return false;
	}
	for (int i = 0; i < n; i++) {
		if (univ[a][i].first != univ[b][i].first)
			return false;
	}
	return true;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> m >> n;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> t;
			univ[i].push_back({ j + 1, t });
		}
	}
	for (int i = 0; i < m; i++) {
		sort(univ[i].begin(), univ[i].end(), compare);
		
		for (int j = 1; j < n; j++) {
			if (univ[i][j].second == univ[i][j - 1].second) {
				same[i].push_back({ j - 1, j });
			}
		}
	}

	int answer = 0;
	for (int i = 0; i < m - 1; i++) {
		for (int j = i + 1; j < m; j++) {
			if (similar(i, j)) answer++;
		}
	}

	cout << answer;

	return 0;
}
