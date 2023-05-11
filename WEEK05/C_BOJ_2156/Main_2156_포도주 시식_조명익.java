import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] grapes = new int[n];
        for (int i = 0; i < n; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(grapes[0]);
        } else if (n == 2) {
            System.out.println(grapes[0] + grapes[1]);
        } else {

            int[] memo = new int[n];
            memo[0] = grapes[0];
            memo[1] = grapes[0] + grapes[1];
            memo[2] = Math.max(grapes[2] + memo[0], Math.max(memo[1], grapes[2] + grapes[1]));
            for (int i = 3; i < n; i++) {
                memo[i] = Math.max(grapes[i] + memo[i - 2], Math.max(memo[i - 1], grapes[i] + grapes[i - 1] + memo[i - 3]));
            }

            System.out.println(memo[n - 1]);
        }
    }
}
