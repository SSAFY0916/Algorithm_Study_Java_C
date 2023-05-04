import java.math.BigInteger;
import java.util.Scanner;

public class Main_1560_비숍_변준호 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.next();
		if(tmp.equals("1")) {
			System.out.println(1);
		}else {
			BigInteger big1 = new BigInteger(tmp);
			BigInteger two1 = new BigInteger("2");
			BigInteger big2 = big1.subtract(two1);
			BigInteger result = big1.add(big2);
			System.out.println(result);
		}
	}
}
