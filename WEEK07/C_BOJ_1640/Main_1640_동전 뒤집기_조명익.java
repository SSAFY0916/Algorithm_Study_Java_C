import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[n][m];

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int colCount = 0;
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '1') {
                    board[i][j] = true;
                    colCount++;
                }
            }

            if (colCount % 2 == 0) {
                row[i] = true; // 1이 짝수개면 true
            }
        }

        for (int i = 0; i < m; i++) {
            int rowCount = 0;
            for (int j = 0; j < n; j++) {
                if (board[j][i]) {
                    rowCount++;
                }
            }

            if (rowCount % 2 == 0) {
                col[i] = true; // 1이 짝수개면 true
            }
        }

        if (check(row) && check(col)) {
            System.out.println(0);
            return;
        }

        int result1 = getResult1(n, m, row, col);
        int result2 = getResult2(n, m, row, col);
        int result3 = getResult3(n, m, row, col);
        int result4 = getResult4(n, m, row, col);

        int answer = Math.min(Math.min(result1, result2), Math.min(result3, result4));
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int getResult4(int n, int m, boolean[] row, boolean[] col) {
        int result4 = 0;

        boolean[] copiedRow = Arrays.copyOf(row, n);
        boolean[] copiedCol = Arrays.copyOf(col, m);

        // 모든 홀수 행을 짝수 행으로 만듬
        for (int i = 0; i < n; i++) {
            if (!copiedRow[i]) {
                reverse(copiedCol);
                result4++;
                copiedRow[i] = !copiedRow[i];
            }
        }

        // 홀수 열의 개수를 구함
        int zeroCount = 0;
        for (int i = 0; i < m; i++) {
            if (!copiedCol[i]) {
                zeroCount++;
            }
        }

        if (zeroCount % 2 == 0) {
            result4 += zeroCount;
        } else {
            result4 = Integer.MAX_VALUE;
        }

        return result4;
    }

    private static int getResult3(int n, int m, boolean[] row, boolean[] col) {
        int result3 = 0;
        boolean[] copiedCol = Arrays.copyOf(col, m);
        boolean[] copiedRow = Arrays.copyOf(row, n);

        // 모든 홀수 열을 짝수 열로 만듬
        for (int i = 0; i < m; i++) {
            if (!copiedCol[i]) {
                reverse(copiedRow);
                result3++;
                copiedCol[i] = !copiedCol[i];
            }
        }

        // 홀수 행의 개수를 구함
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (!copiedRow[i]) {
                zeroCount++;
            }
        }

        if (zeroCount % 2 == 0) {
            result3 += zeroCount;
        } else {
            result3 = Integer.MAX_VALUE;
        }

        return result3;
    }

    private static int getResult2(int n, int m, boolean[] row, boolean[] col) {
        int result2 = 0;
        boolean[] copiedCol = Arrays.copyOf(col, m);
        boolean[] copiedRow = Arrays.copyOf(row, n);

        // 모든 짝수 열을 홀수 열로 만듬
        for (int i = 0; i < m; i++) {
            if (copiedCol[i]) {
                reverse(copiedRow);
                result2++;
                copiedCol[i] = !copiedCol[i];
            }
        }

        // 홀수 행의 개수를 구함
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (!copiedRow[i]) {
                zeroCount++;
            }
        }

        if (zeroCount % 2 == 1) {
            result2 += zeroCount;
        } else {
            result2 = Integer.MAX_VALUE;
        }

        return result2;
    }

    private static int getResult1(int n, int m, boolean[] row, boolean[] col) {
        int result1 = 0;

        boolean[] copiedRow = Arrays.copyOf(row, n);
        boolean[] copiedCol = Arrays.copyOf(col, m);

        // 모든 행에 대해 1의 개수를 홀수개로 만듬(짝수 -> 홀수)
        for (int i = 0; i < n; i++) {
            if (copiedRow[i]) {
                reverse(copiedCol);
                result1++;
                copiedRow[i] = !copiedRow[i];
            }
        }

        // 1의 개수가 홀수인 열의 개수가 홀수면 결과물 생성 가능
        int zeroCount = 0;
        for (int i = 0; i < m; i++) {
            if (!copiedCol[i]) {
                zeroCount++;
            }
        }

        if (zeroCount % 2 == 1) {
            result1 += zeroCount;
        } else {
            result1 = Integer.MAX_VALUE;
        }

        return result1;
    }

    private static boolean check(boolean[] arr) {
        for (boolean b : arr) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private static void reverse(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = !arr[i];
        }
    }
}
