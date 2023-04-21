import java.util.*;

public class Main {

    static int[] dx = {-1, -1, 1, 1}, dy = {-1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int length = n + 1;
        int[][] baskets = new int[length][length];
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                baskets[i][j] = read();
            }
        }

        int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1}, dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

        List<int[]> clouds = new ArrayList<>();
        clouds.add(new int[]{n, 1});
        clouds.add(new int[]{n, 2});
        clouds.add(new int[]{n - 1, 1});
        clouds.add(new int[]{n - 1, 2});

        boolean[][] visited = new boolean[length][length];

        for (int i = 0; i < m; i++) {
            int d = read(), s = read();

            // 1. 구름 이동
            for (int count = 0; count < s; count++) {
                for (int[] cloud : clouds) {
                    cloud[0] += dx[d];
                    cloud[1] += dy[d];
                    if (cloud[0] < 1) cloud[0] = n;
                    else if (cloud[0] > n) cloud[0] = 1;
                    if (cloud[1] < 1) cloud[1] = n;
                    else if (cloud[1] > n) cloud[1] = 1;
                }
            }

            // 1-2. 구름 좌표 표기
            for (int[] cloud : clouds) {
                visited[cloud[0]][cloud[1]] = true;
            }

            // 2. 구름이 있는 곳 물 1 증가
            for (int[] cloud : clouds) {
                baskets[cloud[0]][cloud[1]]++;
            }

            // 3. 물복사 버그
            for (int[] cloud : clouds) {
                baskets[cloud[0]][cloud[1]] += copyWater(baskets, n, cloud[0], cloud[1]);
            }

            // 4. 기존 구름 삭제
            clouds.clear();

            // 5. 새로운 구름 추가
            for (int j = 1; j < length; j++) {
                for (int k = 1; k < length; k++) {
                    if (baskets[j][k] > 1 && !visited[j][k]) {
                        clouds.add(new int[]{j, k});
                        baskets[j][k] -= 2;
                    }
                }
            }

            // 6. 구름 좌표 초기화
            for (int j = 1; j < length; j++) {
                Arrays.fill(visited[j], false);
            }
        }

        int sum = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                sum += baskets[i][j];
            }
        }

        System.out.println(sum);
    }

    private static int copyWater(int[][] baskets, int n, int x, int y) {
        int nx, ny, count = 0;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                continue;
            }

            if (baskets[nx][ny] > 0) {
                count++;
            }
        }

        return count;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) n = 10 * n + c - 48;
        return n;
    }
}
