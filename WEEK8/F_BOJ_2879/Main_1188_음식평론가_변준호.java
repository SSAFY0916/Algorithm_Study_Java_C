import java.util.Scanner;

public class Main_1188_음식평론가_변준호 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>=b&&a%b==0) {
			System.out.println(0);
		}else {
		System.out.println(b-gcd(a,b));
		}
	}
	
	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
