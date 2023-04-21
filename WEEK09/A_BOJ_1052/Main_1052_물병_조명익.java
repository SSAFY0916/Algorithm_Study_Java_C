import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int bottles = read(), k = read();

        int result = 0, liter = 1;
        PriorityQueue<Integer> remainders = new PriorityQueue<>();

        while (bottles > 0) {
            if (bottles % 2 != 0) {
                remainders.add(liter);
            }
            bottles /= 2;
            liter *= 2;
        }

        while (k < remainders.size()) {
            int remain = remainders.poll();
            result += remainders.peek() - remain;
            remainders.add(remainders.poll() * 2);
        }

        System.out.println(result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) n = 10 * n + c - 48;
        return n;
    }
}
