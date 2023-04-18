import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1520_내리막길_변준호 {
	// 0 0 -> N-1,M-1 -> 내리막으로만 
	static int N,M;
	static int arr[][];
	static int dp[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], -1);
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = dfs(0,0);

		System.out.println(cnt);
	}
	private static int dfs(int y, int x) {
		// TODO Auto-generated method stub
		if(y==N-1&&x==M-1) {
			dp[y][x] =1;
			return 1;
		}
		
		if(dp[y][x]!=-1) {
			return dp[y][x];
		}
		dp[y][x] =0;
		for(int i=0;i<4;i++) {
			int cy = y+dy[i];
			int cx = x+dx[i];
//			System.out.println(cy+" "+cx);
			if(cy>=0&&cx>=0&&cy<N&&cx<M) {
				if(arr[y][x]>arr[cy][cx]) {
					dp[y][x] = dp[y][x]+dfs(cy,cx); 
				}
			}
		}
		
		return dp[y][x];
	}
}
