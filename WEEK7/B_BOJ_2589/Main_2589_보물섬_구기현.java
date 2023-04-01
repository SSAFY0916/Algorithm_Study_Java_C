import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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
    static int fromRow, fromCol, toRow, toCol, maxDistance= Integer.MIN_VALUE;
    static int[][] visited;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; ++i) {
            String tmp = br.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = tmp.charAt(j);
            }
        } // 입력 완료

        findFarthest();
        System.out.println(maxDistance-1);
    }

    private static void findFarthest() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r, c));

        visited = new int[N][M];
        visited[r][c] = 1;
        while (!queue.isEmpty()) {
            Point curr=  queue.poll();
            int nr, nc;
            for (int i = 0; i < 4; ++i) {
                nr = curr.row + dr[i];
                nc = curr.col + dc[i];

                if (nr<0 || nc  <0 || nr >=N || nc >= M || map[nr][nc]=='W' || visited[nr][nc] !=0) continue;

                visited[nr][nc] = visited[curr.row][curr.col]+1;
                if (visited[nr][nc] > maxDistance) maxDistance = visited[nr][nc];
                queue.offer(new Point(nr, nc));
            }
        }

//        for (int i = 0; i < N; ++i) {
//            System.out.println(Arrays.toString(visited[i]));
//        }
//        System.out.println(maxDistance);
//        System.out.println("--------------");
    }

}