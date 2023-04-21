import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == 'Y') {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, bfs(graph, i, new boolean[n]));
        }

        System.out.print(result);
    }

    private static int bfs(List<Integer>[] graph, int start, boolean[] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int next : graph[node[0]]) {
                if (!visited[next] && node[1] < 2) {
                    visited[next] = true;
                    count++;
                    queue.add(new int[]{next, node[1] + 1});
                }
            }
        }

        return count;
    }
}
