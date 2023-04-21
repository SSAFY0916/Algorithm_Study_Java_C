import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static char[][] board;
    static char[][] copied;
    static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new char[row][col];
        copied = new char[row][col];

        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[] picked = new int[10];
        for (int i = 1; i < 11; i++) {
            backTrack(0, i, picked);
        }

        System.out.println(-1);
    }

    private static void backTrack(int depth, int target, int[] picked) {
        if (depth == target) {
            if (check(target, picked)) {
                System.out.println(target);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < 4; i++) { // 0 : 상, 1 : 우, 2 : 하, 3: 좌
            picked[depth] = i;
            backTrack(depth + 1, target, picked);
        }
    }

    private static boolean check(int target, int[] picked) {
        for (int i = 0; i < row; i++) {
            System.arraycopy(board[i], 0, copied[i], 0, col);
        }

        int flag;
        for (int i = 0; i < target; i++) {
            if (picked[i] == 0) {
                flag = up();
                if (flag == 1) {
                    return true;
                } else if (flag == 2) {
                    return false;
                }
            } else if (picked[i] == 1) {
                flag = right();
                if (flag == 1) {
                    return true;
                } else if (flag == 2) {
                    return false;
                }
            } else if (picked[i] == 2) {
                flag = down();
                if (flag == 1) {
                    return true;
                } else if (flag == 2) {
                    return false;
                }
            } else {
                flag = left();
                if (flag == 1) {
                    return true;
                } else if (flag == 2) {
                    return false;
                }
            }
        }

        return false;
    }

    private static int up() {
        boolean red = false, blue = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 빨간색 공을 위로 올린다.
                if (copied[i][j] == 'R') {
                    copied[i][j] = '.';
                    for (int k = i - 1; k > -1; k--) {
                        if (copied[k][j] == '#' || copied[k][j] == 'B') { // 벽이나 파란색 공을 만나면
                            copied[k + 1][j] = 'R';
                            break;
                        } else if (copied[k][j] == 'O') { // 구멍을 만나면
                            boolean bf = false;
                            for (int l = i + 1; l < row; l++) { // 빨간색 공 아래에 파란색 공이 있다면 false
                                if (copied[l][j] == '#') {
                                    break;
                                } else if (copied[l][j] == 'B') {
                                    bf = true;
                                }
                            }

                            if (bf) {
                                return 2; // 실패한 경우
                            } else {
                                return 1; // 성공한 경우
                            }
                        }
                    }

                    red = true;

                    // 파란색 공을 위로 올린다.
                } else if (copied[i][j] == 'B') {
                    copied[i][j] = '.';
                    for (int k = i - 1; k > -1; k--) {
                        if (copied[k][j] == '#' || copied[k][j] == 'R') { // 벽이나 빨간색 공을 만나면
                            copied[k + 1][j] = 'B';
                            break;
                        } else if (copied[k][j] == 'O') { // 구멍을 만나면
                            return 2; // 실패한 경우
                        }
                    }

                    blue = true;

                }

                if (red && blue) {
                    return 0;
                }
            }
        }

        return 0; // 다음 탐색 계속 진행
    }

    private static int right() {
        boolean red = false, blue = false;
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j > -1; j--) {
                // 빨간색 공을 오른쪽으로 이동시킨다.
                if (copied[i][j] == 'R') {
                    copied[i][j] = '.';
                    for (int k = j + 1; k < col; k++) {
                        if (copied[i][k] == '#' || copied[i][k] == 'B') { // 벽 또는 파란색 공을 만나면
                            copied[i][k - 1] = 'R';
                            break;
                        } else if (copied[i][k] == 'O') { // 구멍을 만나면
                            boolean bf = false;
                            for (int l = j - 1; l > -1; l--) { // 빨간색 공 왼쪽에 파란색 공이 있다면 false
                                if (copied[i][l] == '#') {
                                    break;
                                } else if (copied[i][l] == 'B') {
                                    bf = true;
                                }
                            }

                            if (bf) {
                                return 2; // 실패한 경우
                            } else {
                                return 1; // 성공한 경우
                            }
                        }
                    }

                    red = true;

                    // 파란색 공을 오른쪽으로 옮긴다.
                } else if (copied[i][j] == 'B') {
                    copied[i][j] = '.';
                    for (int k = j + 1; k < col; k++) {
                        if (copied[i][k] == '#' || copied[i][k] == 'R') { // // 벽이나 빨간색 공을 만나면
                            copied[i][k - 1] = 'B';
                            break;
                        } else if (copied[i][k] == 'O') { // 구멍을 만나면
                            return 2; // 실패한 경우
                        }
                    }

                    blue = true;
                }

                if (red && blue) {
                    return 0;
                }
            }
        }

        return 0;
    }

    private static int down() {
        boolean red = false, blue = false;
        for (int i = row - 1; i > -1; i--) {
            for (int j = 0; j < col; j++) {
                // 빨간색 공을 아래쪽으로 이동시킨다.
                if (copied[i][j] == 'R') {
                    copied[i][j] = '.';
                    for (int k = i + 1; k < row; k++) {
                        if (copied[k][j] == '#' || copied[k][j] == 'B') { // 벽 또는 파란색 공을 만나면
                            copied[k - 1][j] = 'R';
                            break;
                        } else if (copied[k][j] == 'O') { // 구멍을 만나면
                            boolean bf = false;
                            for (int l = i - 1; l > -1; l--) { // 빨간색 공 위쪽에 파란색 공이 있다면 false
                                if (copied[l][j] == '#') {
                                    break;
                                } else if (copied[l][j] == 'B') {
                                    bf = true;
                                }
                            }

                            if (bf) {
                                return 2; // 실패한 경우
                            } else {
                                return 1; // 성공한 경우
                            }
                        }
                    }

                    red = true;

                    // 파란색 공을 아래쪽으로 옮긴다.
                } else if (copied[i][j] == 'B') {
                    copied[i][j] = '.';
                    for (int k = i + 1; k < row; k++) {
                        if (copied[k][j] == '#' || copied[k][j] == 'R') { // 벽이나 빨간색 공을 만나면
                            copied[k - 1][j] = 'B';
                            break;
                        } else if (copied[k][j] == 'O') { // 구멍을 만나면
                            return 2; // 실패한 경우
                        }
                    }

                    blue = true;
                }

                if (red && blue) {
                    return 0;
                }
            }
        }

        return 0;
    }

    private static int left() {
        boolean red = false, blue = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 빨간색 공을 왼쪽으로 이동시킨다.
                if (copied[i][j] == 'R') {
                    copied[i][j] = '.';
                    for (int k = j - 1; k > -1; k--) {
                        if (copied[i][k] == '#' || copied[i][k] == 'B') { // 벽이나 파란색 공을 만나면
                            copied[i][k + 1] = 'R';
                            break;
                        } else if (copied[i][k] == 'O') { // 구멍을 만나면
                            boolean bf = false;
                            for (int l = j + 1; l < col; l++) { // 빨간색 공 오른쪽에 파란색 공이 있다면 false
                                if (copied[i][l] == '#') {
                                    break;
                                } else if (copied[i][l] == 'B') {
                                    bf = true;
                                }
                            }

                            if (bf) {
                                return 2; // 실패한 경우
                            } else {
                                return 1; // 성공한 경우
                            }
                        }
                    }

                    red = true;

                    // 파란색 공을 오른쪽으로 옮긴다.
                } else if (copied[i][j] == 'B') {
                    copied[i][j] = '.';
                    for (int k = j - 1; k > -1; k--) {
                        if (copied[i][k] == '#' || copied[i][k] == 'R') { // 벽이나 빨간색 공을 만나면
                            copied[i][k + 1] = 'B';
                            break;
                        } else if (copied[i][k] == 'O') { // 구멍을 만나면
                            return 2; // 실패한 경우
                        }
                    }

                    blue = true;
                }

                if (red && blue) {
                    return 0;
                }
            }
        }

        return 0;
    }
}
