import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        char[][] board = new char[3][3];

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            int idx = 0, xCnt = 0, oCnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = s.charAt(idx++);
                    if (board[i][j] == 'X') {
                        xCnt++;
                    } else if (board[i][j] == 'O') {
                        oCnt++;
                    }
                }
            }

            if (xCnt < oCnt || xCnt - 1 > oCnt) {
                result.append("invalid\n");
                continue;
            }

            boolean xBingo = checkBingo(board, 'X');
            boolean oBingo = checkBingo(board, 'O');

            if (xCnt == oCnt && xBingo) {
                result.append("invalid\n");
                continue;
            }

            if (xCnt > oCnt) {
                if (oBingo) {
                    result.append("invalid\n");
                    continue;
                }
            }

            if (xCnt + oCnt < 9) {
                if (!xBingo && !oBingo) {
                    result.append("invalid\n");
                    continue;
                }
            }

            if (xBingo && oBingo) {
                result.append("invalid\n");
                continue;
            }

            result.append("valid\n");
        }

        System.out.println(result);
    }

    private static boolean checkBingo(char[][] board, char target) {
        // 가로 체크
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == target) {
                    cnt++;
                }
            }

            if (cnt == 3) {
                return true;
            }
        }

        // 세로 체크
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == target) {
                    cnt++;
                }
            }

            if (cnt == 3) {
                return true;
            }
        }

        // 대각선 체크
        int leftCnt = 0, rightCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == target) {
                leftCnt++;
            }

            if (board[i][2 - i] == target) {
                rightCnt++;
            }
        }

        if (leftCnt == 3 || rightCnt == 3) {
            return true;
        } else {
            return false;
        }
    }
}
