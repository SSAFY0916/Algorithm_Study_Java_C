import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] board = new boolean[101][101];

        int n = Integer.parseInt(br.readLine());

        // 0 : 오른쪽 1 : 위 2 : 왼 3 : 아
        int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};

        List<Integer> prev = new ArrayList<>();
        List<Integer> directions = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            board[x][y] = true;
            directions.add(d);

            for (int j = -1; j < g; j++) {
                for (int k = 0; k < directions.size(); k++) {
                    int direction = directions.get(k);
                    x += dx[direction];
                    y += dy[direction];
                    board[x][y] = true;
                    prev.add(direction);
                }

                directions.clear();

                for (int k = prev.size() - 1; k > -1; k--) {
                    directions.add((prev.get(k) + 1) % 4);
                }
            }

            prev.clear();
            directions.clear();
        }

        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] && board[i][j + 1] && board[i + 1][j] && board[i + 1][j + 1]) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
