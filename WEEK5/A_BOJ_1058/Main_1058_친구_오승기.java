import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[][] adjMatrix;
	static int cnt;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				if(str.charAt(j) == 'Y') {					
					adjMatrix[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(i != j && adjMatrix[i][j]) { // 1-친구
					cnt++;
				} else if(i != j && !adjMatrix[i][j]) { // 2-친구 여부 확인
					for(int k = 0; k < N; k++) {
						if(k != j && adjMatrix[j][k] && adjMatrix[k][i]) {
							cnt++;
							break;
						}
					}
				}
			}
			max = Math.max(max, cnt);
		} 

		System.out.println(max);

	}



}