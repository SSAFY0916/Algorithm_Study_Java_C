package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1368 {

    static class Edge implements Comparable<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static int[] parent, diggingCost;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        diggingCost = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            diggingCost[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
        }

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                int cost = Integer.parseInt(st.nextToken());
                if (i == j) pq.offer(new Edge(0, i, diggingCost[i]));
                else if (i < j) pq.offer(new Edge(i, j, cost));
            }
        } // 입력 완료

        System.out.println(kruskal());

    }

    static int kruskal() {

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.from) == find(edge.to)) continue;

            union(edge.from, edge.to);
            answer += edge.cost;
        }

        return answer;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) parent[a] = b;
            else parent[b] = a;
        }

    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

}
