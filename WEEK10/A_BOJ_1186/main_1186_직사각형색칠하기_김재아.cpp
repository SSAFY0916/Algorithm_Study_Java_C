// 1186 직사각형 색칠하기

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

int N, K, S;
int square[51][4]; // x1, y1, x2, y2

vector<pair<int, int>> area[20001]; // 직사각형이 칠해진 공간 표시
vector<pair<int, int>> sizes; // 직사각형들을 크기 순으로 나열하기 위한 vector, 각 직사각형의 번호와 크기를 의미

bool answer[51]; // 선택할 직사각형을 표시하기 위한 bool 배열

bool compare(pair<int, int>a, pair<int, int>b) { // 색칠된 공간을 정렬하기 위한 함수
	return a.first < b.first;
}

bool compare2(pair<int, int>a, pair<int, int>b) { // 직사각형들을 크기 순으로 정렬하기 위한 함수
	if (a.first == b.first) return a.second < b.second;
	return a.first > b.first;
}

void getSize() {
	// 사각형들의 크기 구하기
	for (int i = N; i > 0; i--) {
		int cur = 0;

		int x1 = square[i][0] + 10000;
		int y1 = square[i][1];
		int x2 = square[i][2] + 10000 - 1;
		int y2 = square[i][3] - 1;
		
		for (int x = x1; x <= x2; x++) { // x 좌표가 x일 때, 칠해지는 공간을 찾기 위한 반복문
			y1 = square[i][1];
			y2 = square[i][3] - 1;

			if (area[x].size() == 0) {
				cur += y2 - y1 + 1;
				area[x].push_back({ y1, y2 }); // 모두 칠색칠
			}
			else {
				for (int j = 0; j < area[x].size(); j++) { // 이미 칠해진 곳과 비교
					if (area[x][j].second<y1) continue;
					// if (area[x][j].first > y2) break;

					if (area[x][j].first >= y1) {
						if (area[x][j].first > y2) { // 뒷쪽 일부분만 겹치는 경우
							cur += y2 - y1 + 1;
							area[x].push_back({ y1, y2 });
							y1 = y2 + 1;
						}
						else { // 전부 겹치는 경우
							cur += area[x][j].first - y1;
							area[x][j].first = y1;
							y1 = area[x][j].second + 1;
						}
					}
					else { // 앞쪽 일부분만 겹치는 경우
						if (area[x][j].second >= y1) {
							y1 = area[x][j].second + 1;
						}
					}

					if (y1 > y2) { // 모두 칠했다면 반복문출탈출
						break;
					}
				}
				if (y1 <= y2) { // 아직 칠하지 못한 곳이 있다면칠색칠
					cur += y2 - y1 + 1;
					area[x].push_back({ y1, y2 });
				}

			}
			sort(area[x].begin(), area[x].end(), compare); // 새로 칠한 곳에 대해 정렬
		}
		sizes.push_back({ cur, i }); // 색칠된 크기와 직사각형의 번호 저장
	}

}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> N >> K;

	for (int i = 1; i <= N; i++) { // 직사각형의 좌하단, 우상단 좌표 저장
		cin >> square[i][0] >> square[i][1] >> square[i][2] >> square[i][3];
	}

	getSize(); // 직사각형들의 크기 구하기
	sort(sizes.begin(), sizes.end(), compare2); // 직사각형들을 크기 순으로 정렬

	for (int i = 0; i < K; i++) {
		answer[sizes[i].second] = true;
	}

	for (int i = 1; i <= N; i++) {
		if (answer[i]) cout << i << " ";
	}

	return 0;
}