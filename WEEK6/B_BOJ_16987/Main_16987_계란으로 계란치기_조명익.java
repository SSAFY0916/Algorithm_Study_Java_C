import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] durability = new int[n];
        int[] weights = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weights[i] = Integer.parseInt(st.nextToken());
        }

        backTrack(0, n, durability, weights, 0);

        System.out.println(result);
    }

    private static void backTrack(int depth, int n, int[] durability, int[] weights, int count) {
        result = Math.max(result, count);

        if (depth == n) {
            return;
        }

        if (durability[depth] <= 0) {
            backTrack(depth + 1, n, durability, weights, count);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (depth != i && durability[i] > 0) {
                durability[i] -= weights[depth];
                durability[depth] -= weights[i];

                int temp = 0;
                if (durability[i] < 1) {
                    temp++;
                }
                if (durability[depth] < 1) {
                    temp++;
                }

                backTrack(depth + 1, n, durability, weights, count + temp);

                durability[i] += weights[depth];
                durability[depth] += weights[i];
            }
        }
    }
}
