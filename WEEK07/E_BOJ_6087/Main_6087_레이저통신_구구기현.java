import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Laser implements Comparable<Laser>{
        int row, col;
        int turnCnt;
        int dir;

        public Laser(int row, int col, int turnCnt, int dir) {
            this.row = row;
            this.col = col;
            this.turnCnt = turnCnt;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "laser{" +
                    "row=" + row +
                    ", col=" + col +
                    ", turnCnt=" + turnCnt +
                    ", dir=" + dir +
                    '}';
        }

        @Override
        public int compareTo(Laser o) {
            return this.turnCnt - o.turnCnt;
        }
    }

    static int W, H;
    static char[][] map;
    static int[][] visited;
    static int answer;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static Laser startPoint, destination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new int[H][W];

        int ttmp = 0;
        for (int i = 0; i < H; ++i) {
            String tmp = br.readLine();
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            for (int j = 0; j < W; ++j) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'C') {
                    if (ttmp==0) {
                        startPoint = new Laser(i, j, 0, 9999);
                        ttmp++;
                    }
                    else destination = new Laser(i, j, 0, 9999);
                }

            }
        } // 입력 완료

        bfs();
        System.out.println(visited[destination.row][destination.col]);
//        for (int i = 0; i < H; ++i) {
//            System.out.println(Arrays.toString(visited[i]));
//        }

    }

    private static void bfs() {
        Queue<Laser> queue = new ArrayDeque<>();

//        for (int i = 0; i < 4; ++i) pq.offer(new Laser(startPoint.row, startPoint.col, startPoint.turnCnt, i));
        queue.offer(startPoint);
        visited[startPoint.row][startPoint.col] = 0;


        while (!queue.isEmpty()) {
            Laser curr = queue.poll();

            if (curr.row == destination.row && curr.col == destination.col) {
                answer = visited[curr.row][curr.col];
                continue;
            }

            for (int i = 0; i < 4; ++i) {
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];

                if (nr<0 || nc<0 || nr >=H || nc >= W || map[nr][nc] == '*') continue;

                if (curr.dir == i || curr.dir ==  9999) {
                    if (visited[nr][nc] >= curr.turnCnt) {
                        visited[nr][nc] = curr.turnCnt;
                        queue.offer(new Laser(nr, nc, curr.turnCnt, i));
                    }
                } else {
                    if (visited[nr][nc] > curr.turnCnt) {
                        visited[nr][nc] = curr.turnCnt+1;
                        queue.offer(new Laser(nr, nc, curr.turnCnt+1, i));
                    }
                }
            }
        }
    }


}