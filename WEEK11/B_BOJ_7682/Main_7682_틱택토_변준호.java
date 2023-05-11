import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_7682_틱택토_변준호{
	static char arr[][];
	static boolean flag = true;
	static boolean result = true;
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) {
				break;
			}
			arr = new char[9][9];
			for(int i=0;i<3;i++) {
				for(int k=0;k<3;k++) {
					arr[i][k] = str.charAt(i*3+k);
				}
			}
			char tic[][] = new char[3][3];
			for(int i=0;i<3;i++) {
				Arrays.fill(tic[i], '.');
			}
			flag = false;
			result = false;
			dfs(0,tic);//def, 배열,
			if(result) {
				sb.append("valid").append("\n");
			}else {
				sb.append("invalid").append("\n");
			}
		}
		System.out.println(sb);
		
		//
	}
	private static void dfs(int def, char[][] tictac) {
		// TODO Auto-generated method stub
		
		if(flag) { //가지치기
			return;
		}
		
		if(same(tictac)) { // 모양같은지 
			if(!finish(tictac)) {
				flag = true;
				return;
			}else {
				flag = true;
				result = true;
				return;
			}
			
		}
		if(finish(tictac)) { // 게임 끝났는지 
			return;
		}
		if(def==9) {
//			print(tictac);
			return;
		}
		
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				if(tictac[i][k]=='.') {
					if(def%2==0) {
						if(arr[i][k]=='X') {
							tictac[i][k]='X';
							dfs(def+1,tictac);
							tictac[i][k]='.';
						}
						
					}
					else {
						if(arr[i][k]=='O') {
							tictac[i][k]= 'O';
							dfs(def+1,tictac);
							tictac[i][k]='.';
						}
					}
				}
			}
		}
	}
	
	private static void print(char[][] tictac) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				System.out.print(tictac[i][k]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static boolean same(char[][] tictac) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				if(tictac[i][k]!=arr[i][k]) {
					return false;
				}
			}
		}
		return true;
	}
	private static boolean finish(char[][] tictac) {
		// TODO Auto-generated method stub
		//가로 세로 대각 
		int tmp = 0;
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				if(tictac[i][k]=='.') {
					tmp++;
				}
			}
		}
		if(tmp==0) {
			return true;
		}
		for(int i=0;i<3;i++) {
			if(tictac[i][0]!='.'&&tictac[i][0]==tictac[i][1]&&tictac[i][1]==tictac[i][2]) {
				return true;
			}
			if(tictac[0][i]!='.'&&tictac[0][i]==tictac[1][i]&&tictac[1][i]==tictac[2][i]) {
				return true;
			}
		}
		if(tictac[0][0]!='.'&&tictac[0][0]==tictac[1][1]&&tictac[1][1]==tictac[2][2]) {
			return true;
		}
		if(tictac[0][2]!='.'&&tictac[1][1]==tictac[0][2]&&tictac[1][1]==tictac[2][0]) {
			return true;
		}
		return false;
	}
}