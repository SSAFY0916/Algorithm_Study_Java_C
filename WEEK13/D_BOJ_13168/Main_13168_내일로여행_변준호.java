import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_13168_내일로여행_변준호{
	/*
	 *   ‘Subway’, ‘Bus’, ‘Taxi’, ‘Airplane’, ‘KTX’, ‘S-Train’, ‘V-Train’, ‘ITX-Saemaeul’, ‘ITX-Cheongchun’, ‘Mugunghwa’ 
	 *     x      x        x          x       x          반값         반값             무료            무료		      무료 
	 */
	static final int INF = 1000000;
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][N];
		int nail[][] = new int[N][N];
		st = new StringTokenizer(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			map.put(st.nextToken(), i);
		}
		int M = Integer.parseInt(br.readLine());
		int travel[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			travel[i] = map.get(st.nextToken());
		}
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				arr[i][k] = INF;
				nail[i][k] = INF;
			}
		}
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			String sodan = st.nextToken();
			String start = st.nextToken();
			String end = st.nextToken();
			int price = Integer.parseInt(st.nextToken());
			int discount = cal(sodan,price*2);
			if(arr[map.get(start)][map.get(end)]>price*2) {
				arr[map.get(start)][map.get(end)]=price*2;
				arr[map.get(end)][map.get(start)]=price*2;
			}
			if(nail[map.get(start)][map.get(end)]>discount) {
				nail[map.get(start)][map.get(end)]=discount;
				nail[map.get(end)][map.get(start)]=discount;
			}
			
		}
		//경출도
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				if(i==k) continue;
				for(int j=0;j<N;j++) {
					if(i==j||k==j) continue;
					if(arr[i][j]>arr[i][k]+arr[k][j])  arr[i][j]=arr[i][k]+arr[k][j];
					if(nail[i][j]>nail[i][k]+nail[k][j])  nail[i][j]=nail[i][k]+nail[k][j];

				}
			}
		}
		int result = 0;
		int disresult = money*2;
//		System.out.println(K);
		for(int i=1;i<M;i++) {
			result += arr[travel[i-1]][travel[i]];
			disresult += nail[travel[i-1]][travel[i]];
		}
		if(result>disresult) System.out.println("Yes");
		else System.out.println("No");
	}
	private static int cal(String sodan, int price) {
		// TODO Auto-generated method stub
		if(sodan.equals("ITX-Saemaeul")||sodan.equals("ITX-Cheongchun")||sodan.equals("Mugunghwa")) {
			return 0;
		}else if(sodan.equals("S-Train")||sodan.equals("V-Train")) {
			return price/2;
		}else{
			return price;
		}
	}
}