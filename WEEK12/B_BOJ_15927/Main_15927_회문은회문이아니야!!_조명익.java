import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
        reference : https://degurii.tistory.com/39
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int length = s.length();

        if (isNotPalindrome(s)) {
            System.out.println(length);
            return;
        }

        if (isSame(s)) {
            System.out.println(-1);
        } else {
            System.out.println(length - 1);
        }
    }

    private static boolean isNotPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSame(String s) {
        int length = s.length();
        char c = s.charAt(0);
        for (int i = 1; i < length; i++) {
            if (c != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
