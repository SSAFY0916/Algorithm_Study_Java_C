import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Queue<int[]> startQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'O') {
                    startQueue.add(new int[]{i, j});
                }
            }
        }

        int d = Integer.parseInt(br.readLine());

        boolean[][] predicted = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'O') {
                    predicted[i][j] = true;
                }
            }
        }

        final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        Queue<int[]> queue = new ArrayDeque<>();

        int nx, ny, target = 1;
        int[][] v = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        while (!startQueue.isEmpty()) {
            int[] start = startQueue.poll();

            visited[start[0]][start[1]] = true;
            queue.add(new int[]{start[0], start[1], 0});
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();

                for (int i = 0; i < 4; i++) {
                    nx = pos[0] + dx[i];
                    ny = pos[1] + dy[i];

                    if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1 ||
                        visited[nx][ny] || v[nx][ny] == target || pos[2] + 1 > d) {
                        continue;
                    }

                    v[nx][ny] = target;

                    if (predicted[nx][ny]) {
                        visited[nx][ny] = true;
                        startQueue.add(new int[]{nx, ny});
                    } else {
                        queue.add(new int[]{nx, ny, pos[2] + 1});
                    }
                }
            }

            target++;
        }

        System.out.println(check(n, m, predicted, visited) ? "YES" : "NO");
    }

    private static boolean check(int n, int m, boolean[][] predicted, boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (predicted[i][j] != visited[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
