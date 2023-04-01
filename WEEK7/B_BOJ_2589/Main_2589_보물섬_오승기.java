import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2589_보물섬_오승기 {

	static int row, col, max;
	static boolean[][] map;
	//static List<Coordinate> cList;
	static ArrayDeque<Coordinate> ad;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};

	static class Coordinate {
		int x;
		int y;
		int cnt;

		public Coordinate(int x, int y,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new boolean[row][col];
		max = Integer.MIN_VALUE;
		ad = new ArrayDeque<>();

		for (int i = 0; i < row; i++) {
			String temp = br.readLine();
			for (int j = 0; j < col; j++) {
				if (temp.charAt(j) == 'L') {
					map[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j]) {
					visited = new boolean[row][col];
					int deepest = BFS(i,j);
					max = Math.max(max, deepest);
				}
			}
		}
		
		System.out.println(max);

	}

	private static int BFS(int x, int y) {
		// TODO Auto-generated method stub
		ad.offer(new Coordinate(x, y, 0)); // 시작
		visited[x][y] = true;
		
		int cnt = 0;
		while(!ad.isEmpty() ) {			
			Coordinate curCo = ad.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = curCo.x + dx[i];
				int ny = curCo.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visited[nx][ny] && map[nx][ny]) {
					ad.offer(new Coordinate(nx, ny , curCo.cnt+1));
					cnt = Math.max(cnt, curCo.cnt+1);
					visited[nx][ny] = true;
				}
				
			}

		}
		return cnt;
		
	}

}
