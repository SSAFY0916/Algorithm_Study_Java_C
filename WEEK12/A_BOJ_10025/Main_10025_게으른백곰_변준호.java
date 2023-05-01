import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10025_게으른백곰_변준호 {
	/*
	 * n -> 얼음 
	 * k -> 손 
	 * g x -> 양 , 좌표 
	 */
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			arr[b] = a;
		}
		//누적합 구하기 
		for(int i=1;i<1000001;i++) {
			arr[i] = arr[i] + arr[i-1];
		}
		if(2*K>1000000) {
			System.out.println(arr[1000000]);
			return;
		}
		int result = arr[2*K];
		//최대값 구하기 
		for(int i=2*K+1;i<1000001;i++) {
			result = Math.max(arr[i]-arr[i-2*K-1], result);
		}
		System.out.println(result);
	
	}
}
