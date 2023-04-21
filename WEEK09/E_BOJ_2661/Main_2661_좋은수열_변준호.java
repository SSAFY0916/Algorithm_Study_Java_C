import java.util.Scanner;

public class Main_2661_좋은수열_변준호 {
	static int N;
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String str = "1";
		back(str);
	}
	private static void back(String str) {
		// TODO Auto-generated method stub
		if(str.length()==N) {
			System.out.println(str);
			System.exit(0);
		}
		for(int i=1;i<=3;i++) {
			if(check(str+i)) {
				back(str+i);
			}
		}
	}
	private static boolean check(String str) {
		// TODO Auto-generated method stub
		int size = str.length()/2;
		
		for(int i=1;i<=size;i++) {
				
			String tmp = str.substring(str.length()-i);
			String tmp2 = str.substring(str.length()-i-i,str.length()-i);
//			System.out.println(tmp+" "+tmp2);
			if(tmp.equals(tmp2)) {
				return false;
			}
		}
		return true;
	}
}
