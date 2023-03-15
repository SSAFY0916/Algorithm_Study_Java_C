import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609_회문_변준호{
	public static void main(String[] agrs) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			int a = pelin(str);
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}
	// 투 포인터로 정렬 
	private static int pelin(String str) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = str.length()-1;
		int pelin = 0;
		while(start<=end) {
			if(str.charAt(start)==str.charAt(end)) {
				start++;
				end--;
			}
			else {
				int tmpS = start+1;
				int tmpE = end;
				int pelin1 =1;
				while(tmpS<=tmpE) {
					if(str.charAt(tmpS)==str.charAt(tmpE)) {
						tmpS++;
						tmpE--;
					}else {
						pelin1 =  2;
						break;
					}
				}
				tmpS = start;
				tmpE = end-1;
				int pelin2 =1;
				while(tmpS<=tmpE) {
					if(str.charAt(tmpS)==str.charAt(tmpE)) {
						tmpS++;
						tmpE--;
					}else {
						pelin2 =  2;
						break;
					}
				}
				return Math.min(pelin1, pelin2);
				
			}
		}
		return pelin;
	}
}