import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179_불_변준호{
	/*
	 * # 벽 --> -1
	 * . 공간 --> 0
	 * J 지훈 --> visit[] Node 
	 * F 불  --> 1,2,3,4, 미리 움직여 놓기 
	 */
	static int N,M;
	static int arr[][];
	static int visit[][];
	static Queue<Node> mq = new ArrayDeque<>();
	static Queue<Node> jihoon = new ArrayDeque<>();
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,1,-1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				if(str.charAt(k)=='.') {
					arr[i][k] = 0;
				}else if(str.charAt(k)=='F') {
					arr[i][k] = 1;
					mq.add(new Node(i,k));
				}else if(str.charAt(k)=='J') {
					jihoon.add(new Node(i,k));
					visit[i][k] = 1;
				}else {
					arr[i][k] = -1; //지나갈 수 없는 곳 
				}
			}
		}
		//불 지르기
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<M&&arr[cy][cx]==0) {
					arr[cy][cx] = arr[tmp.y][tmp.x]+1;
					mq.add(new Node(cy,cx));
				}
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<M;k++) {
//				System.out.print(arr[i][k]);
//			}
//			System.out.println();
//		}
		//지훈 이동시키기 
		while(!jihoon.isEmpty()) {
			Node tmp = jihoon.poll();
			if(tmp.y==0||tmp.x==0||tmp.y==N-1||tmp.x==M-1) {
				System.out.println(visit[tmp.y][tmp.x]);
				return;
			}
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<M&&visit[cy][cx]==0&&arr[cy][cx]!=-1) {
					if((visit[tmp.y][tmp.x]+1<arr[cy][cx])||arr[cy][cx]==0) {
						visit[cy][cx] = visit[tmp.y][tmp.x]+1;
						jihoon.add(new Node(cy,cx));
					}
				}
			}
		}

		System.out.println("IMPOSSIBLE");
		
	}
	
	
	
	
	
	static class Node{
		int y;
		int x;
		
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}