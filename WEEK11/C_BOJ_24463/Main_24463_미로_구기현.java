package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B24463 {

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    static int N, M;
    static char[][] map;

    static Point start, end;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        boolean flag = false;
        for (int i = 0; i < N; ++i) {
            String tmp = br.readLine();
            for (int j = 0; j < M; ++j) {
                char ttmp = tmp.charAt(j);
                if (ttmp == '.') map[i][j] = '@';
                else map[i][j] = ttmp;
                if ((i == 0 || i == N-1 || j == 0 || j == M-1) && map[i][j] == '@') {
                    if(!flag) {
                        start = new Point(i, j);
                        flag = true;
                    }
                    if (flag) end = new Point(i, j);
                }
            }
        } // 입력 완료

        map[start.row][start.col] = '.';
        dfs(start.row, start.col);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean dfs(int row, int col) {

        if (row == end.row && col == end.col) return true;

        for (int i = 0; i < 4; ++i) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '.' ||  map[nr][nc] == '+') continue;
            map[nr][nc] = '.';
            if (dfs(nr, nc)) return true;
            map[nr][nc] = '@';
        }

        return false;
    }


}
