import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3980_선발명단_오승기 {
	
	static int C,sum;
	static int[][] positionBoard;
	static boolean[] selected;
	static int max; 

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		C = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= C; tc++) {
			positionBoard = new int [11][11];
			selected = new boolean[11];
			max = Integer.MIN_VALUE;
			sum = 0;
			
			for(int i = 0; i < 11; i++) { // 배열 만들기
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 11; j++) {
					positionBoard[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			getMax(0);
			
			
			System.out.println(max);
		}
		
		
	}

	private static void getMax(int playerNum) {
		// TODO Auto-generated method stub
		
		if(playerNum == 11) {
			max = Math.max(max, sum);
			return;
		}
		
		
		for(int i = 0; i < 11; i++) {
			if(!selected[i] && positionBoard[playerNum][i] != 0) {
				selected[i] = true;
				sum += positionBoard[playerNum][i];
				getMax(playerNum+1);
				selected[i] = false;
				sum -= positionBoard[playerNum][i];
			}
		}
	}

}
