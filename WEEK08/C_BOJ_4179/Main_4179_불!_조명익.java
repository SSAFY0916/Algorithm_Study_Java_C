import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        char[][] board = new char[r][c];
        int[][] fireBoard = new int[r][c];
        int sx = 0, sy = 0;

        Queue<int[]> fires = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'J') {
                    sx = i; sy = j;
                } else if (board[i][j] == 'F') {
                    fireBoard[i][j] = 1;
                    fires.add(new int[]{i, j, 1});
                }
            }
        }

        final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

        int nx, ny;
        while (!fires.isEmpty()) {
            int[] fire = fires.poll();

            for (int i = 0; i < 4; i++) {
                nx = fire[0] + dx[i];
                ny = fire[1] + dy[i];

                if (nx < 0 || nx > r - 1 || ny < 0 || ny > c - 1 || board[nx][ny] == '#' || fireBoard[nx][ny] > 0) {
                    continue;
                }

                fireBoard[nx][ny] = fire[2] + 1;
                fires.add(new int[]{nx, ny, fireBoard[nx][ny]});
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 1});

        int answer = -1;
        boolean[][] visited = new boolean[r][c];
        BFS: while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = pos[0] + dx[i];
                ny = pos[1] + dy[i];

                if (nx < 0 || nx > r - 1 || ny < 0 || ny > c - 1) {
                    answer = pos[2];
                    break BFS;
                }

                if (board[nx][ny] == '#' || (fireBoard[nx][ny] > 0 && fireBoard[nx][ny] - 1 <= pos[2]) || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, pos[2] + 1});
            }
        }

        System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
    }
}
