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

    static int N, M, D;
    static char[][] map;
    static char[][] result;
    static boolean[][] visited;

    static Queue<Point> deq = new ArrayDeque<>();

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        result = new char[N][M];
        visited = new boolean[N][M];
        String tmp;
        for (int i = 0; i < N; ++i) {
            tmp = br.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = tmp.charAt(j);
                if(tmp.charAt(j) == 'O') {
                    deq.offer(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        D = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            tmp = br.readLine();
            for (int j = 0; j < M; ++j) {
                result[i][j] = tmp.charAt(j);
            }
        } // 입력 완료

        bfs();
        boolean answer = compare();
        System.out.println(answer? "YES":"NO");

//        for (int i = 0; i < N; ++i) {
//            System.out.println(Arrays.toString(map[i]));
//        }

    }

    static boolean compare() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] != result[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void bfs() {
        while(!deq.isEmpty()) {
            Point curr=  deq.poll();
            int curRow = curr.row;
            int curCol = curr.col;

            dfs(D, curRow, curCol);
        }
    }


    private static void dfs(int dep, int curRow, int curCol) {
        if (dep == 0) {
            return ;
        }

        for (int i = 0; i < 4; ++i) {
            int nr = curRow + dr[i];
            int nc = curCol + dc[i];


            if (nr<0 || nr >=N || nc<0 || nc>=M || visited[nr][nc]) continue;
            if (map[nr][nc] == 'X' && result[nr][nc] == 'O') {
                map[nr][nc] = 'O';
                deq.offer(new Point(nr, nc));
                visited[nr][nc] = true;
            }
            if (map[nr][nc] == 'X' && result[nr][nc] == 'X') {
                dfs(dep - 1, nr, nc);
            }
        }
    }


}