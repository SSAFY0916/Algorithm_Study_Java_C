import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());

        char[][] board = new char[l][w];
        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int nx, ny, time = 0;
        boolean[][] selected = new boolean[l][w];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'L' && !selected[i][j]) {
                    queue.add(new int[]{i, j});
                    selected[i][j] = true;
                    int dist = bfs(board, i, l, j, w);

                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            nx = pos[0] + dx[k];
                            ny = pos[1] + dy[k];

                            if (nx < 0 || nx > l - 1 || ny < 0 || ny > w - 1 || selected[nx][ny] || board[nx][ny] == 'W') {
                                continue;
                            }

                            dist = Math.max(dist, bfs(board, nx, l, ny, w));
                            selected[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }

                    time = Math.max(time, dist);
                }
            }
        }

        System.out.println(time);
    }

    private static int bfs(char[][] board, int x, int l, int y, int w) {
        boolean[][] visited = new boolean[l][w];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        int nx, ny, dist = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = pos[0] + dx[i];
                ny = pos[1] + dy[i];

                if (nx < 0 || nx > l - 1 || ny < 0 || ny > w - 1 || visited[nx][ny] || board[nx][ny] == 'W') {
                    continue;
                }

                dist = Math.max(dist, pos[2] + 1);

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, pos[2] + 1});
            }
        }

        return dist;
    }
}
