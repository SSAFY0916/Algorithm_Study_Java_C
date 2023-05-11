import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        Queue<long[]> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            visited.add((long) x);
            queue.add(new long[]{x, x});
        }

        long sum = 0;

        int[] dx = {-1, 1};

        long nx;
        BFS:
        while (!queue.isEmpty()) {
            long[] pos = queue.poll();

            for (int i = 0; i < 2; i++) {
                nx = pos[1] + dx[i];

                if (!visited.contains(nx)) {
                    visited.add(nx);

                    sum += Math.abs(pos[0] - nx);

                    if (--k == 0) {
                        break BFS;
                    }

                    queue.add(new long[]{pos[0], nx});
                }
            }
        }

        System.out.println(sum);
    }
}
