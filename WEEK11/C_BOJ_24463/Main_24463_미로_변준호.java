import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24463_미로_변준호{
	static int N,M;
	static char[][] arr;
	static int min = Integer.MAX_VALUE;
	static int endy,endx;
	static boolean visit[][];
	static char[][] result;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		result = new char[N][M];
		visit = new boolean[N][M];
		int startx = 0;
		int starty = 0;
		endx = 0;
		endy = 0;
		boolean flag = true;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				arr[i][k] = str.charAt(k);
				if(i==0||k==0||i==N-1||k==M-1) {
					if(arr[i][k]=='.'&&flag) {
						starty = i;
						startx = k;
						flag = false;
					}else if(arr[i][k]=='.'&&!flag) {
						endy = i;
						endx = k;
					}
				}
			}
		}
		visit[starty][startx] = true;
		dfs(starty,startx,0);
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
//				System.out.print(result[i][k]);
				sb.append(result[i][k]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	private static void dfs(int y, int x, int def) {
		// TODO Auto-generated method stub
//		System.out.println(y+" "+x);
		if(def>min) {
			//가지치기
			return;
		}
		if(y==endy&&x==endx) {
			if(min>def) {
				min = def;
				//결과 그림그리기
//				System.out.println(def);
				draw();
			}
			return;
		}
		for(int i=0;i<4;i++) {
			int cy = dy[i] + y;
			int cx = dx[i] + x;
			if(cy>=0&&cx>=0&&cy<N&&cx<M&&arr[cy][cx]=='.') {
				if(!visit[cy][cx]) {
					visit[cy][cx] = true;
					dfs(cy,cx,def+1);
					visit[cy][cx] = false;
				}
			}
		}
	}
	private static void draw() {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]=='+') {
					result[i][k] = '+';
				}else if(arr[i][k]=='.'&&!visit[i][k]) {
					result[i][k] = '@';
				}else {
					result[i][k] = '.';
				}
			}
		}
	}
}