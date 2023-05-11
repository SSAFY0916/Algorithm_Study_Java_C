import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물_변준호 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[M];
		int map[][] = new int[N][M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<M;i++) {
			for(int k=0;k<arr[i];k++) {
				map[k][i] = 1;
			}
		}
		int result = 0;
		for(int i=0;i<N;i++) {
			int start = 0;
			int tmp = 0;
			for(int k=0;k<M;k++) {
				if(start==1&&map[i][k]==0) {
					tmp++;
				}
				else if(start==1&&map[i][k]==1) {
					result = result + tmp;
					tmp = 0;
				}else if(start==0&&map[i][k]==1) {
					start = 1;
				}
			}
		}
		System.out.println(result);
		
	}

}
