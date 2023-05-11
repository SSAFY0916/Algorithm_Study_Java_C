import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDepth = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            inDepth[end]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (inDepth[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int node = pq.poll();
            result.append(node).append(' ');

            for (int next : graph[node]) {
                inDepth[next]--;
                if (inDepth[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(result);
    }
}
