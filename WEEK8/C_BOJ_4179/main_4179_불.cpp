// 4179 불!

#include <iostream>
#include <string>
#include <queue>
#include <utility>

#define SIZE 1000
using namespace std;

int R, C;
char grid[SIZE][SIZE];
bool visited[SIZE][SIZE];

queue<pair<int, int>> jihun;
queue<pair<int, int>> fire;

int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { 1, 0, -1, 0 };

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> R >> C;
	for (int i = 0; i < R; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < C; j++) {
			grid[i][j] = str[j];
			if (grid[i][j] == 'J') {
				jihun.push({ i, j });
				grid[i][j] = '.';
				visited[i][j] = true;
			}
			else if (grid[i][j] == 'F') {
				fire.push({ i, j });
			}
		}
	}

	int time = 1;
	bool escapable = false;
	while (!jihun.empty() && !escapable) {
		// 불 확산
		int sz = fire.size();
		while (sz-- > 0) {
			int x = fire.front().first;
			int y = fire.front().second;
			fire.pop();

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (grid[nx][ny] == '#' || grid[nx][ny] == 'F') continue;

				grid[nx][ny] = 'F';
				fire.push({ nx, ny });
			}
		}

		//  지훈이 이동
		sz = jihun.size();
		while (sz-- > 0) {
			int x = jihun.front().first;
			int y = jihun.front().second;
			jihun.pop();

			if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
				escapable = true;
				cout << time;
				return 0; //
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (grid[nx][ny] == '#' || grid[nx][ny] == 'F') continue;
				if (visited[nx][ny]) continue;

				visited[nx][ny] = true;
				jihun.push({ nx, ny });
			}
		}

		time++;
	}

	/*
	if (escapable) cout << time;
	else cout << "IMPOSSIBLE";
	*/
	cout << "IMPOSSIBLE";

	return 0;
}
