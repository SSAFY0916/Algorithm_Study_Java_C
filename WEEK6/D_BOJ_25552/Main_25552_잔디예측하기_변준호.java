import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_25552_잔디예측하기_변준호 {
	/*
	 * 상 하 좌 우 D번 이하 
	 * X => 0 O => 1
	 */
	static int dy[] = {-1,1,0,0}; // 상 하 좌 우
	static int dx[] = {0,0,-1,1};
	static int N,M,D;
	static int arr[][],zandi[][];
	static Queue<Grass> mq = new ArrayDeque<>();
	static boolean visit[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		zandi = new int[N][M];
		//현재 잔디
		visit = new boolean[10][N][M];
		//D가 입력되지 않았으므로 넉넉하게 처리
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				if(str.charAt(k)=='O') {
					arr[i][k] = 1;
					mq.add(new Grass(i,k,0));
					visit[0][i][k] = true; //바로 방문처리
				}else {
					arr[i][k] = 0;
				}
			}
		}
		
		D = Integer.parseInt(br.readLine());

		// 결과 잔디
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				if(str.charAt(k)=='O') {
					zandi[i][k] = 1;
				}else {
					zandi[i][k] = 0;
				}
			}
		}
		bfs();
		//결과 확인
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]==zandi[i][k]) {
					continue;
				}else {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
		
	}
	
	private static void bfs() {
		// TODO Auto-generated method stub
		while(!mq.isEmpty()) {
			Grass tmp = mq.poll();
			dfs(tmp.y,tmp.x,tmp.d);
		}
	}

	private static void dfs(int y, int x, int d) {
		// TODO Auto-generated method stub
		if(d==D) {
			return;
		}
		for(int i=0;i<4;i++) {
			int cy = y+dy[i];
			int cx = x+dx[i];
			if(cy>=0&&cx>=0&&cy<N&&cx<M&&!visit[d+1][cy][cx]) {
				visit[d+1][cy][cx] = true;
				if(arr[cy][cx]==0&&zandi[cy][cx]==1) {
					arr[cy][cx]= 1; //잔디 퍼짐 + 다시 BFS+
					mq.add(new Grass(cy,cx,0));
				}else if(zandi[cy][cx]==0) { //잔디 안퍼짐
					dfs(cy,cx,d+1);
				}
			}
		}
	}









	static class Grass{
		int y;
		int x;
		int d;
		public Grass(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}

}
