import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[][] map;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int[][] dp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dp = new int[R][C];
        for (int i = 0; i < R; ++i) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < R; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료
        System.out.println(dfs(0, 0));

    }

    private static int dfs(int row, int col) {
        // 도착했을 때
        if (row == R-1 && col == C-1) return 1;

        if (dp[row][col] != -1) return dp[row][col];

        dp[row][col] = 0;

        for (int i = 0; i < 4; ++i) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nc < 0 || nr >=R || nc >=C) continue;

            if (map[nr][nc] < map[row][col]) {
                dp[row][col] += dfs(nr, nc);
            }
        }

        return dp[row][col];
    }
}
