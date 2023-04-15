import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        int sx = 0, sy = 0, ex = 0, ey = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == '#') {
                    if (flag) {
                        sx = i;
                        sy = j;
                        flag = false;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; // 0 : 위쪽, 1 : 오른쪽, 2 : 아래쪽, 3 : 왼쪽

        int[][][] memo = new int[4][n][n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], 2500);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int nx, ny, result = Integer.MAX_VALUE;
        for (int direction = 0; direction < 4; direction++) {
            queue.add(new int[]{sx, sy, direction, 0});
            memo[direction][sx][sy] = 0;
        }
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            nx = pos[0] + dx[pos[2]];
            ny = pos[1] + dy[pos[2]];

            if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1 || board[nx][ny] == '*'
                || pos[3] >= result) {
                continue;
            }

            if (board[nx][ny] == '!') {
                if (memo[pos[2]][nx][ny] > pos[3]) {
                    memo[pos[2]][nx][ny] = pos[3];
                    queue.add(new int[]{nx, ny, pos[2], pos[3]});
                }

                int nd1 = (pos[2] + 1) % 4;
                if (memo[nd1][nx][ny] > pos[3] + 1) {
                    memo[nd1][nx][ny] = pos[3] + 1;
                    queue.add(new int[]{nx, ny, nd1, pos[3] + 1});
                }

                int nd2 = (pos[2] + 3) % 4;
                if (memo[nd2][nx][ny] > pos[3] + 1) {
                    memo[nd2][nx][ny] = pos[3] + 1;
                    queue.add(new int[]{nx, ny, nd2, pos[3] + 1});
                }

            } else if (board[nx][ny] == '.') {
                if (memo[pos[2]][nx][ny] > pos[3]) {
                    memo[pos[2]][nx][ny] = pos[3];
                    queue.add(new int[]{nx, ny, pos[2], pos[3]});
                }
            } else if (nx == ex && ny == ey) {
                result = pos[3];
            }
        }

        System.out.println(result);
    }
}
