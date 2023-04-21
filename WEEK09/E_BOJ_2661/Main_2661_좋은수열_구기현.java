import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String str) {
        if (str.length() == N){
            System.out.println(str);
            System.exit(0);
        }

        for (int i=1; i<=3; ++i) {
            String next = str + i;
            if (check(next)) backtracking(next);
        }
    }

    private static boolean check(String str) {
        int len = str.length();
        for (int i = 1; i <= len / 2; ++i) {
            String left = str.substring(len - i*2, len - i);
            String right = str.substring(len - i);
            if (left.equals(right)) return false;
        }

        return true;
    }

}
