import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7579_앱_변준호 {
	/*
	 * 필요항 메모리 M 바이트를 확보하기 위한 앱 비활성화의 최소비용
	 * 1. 메모리
	 * 2. 비활성화 비용 
	 */
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int memory[] = new int[N+1];
		int cost[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int tmp = 0;
		for(int i=1;i<=N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			tmp = tmp+cost[i];
		}
		int dp[][] = new int[N+1][tmp+1];
		for(int i=1;i<=N;i++) {
			for(int k=1;k<=tmp;k++) {
				if(cost[i]>k) {
					dp[i][k] = dp[i-1][k];
				}else {
					dp[i][k] = Math.max(dp[i-1][k], memory[i] + dp[i-1][k-cost[i]]);
				}
			}
		}
		for(int k=1;k<=tmp;k++) {
			if(dp[N][k]>=M) {
				System.out.println(k);
				return;
			}
		}
	}
}
