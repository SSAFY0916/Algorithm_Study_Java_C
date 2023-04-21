import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16987_계란으로계란치기_변준호 {
	// 내구도 : S 
	// 무게 : W
	static int N;
	static Egg egg[];
	static int result = 0;
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		egg = new Egg[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			egg[i] = new Egg(s,w);
		}
		//가장 왼쪽 계란 듬 
		back(0);//손에 든 계란
		System.out.println(result);
	}
	
	
	
	
	private static void back(int left) {
		// TODO Auto-generated method stub
		if(left == N) {
			//최대값 계산
			int tmp = 0;

			for(int i=0;i<N;i++) {
				if(egg[i].S<=0) {
					tmp++;
				}
			}
			result = Math.max(result, tmp);
			return;
		}
		if(egg[left].S<=0) {
//			내구도 없는 계란 일 떄 다음계란으로 넘어가기
			back(left+1);
			return;
		}
		boolean flag = false;
		for(int i=0;i<N;i++) {
			if(i==left) continue;
			if(egg[i].S>0) {
//				System.out.println(left+" "+i);
				flag = true;
				//기존 값 저장 
				int leftW = egg[left].S;
				int iW = egg[i].S;
				
				egg[left].S = egg[left].S - egg[i].W;
				egg[i].S = egg[i].S - egg[left].W;

				back(left+1);
				//기존 값 복원 
				egg[left].S = leftW;
				egg[i].S = iW;
			}
		}
		if(!flag) {
//			flag == false 라면 계란을 안쳣다는 뜻이기 때문에 바로 결과 값 확인하러 가기
			back(N);
		}
	}




	static class Egg{
		int S;
		int W;
		public Egg(int s, int w) {
			super();
			S = s;
			W = w;
		}
		@Override
		public String toString() {
			return "Egg [S=" + S + ", W=" + W + "]";
		}
		
		
		
	}
}
