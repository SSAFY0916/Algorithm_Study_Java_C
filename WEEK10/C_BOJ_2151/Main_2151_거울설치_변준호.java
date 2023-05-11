import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2151_거울설치_변준호 {
	/*
	 * 1. 각도 저장 class 2. 삼차원 visit 배열 3.
	 */
	static boolean visit[][][];
	static char arr[][];
	static int N;
	static int dy[] = {-1,0,1,0}; //상우하좌
	static int dx[] = {0,1,0,-1};
	static int endy,endx;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		int starty = 0;
		int startx = 0;
		endy = 0;
		endx = 0;
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int k = 0; k < N; k++) {
				arr[i][k] = str.charAt(k);
				if (flag && arr[i][k] == '#') {
					starty = i;
					startx = k;
					flag = false;
				} else if (!flag && arr[i][k] == '#') {
					endy = i;
					endx = k;
				}

			}
		}
		visit = new boolean[N][N][4];

//		System.out.println("ed"+endy+" "+endx);
//		System.out.println("st"+starty+" "+startx);
		bfs(starty,startx);
		System.out.println(result);
	}
	
	private static void bfs(int starty, int startx) {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(starty,startx,0,0));
		mq.add(new Node(starty,startx,1,0));
		mq.add(new Node(starty,startx,2,0));
		mq.add(new Node(starty,startx,3,0));
		visit[starty][startx][0] = true;
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			int cy = tmp.y;
			int cx = tmp.x;
			while(true) {
//				System.out.println(cy+" "+cx);
				cy = cy+dy[tmp.d];
				cx = cx+dx[tmp.d];
				if(cy<0||cx<0||cy>=N||cx>=N) {
					break;
				}
				if(arr[cy][cx]=='*') {
					break;
				}
				if(cy==endy&&cx==endx) {
					result = Math.min(result, tmp.cnt);
				}
				if(arr[cy][cx]=='!') {
					if(!visit[cy][cx][tmp.d]) {
//						System.out.println(cy+" "+cx+" "+tmp.cnt);
						mq.add(new Node(cy,cx,(tmp.d+1)%4,tmp.cnt+1));
						mq.add(new Node(cy,cx,(tmp.d+3)%4,tmp.cnt+1));
						visit[cy][cx][tmp.d] = true;
					}
					
				}
			}
		}
	}







	static class Node{
		int y;
		int x;
		int d;
		int cnt;
		public Node(int y, int x, int d, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.cnt = cnt;
		}
		
	}
}