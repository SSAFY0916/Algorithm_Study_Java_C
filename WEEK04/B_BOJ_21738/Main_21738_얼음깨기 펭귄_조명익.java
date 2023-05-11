import java.io.*;
import java.util.*;

class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken()),
            p = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Set<Integer> supportFixture = new HashSet<>();
        for (int i = 1; i <= s; i++) {
            supportFixture.add(i);
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0, sum = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{p, 0});
        visited[p] = true;
        BFS: while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int next : graph.get(node[0])) {
                if (!visited[next]) {
                    if (supportFixture.contains(next)) {
                        count++;
                        sum += (node[1] + 1);
                        if (count == 2) {
                            break BFS;
                        }
                    }

                    visited[next] = true;
                    queue.add(new int[]{next, node[1] + 1});
                }
            }
        }

        System.out.println(n - sum - 1);
    }
}
