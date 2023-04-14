import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] scv = new int[3];

    static int[][] pattern = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    static int[][][] visited = new int[61][61][61];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            scv[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        bfs();
        System.out.println(visited[0][0][0]);

    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(scv);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == 0 && curr[1] == 0 && curr[2] == 0) return ;

            for (int p = 0; p < 6; ++p) {
                int[] tmp = pattern[p];
                int s1 = curr[0] - tmp[0] > 0? curr[0] - tmp[0] : 0;
                int s2 = curr[1] - tmp[1] > 0? curr[1] - tmp[1] : 0;
                int s3 = curr[2] - tmp[2] > 0? curr[2] - tmp[2] : 0;

                if (visited[s1][s2][s3] == 0) {
                    visited[s1][s2][s3] = visited[curr[0]][curr[1]][curr[2]] + 1;
                    queue.offer(new int[]{s1, s2, s3});
                }
            }
        }
    }

}
