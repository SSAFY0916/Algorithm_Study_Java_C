import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1644_소수의연속합_오승기 {
	
	static int N,cnt;
	static boolean[] primeTable;
	static List<Integer> primeList;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		primeTable = new boolean[N+1];
		primeList = new ArrayList<Integer>();
		cnt = 0;
		
		if(N == 1) {		
			System.out.println(cnt);
			System.exit(0);
		}
		
		getPrime();
		
		getSumCnt();
		
		System.out.println(cnt);
		

	}

	private static void getSumCnt() {
		// TODO Auto-generated method stub
		int sIdx = 0; // 첫 소수
		int eIdx = 1; // 두 번째 소수
		while(sIdx <= eIdx) {
			int sum = 0;
			for(int i = sIdx; i < eIdx; i++) {
				sum += primeList.get(i);
			}
			
			if(sum < N && eIdx < primeList.size()) {
				eIdx++;
			} else if(sum == N) {
				cnt++;
				sIdx++;
			} else {
				sIdx++;
			}
			
		}
	}
	

	private static void getPrime() {
		// TODO Auto-generated method stub
		primeTable[0] = primeTable[1] = true; // true는  소수가 아님
		for(int i = 2; i <= N; i++) {
			if(!primeTable[i]) { // 소수일때
				for(int j = 2*i; j <= N; j+=i) {
					primeTable[j] = true;
				}
			}
		}
		
		
		for(int i = 0; i <= N; i++) {
			if(!primeTable[i]) {
				primeList.add(i);
			}
		}
	}

}
