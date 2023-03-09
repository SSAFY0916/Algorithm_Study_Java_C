import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        final int INF = 2_475_001;

        for (int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            List<Node>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[s].add(new Node(e, cost));
                graph[e].add(new Node(s, cost));
            }

            int k = Integer.parseInt(br.readLine());
            int[] friends = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }

            int[][] distances = new int[k][n + 1];

            for (int i = 0; i < k; i++) {
                Arrays.fill(distances[i], INF);
                distances[i][friends[i]] = 0;

                PriorityQueue<Node> pq = new PriorityQueue<>();
                pq.add(new Node(friends[i], 0));

                while (!pq.isEmpty()) {
                    Node node = pq.poll();

                    int idx = node.index;
                    int dist = node.dist;
                    if (distances[i][idx] < dist) {
                        continue;
                    }

                    for (Node next : graph[idx]) {
                        int td = distances[i][idx] + next.dist;
                        int ti = next.index;
                        if (td < distances[i][ti]) {
                            distances[i][ti] = td;
                            pq.add(new Node(ti, td));
                        }
                    }
                }
            }

            int minDistance = Integer.MAX_VALUE, roomNumber = 0;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += distances[j][i];
                }

                if (sum < minDistance) {
                    minDistance = sum;
                    roomNumber = i;
                }
            }

            result.append(roomNumber).append('\n');
        }

        System.out.println(result);
    }

    private static class Node implements Comparable<Node> {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }
    }
}
