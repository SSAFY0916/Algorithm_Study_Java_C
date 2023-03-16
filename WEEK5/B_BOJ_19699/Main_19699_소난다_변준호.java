import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19699_소난다_변준호 {
	static int N,M;
	static int arr[];
	static List<Integer> list = new ArrayList<>();
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		back(0,0,0);
		Collections.sort(list);
		if(list.size()==0) {
			System.out.println(-1);
		}else {
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
		}		
	}
	private static void back(int def,int start, int num) {
		// TODO Auto-generated method stub
		if(def==M) {
			//소수판별
			if(!check(num)) {
				if(!set.contains(num)) {
					set.add(num);
					list.add(num);
				}
			}
			return;
		}
		for(int i=start;i<N;i++) {
			back(def+1,i+1,num+arr[i]);
		}
		
	}
	private static boolean check(int num) {
		// TODO Auto-generated method stub
		boolean prime[] = new boolean[num+1];
		prime[0] = prime[1] = true;
		for(int i=2;i*i<=num;i++) {
			if(!prime[i]) {
				for(int k=i*i;k<=num;k=k+i) {
					prime[k] = true;
				}
			}
		}
//		System.out.println(Arrays.toString(prime));
		return prime[num];
	}
}
