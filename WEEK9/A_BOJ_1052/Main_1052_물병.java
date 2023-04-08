import java.util.Scanner;

public class Main_1052_물병{
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int result = 0;
		while(true) {
			int tmp = N;
			int tmpresult = 0;
			while(tmp>0) {
				if(tmp%2==1) {
					tmpresult++;
					tmp = tmp>>1;
				}else {
					tmp = tmp>>1;
				}
			}
			if(tmpresult<=K) {
				break;
			}
			N++;
			result++;
		}
		System.out.println(result);
	}
}