package solved;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_17609_회문 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		loop: for (int tc = 0; tc < T; tc++) { // 0:회문 / 1:유사회문 / 2:일반문자열
			String str = br.readLine();
			int i = 0;
			int j = str.length() - 1;
			while (i < j) {
				if (str.charAt(i) == str.charAt(j)) {
					i++;
					j--;
					continue;
				} else {
					
					boolean flag1 = check(i+1,j,str);
					boolean flag2 = check(i,j-1,str);
					
					if(flag1 || flag2) {
						sb.append(1).append("\n");
						continue loop;
					} else if(!flag1 && !flag2) {
						sb.append(2).append("\n");
						continue loop;
					}
					
				}

			}

			sb.append(0).append("\n");
			
		}

		System.out.println(sb.toString());
	}

	private static boolean check(int i, int j,String str) {
		// TODO Auto-generated method stub
		while(i < j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
				continue;
			} else {
				return false;
			}
		}
		
		return true;
	}

}
