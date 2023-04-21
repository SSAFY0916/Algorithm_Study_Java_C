import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());

        char[][] board = new char[h][w];
        int sx = 0, sy = 0, ex = 0, ey = 0, flag = 0;
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'C') {
                    if (flag == 0) {
                        sx = i;
                        sy = j;
                        flag = 1;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        final int INF = Integer.MAX_VALUE;

        int[][] memo = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(memo[i], INF);
        }

        int nx, ny, nd, nc, result = INF;

        final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; // 0 : 위, 1 : 오른쪽, 2: 아래, 3 : 왼쪽

        Queue<int[]> queue = new ArrayDeque<>();
        for (int direction = 0; direction < 4; direction++) {
            boolean[][] visited = new boolean[h][w];
            queue.add(new int[]{sx, sy, direction, 0}); // 0 : x 좌표, 1 : y 좌표, 2 : 방향, 3 : 거울 개수
            memo[sx][sy] = 0;
            visited[sx][sy] = true;

            while (!queue.isEmpty()) {
                int[] pos = queue.poll();

                for (int d = 0; d < 3; d++) {
                    if (d == 0) { // 직진
                        nd = pos[2];
                        nc = pos[3];
                    } else if (d == 1) { // 우
                        nd = (pos[2] + 1) % 4;
                        nc = pos[3] + 1;
                    } else { // 좌
                        nd = (pos[2] + 3) % 4;
                        nc = pos[3] + 1;
                    }

                    nx = pos[0] + dx[nd];
                    ny = pos[1] + dy[nd];

                    if (nx < 0 || nx > h - 1 || ny < 0 || ny > w - 1 ||
                        board[nx][ny] == '*' || memo[nx][ny] < nc || (memo[nx][ny] == nc && visited[nx][ny])) {
                        continue;
                    }

                    if (nx == ex && ny == ey) {
                        result = Math.min(result, nc);
                        continue;
                    }

                    memo[nx][ny] = nc;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, nd, nc});
                }
            }
        }

        System.out.println(result);
    }
}
