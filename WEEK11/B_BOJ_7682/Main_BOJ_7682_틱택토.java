import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_7682_틱택토 {
	
	static char[][] board;
	static int x,o,empty;
	static boolean[][] visited;
	static char firstMade;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		while(!(str = br.readLine()).equals("end")) {
			board = new char[3][3];
			x = 0; o = 0; empty = 0;
			visited = new boolean[3][3];
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					board[i][j] = str.charAt((i*3)+j);
					if(board[i][j] == 'O') {
						o++;
					} else if(board[i][j] == 'X') {
						x++;
					} else {
						empty++;
					}
				}
			}
			
			// x가 o보다 2개 이상 많을때 (불가능)
			if(x > o+1) {
				sb.append("invalid\n");
				continue;				
			} else if(o > x) { // o가 x보다 1개 이상 많을떄 (불가능)
				sb.append("invalid\n");
				continue;								
			}

			int madeCnt = madeChk();
//			System.out.println("----------------");
//			System.out.println(madeCnt);
			
			if(madeCnt == -1) {				
				sb.append("invalid\n");
				continue;				
			}
			
			if(firstMade == 'O' && x != o) {
				sb.append("invalid\n");
				continue;								
			} 
			
			if(firstMade == 'X' && x <= o) {
				sb.append("invalid\n");
				continue;												
			}
		
			if(madeCnt > 1) {
				sb.append("invalid\n");
				continue;				
			}
			
			if(madeCnt == 0 && empty > 0) { // 메이드X/빈공간 존재 (불가능)
				sb.append("invalid\n");
				continue;
			}
			
//			if(madeCnt == 1 && o > x) { // 메이드O/ O가 X보다 많을때 (불가능)
//				sb.append("invalid\n");
//				continue;				
//			}
			
			sb.append("valid\n");
			
		}
		
		System.out.println(sb.toString());

	}

	private static int madeChk() {
		// TODO Auto-generated method stub
		int cnt = 0;
		boolean crossChk = false;
		firstMade = ' ';
		// 가로,세로 체크
		for(int i = 0; i < 3; i++) {
			if(board[i][0] != '.' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				if(firstMade == ' ') {
					firstMade = board[i][0];
				} else {
					if(firstMade != board[i][0]) {
						return -1;
					}
				}
				
				for(int j = 0; j < 3; j++) {
					if(!visited[i][j]) {
						visited[i][j] = true;
					} else {
						crossChk = true;
					}
				}
				
				if(!crossChk) {
					//System.out.println("1지점");
					cnt++;
				} else {
					crossChk = false;
				}
			}
			
			if(board[0][i] != '.' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				if(firstMade == ' ') {
					firstMade = board[0][i];
				} else {
					if(firstMade != board[0][i]) {
						return -1;
					}
				}
				
				for(int j = 0; j < 3; j++) {
					if(!visited[j][i]) {
						visited[j][i] = true;
					} else {
						crossChk = true;
					}
				}
				
				if(!crossChk) {
					//System.out.println("2지점");
					cnt++;
				} else {
					crossChk = false;
				}
			}
		}
		
		// 대각선 체크
		if(board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			if(firstMade == ' ') {
				firstMade = board[0][0];
			} else {
				if(firstMade != board[0][0]) {
					return -1;
				}
			}
			
			for(int i = 0; i < 3; i++) {
				if(!visited[i][i]) {
					visited[i][i] = true;
				} else {
					crossChk = true;
				}
			}
			
			if(!crossChk) {
				//System.out.println("3지점");
				cnt++;
			} else {
				crossChk = false;
			}
		}
		
		if(board[0][2] != '.' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			if(firstMade == ' ') {
				firstMade = board[0][2];
			} else {
				if(firstMade != board[0][2]) {
					return -1;
				}
			}
			
			for(int i = 0; i < 3; i++) {
				if(!visited[i][2-i]) {
					visited[i][2-i] = true;
				} else {
					crossChk = true;
				}
			}
			
			if(!crossChk) {	
				//System.out.println("4지점");
				cnt++;
			} else {
				crossChk = false;
			}
		}
		
		return cnt;
		
	}

}