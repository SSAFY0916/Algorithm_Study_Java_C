import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Task implements Comparable<Task> {
        int deadLine;
        int score;

        public Task(int deadLine, int score) {
            this.deadLine = deadLine;
            this.score = score;
        }

        @Override
        public int compareTo(Task o) {
            return o.score - score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Task> pq = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] tasks = new int[1001];

        while (!pq.isEmpty()) {
            Task task = pq.poll();

            for (int i = task.deadLine; i > 0; i--) {
                if (tasks[i] < task.score) {
                    tasks[i] = task.score;
                    break;
                }
            }
        }

        int result = 0;
        for (int i = 1; i < 1001; i++) {
            result += tasks[i];
        }

        System.out.println(result);
    }
}
