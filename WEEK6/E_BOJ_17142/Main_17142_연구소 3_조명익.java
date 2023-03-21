import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] board, picked;
    static int n, m, blankCount = 0, result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        List<int[]> viruses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    blankCount++;
                } else if (board[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        if (blankCount == 0) {
            System.out.println(0);
            return;
        }

        picked = new int[m][2];

        backTrack(0, viruses.size(), 0, m, viruses);

        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void backTrack(int depth, int max, int count, int m, List<int[]> viruses) {
        if (count == m) {
            spread();
            return;
        }

        if (depth == max) {
            return;
        }

        picked[count][0] = viruses.get(depth)[0];
        picked[count][1] = viruses.get(depth)[1];
        backTrack(depth + 1, max, count + 1, m, viruses);
        backTrack(depth + 1, max, count, m, viruses);
    }

    private static void spread() {
        int spreadCount = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] p : picked) {
            queue.add(new int[]{p[0], p[1], 0});
            visited[p[0]][p[1]] = true;
        }

        int nx, ny;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                nx = pos[0] + dx[i];
                ny = pos[1] + dy[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1
                    || visited[nx][ny] || board[nx][ny] == 1) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    spreadCount++;
                    if (spreadCount == blankCount) {
                        result = Math.min(result, pos[2] + 1);
                        return;
                    }
                }

                queue.add(new int[]{nx, ny, pos[2] + 1});
                visited[nx][ny] = true;
            }
        }
    }
}
