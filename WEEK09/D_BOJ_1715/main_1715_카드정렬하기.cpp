// 1715 카드 정렬하기

#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int n, tmp, total;
priority_queue<int, vector<int>, greater<int>> card;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		card.push(tmp);
	}

	while (!card.empty() && card.size() > 1) {
		int cur = card.top();
		card.pop();
		cur += card.top();
		card.pop();
		total += cur;
		card.push(cur);
	}
	cout << total;

	return 0;
}
