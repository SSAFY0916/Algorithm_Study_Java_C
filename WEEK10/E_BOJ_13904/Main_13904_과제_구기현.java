import java.io.*;
import java.util.*;

public class Main {

    static class Assignment implements Comparable<Assignment> {
        int deadline;
        int score;

        public Assignment(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }

        @Override
        public String toString() {
            return "assignment{" +
                    "deadline=" + deadline +
                    ", score=" + score +
                    '}';
        }

        @Override
        public int compareTo(Assignment o) {
            if (o.score == this.score) {
                return o.deadline - this.deadline;
            }
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Assignment> pq = new PriorityQueue<>();
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Assignment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        } // 입력 완료

        boolean[] visited = new boolean[1001];
        int answer = 0;
        while (!pq.isEmpty()) {
            int d =  pq.peek().deadline;
            int s =  pq.poll().score;
            for (int i=d; i>=1; --i) {
                if (!visited[i]){
                    visited[i] = true;
                    answer+= s;
                    break;
                }

            }

        }
        System.out.println(answer);
    }



}
