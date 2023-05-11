import java.io.*;
import java.util.*;

public class Main {

    static int TC;
    static int N;
    static int[] cards;
    static int[][] dp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; ++t) {
            N = Integer.parseInt(br.readLine());
            cards = new int[N+1];
            dp = new int[N + 2][N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; ++i) {
                cards[i] = Integer.parseInt(st.nextToken());
            } // 입력 완료

            sb.append(dual() + "\n");
        }
        System.out.println(sb);
    }

    private static int dual() {

        // true: 근우가 마지막으로 뽑음
        boolean turn = true;
        if (N % 2 == 0) turn = false;

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N - i + 1; ++j) {
                int row = j;
                int col = i + j -1;

                if (turn) dp[row][col] = Math.max(dp[row + 1][col] + cards[row], dp[row][col - 1] + cards[col]);
                else dp[row][col] = Math.min(dp[row + 1][col], dp[row][col - 1]);

            }
            turn = !turn;
        }
        return dp[1][N];
    }


}
