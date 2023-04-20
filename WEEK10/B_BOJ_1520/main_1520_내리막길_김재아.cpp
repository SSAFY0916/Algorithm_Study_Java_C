// 1520 내리막길

#include <iostream>

using namespace std;

int N, M;
int map[500][500];
int answer[500][500];

bool found;
int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { 1, 0, -1, 0 };

int findWay(int x, int y) {
	if (x == N - 1 && y == M - 1) return 1;
	if (answer[x][y] == -1) {
		answer[x][y] = 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (map[nx][ny] < map[x][y])
				answer[x][y] += findWay(nx, ny);
		}
	}
	return answer[x][y];
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			answer[i][j] = -1;
		}
	}

	cout << findWay(0, 0);
	return 0;
}