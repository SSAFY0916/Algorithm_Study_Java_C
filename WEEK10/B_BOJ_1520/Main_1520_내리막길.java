import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n], memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }

        System.out.println(dfs(0, m, 0, n, board, memo));
    }

    private static int dfs(int x, int m, int y, int n, int[][] board, int[][] memo) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        memo[x][y] = 0;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1 || board[x][y] <= board[nx][ny]) {
                continue;
            }

            memo[x][y] += dfs(nx, m, ny, n, board, memo);
        }

        return memo[x][y];
    }
}
