import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    final static int INF = 4_000_001;
    final static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    final static int MARK = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        boolean flag = true;
        int sx = 0, sy = 0, ex = 0,ey = 0;
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (board[i][j] == '.') {
                        if (flag) {
                            sx = i; sy = j;
                            flag = false;
                        } else {
                            ex = i; ey = j;
                        }
                    }
                }
            }
        }

        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], INF);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = 0;

        int nx, ny;
        BFS: while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = pos[0] + dx[i];
                ny = pos[1] + dy[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1 || board[nx][ny] == '+' || visited[nx][ny] <= pos[2]) {
                    continue;
                }

                visited[nx][ny] = pos[2] + 1;

                if (nx == ex && ny == ey) {
                    reverseBFS(ex, ey, sx, sy, visited, board);
                    break BFS;
                }

                queue.add(new int[]{nx, ny, pos[2] + 1});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != MARK && board[i][j] == '.') {
                    board[i][j] = '@';
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(board[i]).append('\n');
        }

        System.out.println(result);
    }

    private static void reverseBFS(int sx, int sy, int ex, int ey, int[][] visited, char[][] board) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, visited[sx][sy]});
        visited[sx][sy] = MARK;

        int nx, ny;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = pos[0] + dx[i];
                ny = pos[1] + dy[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1 || board[nx][ny] == '+' || visited[nx][ny] + 1 != pos[2]) {
                    continue;
                }

                visited[nx][ny] = MARK;

                if (nx == ex && ny == ey) {
                    return;
                }

                queue.add(new int[]{nx, ny, pos[2] - 1});
            }
        }
    }
}
