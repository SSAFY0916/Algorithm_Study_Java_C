import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
        // h : 행의 수, n : 세로선의 수
        int n = read(), m = read(), h = read();
        int width = n * 2;
        boolean[][] ladder = new boolean[h + 1][width];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < width; j += 2) {
                ladder[i][j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            ladder[read()][read() * 2] = true;
        }

        if (check(ladder, h, width)) {
            System.out.println(0);
            return;
        }

        int ladderCount = h * width;
        for (int i = 1; i < 4; i++) {
            backTrack(ladder, 0, i, ladderCount, h, width, 2);
        }

        System.out.println(-1);
    }

    private static void backTrack(boolean[][] ladder, int depth, int target, int ladderCount, int h,
        int width, int start) {
        if (depth == target) {
            if (check(ladder, h, width)) {
                System.out.println(target);
                System.exit(0);
            }
            return;
        }

        int x, y;
        for (int i = start; i <= ladderCount; i += 2) {
            if (i % width == 0) {
                continue;
            } else {
                x = i / width + 1;
                y = i % width;
            }

            if (ladder[x][y] || (y - 2 > 1 && ladder[x][y - 2]) || (y + 2 < width && ladder[x][y + 2])) {
                continue;
            }

            ladder[x][y] = true;
            backTrack(ladder, depth + 1, target, ladderCount, h, width, i + 2);
            ladder[x][y] = false;
        }
    }

    private static boolean check(boolean[][] ladder, int h, int col) {
        for (int i = 1; i < col; i += 2) {
            int x = 1, y = i;
            while (x <= h) {
                if (y + 1 < col && ladder[x][y + 1]) {
                    y += 2;
                } else if (y - 1 > 0 && ladder[x][y - 1]) {
                    y -= 2;
                }

                x++;
            }

            if (y != i) {
                return false;
            }
        }

        return true;
    }
    
    private static int read() throws IOException {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) {
            n = 10 * n + c - 48;
        }
        return n;
    }
}
