import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        int[][] players = new int[11][11];

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    players[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            sum = 0;
            backTrack(players, 0, 0, 0);

            result.append(sum).append('\n');
        }

        System.out.print(result);
    }

    private static void backTrack(int[][] players, int depth, int flag, int sum) {
        if (depth == 11) {
            Main.sum = Math.max(Main.sum, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (players[i][depth] > 0 && (flag & 1 << i) == 0) {
                backTrack(players, depth + 1, flag | 1 << i, sum + players[i][depth]);
            }
        }
    }
}
