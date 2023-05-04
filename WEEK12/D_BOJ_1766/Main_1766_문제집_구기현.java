package baekjoon.ssafy;

import java.io.*;
import java.util.*;

public class B1766 {

    static int N, M;
    static int[] indegree;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];

        adjList = new ArrayList[N+1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            indegree[after]++;
            adjList[before].add(after);
        } // 입력 완료

        System.out.println(topologySort());

    }

    private static String topologySort() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; ++i) {
            if (indegree[i] == 0) pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr + " ");

            for (int i = 0; i < adjList[curr].size(); ++i) {
                int next = adjList[curr].get(i);
                indegree[next]--;
                if (indegree[next] == 0) pq.offer(next);
            }
        }

        return sb.toString();
    }


}