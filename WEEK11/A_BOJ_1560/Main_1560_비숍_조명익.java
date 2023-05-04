import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bigInteger = new BigInteger(br.readLine());

        if (bigInteger.equals(new BigInteger("1"))) {
            System.out.println(1);
            return;
        }

        System.out.println(new BigInteger("2").multiply(bigInteger).subtract(new BigInteger("2")));
    }
}
