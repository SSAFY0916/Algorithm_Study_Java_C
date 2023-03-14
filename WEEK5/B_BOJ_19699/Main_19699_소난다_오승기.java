import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_19699_소난다_오승기 {
	
	static int N,M,max;
	static int[] arr,result;
	static boolean[] visited;
	static boolean[] isPrime;
	static Set<Integer> primeList;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 소 수
		M = Integer.parseInt(st.nextToken()); // 고를 소 수
		
		arr = new int[N];
		visited = new boolean[N];
		result = new int[M];
		primeList = new TreeSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		max = 1; // 인덱스 1부터 줄것이므로
		for(int i = N-1; i >= (N-M); i--) {
			max += arr[i];
		}
		
		isPrime = new boolean[max];
		Arrays.fill(isPrime, true);
		primeCheck();
		
		comb(0,0);
		//Collections.sort(primeList);
		
		if(primeList.size() == 0) { // 값 없으면 -1
			System.out.println(-1);
			System.exit(0);
		}
		
		Integer[] temp = new Integer[primeList.size()];
		primeList.toArray(temp);
		
		for(int i = 0; i < primeList.size(); i++) {
			System.out.print(temp[i] + " ");
		}
		
	}

	private static void comb(int start, int depth) {
		// TODO Auto-generated method stub
		if(depth == M) {
			int sum = 0;
			for(int i = 0; i < M; i++) {
				sum += result[i];
			}
			
			if(isPrime[sum]) {
				primeList.add(sum);
			}
			
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				comb(i+1,depth+1);
				visited[i] = false;
			}
		}
	}

	private static void primeCheck() {
		// TODO Auto-generated method stub

		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i = 2; i < max; i++) {
			for(int j = i*i; j < max; j+=i) {
				isPrime[j] = false;
			}
		}
	}

}
