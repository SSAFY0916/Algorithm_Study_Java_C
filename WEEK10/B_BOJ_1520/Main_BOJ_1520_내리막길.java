package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_BOJ_1520_내리막길 {

	static int M, N, H;
	static int[][] road, DP;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

//	static class Coordinate {
//		int x, y;
//
//		public Coordinate(int x, int y) {
//			super();
//			this.x = x;
//			this.y = y;
//		}
//
//	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = 0;

		road = new int[M][N];
		DP = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				DP[i][j] = -1;
			}
		}

		System.out.println(DFS(0, 0));

	}

	private static int DFS(int x, int y) {
		// TODO Auto-generated method stub

		if (x == M - 1 && y == N - 1) {
			return 1;
		}

		if(DP[x][y] != -1) { // 안하면 시간 초과 ?
			return DP[x][y];
		}
		
		DP[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N && road[x][y] > road[nx][ny]) {
				DP[x][y] += DFS(nx,ny);
			}
		}
		
		return DP[x][y];

	}

}