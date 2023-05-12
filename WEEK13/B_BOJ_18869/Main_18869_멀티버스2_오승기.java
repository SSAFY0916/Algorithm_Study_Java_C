import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_18869_멀티버스2_오승기 {
	
	static int M,N,cnt;
	static int[][] planet;
	static List<Integer>[] ranking;
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cnt = 0;
		planet = new int[M][N];
		ranking = new ArrayList[M];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Set<Integer> set = new HashSet<Integer>();
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				planet[i][j] = temp;
				set.add(temp); // 중복제거
			}
			
			ranking[i] = new ArrayList<Integer>(set); // 정렬한 값 리스트에 넣기
			Collections.sort(ranking[i]); // 리스트 정렬
			
			
		}
		
		// 압축
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) { // 이분탐색으로 planet[i][j]의 랭킹을 다시 planet[i][j]로 넣어준다
				planet[i][j] = Collections.binarySearch(ranking[i], planet[i][j]);
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = i+1; j < M; j++) { // i와 그 후 부터 비교
				if(Arrays.equals(planet[i], planet[j])) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
