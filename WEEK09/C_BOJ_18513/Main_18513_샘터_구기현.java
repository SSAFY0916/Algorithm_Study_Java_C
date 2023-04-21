import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static Queue<int[]> queue = new ArrayDeque<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            int position = Integer.parseInt(st.nextToken());
            queue.offer(new int[]{position, 0}); // position, distance
            set.add(position);
        } // 입력 완료

        System.out.println(bfs());

    }


    private static long bfs() {

        long result = 0;

        while (K > 0 && !queue.isEmpty()) {
            int[] curr = queue.poll();
            int idx = curr[0];
            int dist = curr[1];

            // 왼쪽 탐색
            if (!set.contains(idx - 1)) {
                K--;
                set.add(idx - 1);
                result += dist+1;
                queue.offer(new int[]{idx - 1, dist + 1});
            }

            if (K == 0) break;

            // 오른쪽 탐색
            if (!set.contains(idx + 1)) {
                K--;
                set.add(idx + 1);
                result += dist+1;
                queue.offer(new int[]{idx + 1, dist + 1});
            }
        }

        return result;
    }


}
