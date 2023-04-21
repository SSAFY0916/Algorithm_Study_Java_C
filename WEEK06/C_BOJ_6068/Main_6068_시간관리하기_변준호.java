import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_6068_시간관리하기_변준호{
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}else {
					return o1[1]-o2[1];
				}
			}
			
		});
		int time = -1;
		for(int i=0;i<=arr[0][1]-arr[0][0];i++) {
			int result = i;
			for(int k=0;k<N;k++) {
				if(arr[k][1]<result+arr[k][0]) {
					System.out.println(time);
					return;
				}else {
					result = result+arr[k][0];
					System.out.println(result);
				}
			}
			time ++;
		}
		System.out.println(time);
	}
}