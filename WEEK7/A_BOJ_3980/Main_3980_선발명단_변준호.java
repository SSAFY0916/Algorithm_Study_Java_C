import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3980_선발명단_변준호{
	static int arr[][];
	static boolean player[];   // 선수 선발 했는지 
	static int result = 0;
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test = 1; test<=t;test++) {
			player = new boolean[11];
			arr = new int[11][11];
			for(int i=0;i<11;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0;k<11;k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			back(0,0);
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
	}
	private static void back(int def, int sum) {
		// TODO Auto-generated method stub
		if(def==11) {
			result = Math.max(result, sum);
			return;
		}
		for(int i=0;i<11;i++) {
			if(!player[i]&&arr[i][def]>0) {
				player[i] = true;
				back(def+1,sum+arr[i][def]);
				player[i] = false;
			}
		}
	
	}
}