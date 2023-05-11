import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15927_회문은회문이아니야 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		// str이 팰린드롬인지 체크
		if(isAllSame(str)) {
			System.out.println(-1);
			System.exit(0);
		}
		
		if(isPalindrome(str)) {
			System.out.println(str.length()-1);			
		} else {			
			System.out.println(str.length());			
		}

	}

	private static boolean isAllSame(String str) {
		// TODO Auto-generated method stub
		char c = str.charAt(0);
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) != c) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = str.length()-1;
		while(i < j) {
			if(str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
				continue;
			}
			return false;
		}
		return true;
	}

}