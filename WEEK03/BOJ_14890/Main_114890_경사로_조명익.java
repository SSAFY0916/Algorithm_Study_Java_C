import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
        int n = read(), l = read();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = read();
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (checkRow(board, n, l, i)) result++;
            if (checkCol(board, n, l, i)) result++;
        }

        System.out.println(result);
    }

    private static boolean checkRow(int[][] board, int n, int l, int x) {
        // 왼쪽에서 오른쪽으로
        int prev = board[x][0], count = 1;
        for (int i = 1; i < n; i++) {
            if (board[x][i] == prev) {
                count++;
            } else {
                if (prev + 1 == board[x][i]) { // 왼쪽 보다 오른쪽이 1 큰 경우
                    if (count < l) { // 경사로를 설치할 수 없는 경우
                        return false;
                    } else { // 경사로를 설치할 수 있는 경우
                        count = 1;
                    }
                } else if (prev - 1 == board[x][i]) { // 왼쪽 보다 오른쪽이 1 작은 경우
                    count = 1;
                    while (i + 1 < n && board[x][i] == board[x][i + 1] && count < l) {
                        count++;
                        i++;
                    }

                    if (count < l) {
                        return false;
                    }

                    count = 0;
                } else { // 차이가 1 초과인 경우
                    return false;
                }
            }

            prev = board[x][i];
        }

        return true;
    }

    private static boolean checkCol(int[][] board, int n, int l, int y) {
        // 위쪽에서 아래쪽으로
        int prev = board[0][y], count = 1;
        for (int i = 1; i < n; i++) {
            if (board[i][y] == prev) {
                count++;
            } else {
                if (prev + 1 == board[i][y]) { // 왼쪽 보다 오른쪽이 1 큰 경우
                    if (count < l) { // 경사로를 설치할 수 없는 경우
                        return false;
                    } else { // 경사로를 설치할 수 있는 경우
                        count = 1;
                    }
                } else if (prev - 1 == board[i][y]) { // 왼쪽 보다 오른쪽이 1 작은 경우
                    count = 1;
                    while (i + 1 < n && board[i][y] == board[i + 1][y] && count < l) {
                        count++;
                        i++;
                    }

                    if (count < l) {
                        return false;
                    }

                    count = 0;
                } else { // 차이가 1 초과인 경우
                    return false;
                }
            }

            prev = board[i][y];
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) n = 10 * n + c - 48;
        return n;
    }
}
