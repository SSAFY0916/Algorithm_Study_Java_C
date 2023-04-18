import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_2151_거울설치 {

	static int N, min;
	static char[][] room;
	static int[][] visited;
	static List<door> doors;
	static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dy = { 0, 1, 0, -1 };

	static class door {
		int x, y;

		public door(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		room = new char[N][N];
		visited = new int[N][N];
		doors = new ArrayList<door>();
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				char cTemp = temp.charAt(j);
				room[i][j] = cTemp;
				if (cTemp == '#') {
					doors.add(new door(i, j));
				}
			}
		}

		for(int i = 0; i < 4; i++) {			
			DFS(doors.get(0).x, doors.get(0).y, i,0);
		}

		System.out.println(min);

	}

	private static void DFS(int x, int y, int dir, int cnt) {
		// TODO Auto-generated method stub
		if (cnt > min) { // 백트래킹
			return;
		}

		if (x == doors.get(1).x && y == doors.get(1).y) {
			int temp = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j] > 0) {
						temp++;
					}
				}
			}
			min = Math.min(min, temp);
			return;
		}

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx >= 0 && ny >= 0 && nx < N && ny < N && room[nx][ny] != '*') {
			if (room[nx][ny] == '!') {
				if (visited[nx][ny] == 0) { // 기존거울X + 거울 안놓고 갈때
					DFS(nx, ny, dir,cnt);
				}
				if (visited[nx][ny] >= 3) { // 무한루프 탈출
					return;
				}
				
				if(visited[nx][ny] > 1) { // 기존거울O
					visited[nx][ny]++;
					DFS(nx, ny, (dir + 1) % 4, cnt);
					DFS(nx, ny, (dir + 3) % 4, cnt); 
					visited[nx][ny]--;
				} else { // 기존거울X + 거울 놓고갈때
					visited[nx][ny]++;
					DFS(nx, ny, (dir + 1) % 4, cnt + 1); 
					DFS(nx, ny, (dir + 3) % 4, cnt + 1); 
					visited[nx][ny]--;
				}


			} else {
				DFS(nx, ny, dir, cnt);
			}
		}
	}

}