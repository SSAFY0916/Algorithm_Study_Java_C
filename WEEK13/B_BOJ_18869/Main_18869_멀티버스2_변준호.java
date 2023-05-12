import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18869_멀티버스2_변준호{
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int arr[][] = new int[M][N];
		
		for(int i=0;i<M;i++) {
			int sort[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				sort[k] = arr[i][k] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(sort);
			HashMap<Integer,Integer> map = new HashMap<>();
			for(int k=0;k<N;k++) {
				if(!map.containsKey(sort[k])) {
					map.put(sort[k],k+1);
				}
			}
			for(int k=0;k<N;k++) {
				arr[i][k] = map.get(arr[i][k]);
			}
		}
		
		int result = 0;
		for(int i=0;i<M-1;i++) {
			for(int k=i+1;k<M;k++) {
				boolean flag = true;
				for(int z=0;z<N;z++) {
					if(arr[i][z]!=arr[k][z]) {
						flag = false;
					}
				}
				if(flag) result++;
			}
		}
		
		
		System.out.println(result);
	}
}