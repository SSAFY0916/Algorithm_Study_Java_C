import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_1560_비숍_신재혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger b = new BigInteger(br.readLine());
        if(b.equals(new BigInteger("1"))){
            b = new BigInteger("1");
        }else{
            b = b.multiply(new BigInteger("2")).add(new BigInteger("-2"));
        }

        System.out.println(b);
    }
}