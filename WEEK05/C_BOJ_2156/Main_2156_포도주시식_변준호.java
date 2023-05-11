import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식_변준호 {
	//연속 두잔 ok
	//3잔 안됨
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int dp[][] = new int[2][N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0][0] = 0;dp[1][0] = 0; // 0 연속 x -> 1 연속 O
		if(N==1) {
			System.out.println(arr[1]);
			return;
		}
		dp[0][1] = arr[1]; dp[1][1] = arr[1];
		dp[0][2] = arr[2]; dp[1][2] = arr[2]+arr[1];
		for(int i=3;i<=N;i++) {
			dp[0][i] = arr[i] + Math.max(Math.max(dp[1][i-2], dp[1][i-3]), Math.max(dp[0][i-3], dp[0][i-2]));
			dp[1][i] = dp[0][i-1]+arr[i];
		}
		System.out.println(Math.max(Math.max(dp[1][N], dp[0][N]),Math.max(dp[1][N-1], dp[0][N-1])));
	
	}
}
