import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(read());
        }

        int result = 0;
        while (pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            result += temp;
            pq.add(temp);
        }

        System.out.println(result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) n = 10 * n + c - 48;
        return n;
    }
}
