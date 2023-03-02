import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2_변준호 {
	/*
	 * R : 빨간구슬
	 * B : 파란구슬
	 * 둘다 빠지면 안됨 
	 * 1. 빨구, 파구 위치저장
	 * 2. O 위치저장
	 */
	static int dy[] = {-1,1,0,0}; //상하 좌우 
	static int dx[] = {0,0,-1,1};
	static int N,M;
	static char arr[][];
	static Exit start;
	static boolean visit[][][][];
	static int gy,gx;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M][N][M]; //파공 , , 빨공 , ,
		int ry = 0,rx = 0,by = 0,bx = 0;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				arr[i][k] = str.charAt(k);
				if(arr[i][k]=='B') {
					by = i;
					bx = k;
				}else if(arr[i][k]=='R') {
					ry = i;
					rx = k;
				}else if(arr[i][k]=='O') {
					gy = i;
					gx = k;
				}
			}
		}
		start = new Exit(by,bx,ry,rx,0);
		int result = bfs();
		System.out.println(result);
		
	}
		
	private static int bfs() {
		// TODO Auto-generated method stub
		Queue<Exit> mq = new ArrayDeque<>();
		mq.add(start);
		visit[start.by][start.bx][start.ry][start.rx] = true;
		//방문처리
		while(!mq.isEmpty()) {
			Exit curr = mq.poll();
			int cby = curr.by;
			int cbx = curr.bx;
			int cry = curr.ry;
			int crx = curr.rx;
			int cnt = curr.cnt;
			if(cnt>9) {
				return -1;
			}
			for(int i=0;i<4;i++) {
				int cby1 = cby;
				int cbx1 = cbx;
				int cry1 = cry;
				int crx1 = crx;
				//파란 공
				boolean blueBall = false;
				boolean redBall = false;
				while(arr[cby1+dy[i]][cbx1+dx[i]] !='#') {
//					System.out.print(cby1);
					cby1=cby1+dy[i];
					cbx1=cbx1+dx[i];
					if(gy==cby1&&gx==cbx1) {
						blueBall = true;
						break;
					}
				}
				//빨간공
				while(arr[cry1+dy[i]][crx1+dx[i]] !='#') {
					cry1=cry1+dy[i];
					crx1=crx1+dx[i];
					if(gy==cry1&&gx==crx1) {
						redBall = true;
						break;
					}
				}
				//둘다빠지면 안됨
				if(blueBall) {
					continue;
				}else if(!blueBall&&redBall) {
					return cnt+1;
				}
				
				//공겹칠때 
				if(cby1==cry1&&cbx1==crx1) {
					//상하좌우
					if(i==0) {
						if(cby>cry) { 
							cby1++;
						}else {
							cry1++;
						}
					}else if(i==1) {
						if(cby>cry) { 
							cry1--;
						}else {
							cby1--;
						}
					}else if(i==2) {
						if(cbx>crx) { 
							cbx1++;
						}else {
							crx1++;
						}
					}else if(i==3) {
						if(cbx>crx) { 
							crx1--;
						}else {
							cbx1--;
						}
					}
				}
				
				if(!visit[cby1][cbx1][cry1][crx1]) {
					visit[cby1][cbx1][cry1][crx1] = true;
					mq.add(new Exit(cby1,cbx1,cry1,crx1,cnt+1));
//					System.out.println(cby1+" "+cbx1+" "+cry1+" "+crx1);
//					print();
				}
			}
		}
		return -1;
		
	}
//	public static void print() {
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<M;k++) {
//				System.out.print(arr[i][k]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	public static class Exit{
		int by;
		int bx;
		int ry;
		int rx;
		int cnt;
		public Exit(int by, int bx, int ry, int rx, int cnt) {
			super();
			this.by = by;
			this.bx = bx;
			this.ry = ry;
			this.rx = rx;
			this.cnt = cnt;
		}
		
	}

}
