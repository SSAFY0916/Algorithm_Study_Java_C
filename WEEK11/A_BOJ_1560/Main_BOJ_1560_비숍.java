import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_BOJ_1560_비숍 {
	
	static BigInteger N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = new BigInteger(br.readLine());
		if(N.intValue() == 1) {
			System.out.println(1);
			System.exit(0);
		}
		System.out.println(N.multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(2)));
	}

}
