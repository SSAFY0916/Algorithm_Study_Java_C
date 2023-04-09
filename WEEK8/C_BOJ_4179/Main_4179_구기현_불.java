package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179 {

    static class Point {
        int row, col;
        int time;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    static int R, C;
    static int[][] map;
    static boolean[][] visited;

    static Queue<Point> jiHoon = new ArrayDeque<>();
    static Queue<Point> fire = new ArrayDeque<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int answer = -1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; ++i) {
            String tmp = br.readLine();
            for (int j = 0; j < C; ++j) {
                if (tmp.charAt(j) == '#') map[i][j] = -1;
                if (tmp.charAt(j) == 'J') {
                    jiHoon.offer(new Point(i, j, 1));
                    visited[i][j] = true;
                }
                if (tmp.charAt(j) == 'F') {
                    fire.offer(new Point(i, j));
                    map[i][j] = 1;
                }
            }
        } // 입력 완료

        bfs();
        System.out.println(answer==-1? "IMPOSSIBLE" : answer);

    }

    private static void bfs() {

        // 불 퍼뜨리기
        while (!fire.isEmpty()) {
            Point curr = fire.poll();
            int r = curr.row;
            int c = curr.col;

            for (int i = 0; i < 4; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr<0 || nc <0 || nr >=R || nc >=C) continue;
                if (map[nr][nc] != 0) continue;

                map[nr][nc] = map[r][c] + 1;
                fire.offer(new Point(nr, nc));

            }
        }

        // 지훈이 출발
        while (!jiHoon.isEmpty()) {
            Point curr = jiHoon.poll();
            int r = curr.row;
            int c = curr.col;
            int time = curr.time;
            if (r == 0 || r ==R-1 || c == 0 || c == C-1){
                answer = time;

                break;
            }

            for (int i = 0; i < 4; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr<0 || nc <0 || nr >=R || nc >=C) continue;
                if (map[nr][nc] < 0 ||(map[nr][nc] > 0 && map[nr][nc] <= time+1)  || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                jiHoon.offer(new Point(nr, nc, time+1));
            }
        }

    }

}
