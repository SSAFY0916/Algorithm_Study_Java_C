package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B6068 {

    static class Todo implements Comparable<Todo>{
        int time;
        int endMax;

        public Todo(int time, int endMax) {
            this.time = time;
            this.endMax = endMax;
        }
        @Override
        public int compareTo(Todo o) {
            return o.endMax - this.endMax;
        }

        @Override
        public String toString() {
            return "Todo{" +
                    "time=" + time +
                    ", endMax=" + endMax +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Todo> pq = new PriorityQueue<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Todo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int max = pq.peek().endMax;
        while (!pq.isEmpty()) {
            Todo curr = pq.poll();
            if (curr.endMax < max){
                max = curr.endMax-curr.time;
            } else max -= curr.time;
        }

        if (max< 0) System.out.println(-1);
        else System.out.println(max);
    }
}