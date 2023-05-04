import java.util.Scanner;

public class Main_15927_회문은회문아니야_변준호 {
	
	public static void main(String[] agrs){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean flag = true;
		int len = str.length();
		for(int i=0;i<len;i++) {
			if(str.charAt(i)!=str.charAt(len-1)) {
				System.out.println(len-i);
				return;
			}else {
				//같다면
				if(flag) {
					//모든 문자열이 같을때는 바로 -1 리턴
					for(int k=0;k<len-1;k++) {
						if(str.charAt(k)!=str.charAt(k+1)) {
							flag = false;
							break;
						}
					}
					if(flag) {
						System.out.println(-1);
						return;
					}
				}
				int tmplen = len-1;
				int k = i;
				while(k<=tmplen) {
					if(str.charAt(k)==str.charAt(tmplen)) {
						tmplen--;
						k++;
					}else {
						System.out.println(len-i);
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
