import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_24463_미로 {
	
	static int N,M,min;
	static char[][] maze;
	static boolean[][] visited;
	static List<Hole> holeList;
	static ArrayDeque<Hole> road;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static StringBuilder sb;
	
	static class Hole {
		int x,y,cnt;

		public Hole(int x, int y, int cnt) {
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
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		maze = new char[N][M];
		visited = new boolean[N][M];
		holeList = new ArrayList<Hole>();
		road = new ArrayDeque<Hole>();
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = temp.charAt(j);
				if(maze[i][j] == '.' && (i == 0 || j == 0 || i == N-1 || j == M-1)) {
					holeList.add(new Hole(i, j, -1));
				}
			}
		}
		
		visited[holeList.get(0).x][holeList.get(0).y] = true;
		road.add(new Hole(holeList.get(0).x, holeList.get(0).y, 0));
		BFS();
		visited = new boolean[N][M];
		
		visited[holeList.get(0).x][holeList.get(0).y] = true;
		DFS(holeList.get(0).x, holeList.get(0).y, 0);
		
		
		
		
	}

	private static void BFS() {
		// TODO Auto-generated method stub
		
		while(!road.isEmpty()) {
			
			Hole curH= road.poll();
			
			if(curH.x == holeList.get(1).x && curH.y == holeList.get(1).y) {
				min = curH.cnt;
			}
			 
			for(int i = 0; i < 4; i++) {
				int nx = curH.x + dx[i];
				int ny = curH.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && maze[nx][ny] == '.' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					road.add(new Hole(nx, ny, curH.cnt+1));
				}
			}
		}
		
	}

	private static void DFS(int x, int y, int cnt) {
		// TODO Auto-generated method stub
		
		if(x == holeList.get(1).x && y == holeList.get(1).y && min == cnt) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(maze[i][j] == '.' && !visited[i][j]) {
						sb.append('@');
					} else {						
						sb.append(maze[i][j]);
					}
				}
				sb.append("\n");
			}
//			return; // or exit메소드 사용해보기
			System.out.println(sb.toString());
			System.exit(0);
		}
		
		if(cnt > min) {
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M && (maze[nx][ny] == '.' || maze[nx][ny] == '@') &&!visited[nx][ny]) {
				visited[nx][ny] = true;
				DFS(nx,ny,cnt+1);
				visited[nx][ny] = false;
			}
		}
		
	}

}