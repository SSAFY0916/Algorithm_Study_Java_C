import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] players;
    static int max = 0;
    static boolean[] alreadyChosen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t=0; t<TC; ++t) {
            players = new int[11][11];
            max = 0;
            alreadyChosen = new boolean[11];

            for (int i = 0; i < 11; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; ++j) {
                    players[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 입력 완료

            makeFormation(0, 0);
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static void makeFormation(int player, int sum) {
        if (player == 11) {
            max = Math.max(max, sum);
            return ;
        }


        for (int position = 0; position < 11; ++position) {
            if (alreadyChosen[position] || players[player][position] == 0) continue;

            alreadyChosen[position] = true;
            makeFormation(player+1, players[player][position] + sum);
            alreadyChosen[position] = false;

        }
    }
}