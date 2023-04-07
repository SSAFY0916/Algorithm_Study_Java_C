import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int diffSum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] differences = new int[n];
        for (int i = 0; i < n; i++) {
            differences[i] = Integer.parseInt(st2.nextToken()) - Integer.parseInt(st1.nextToken());
            diffSum += Math.abs(differences[i]);
        }

        PriorityQueue<Line> minuses = new PriorityQueue<>();
        PriorityQueue<Line> pluses = new PriorityQueue<>();

        int result = 0;

        while (diffSum > 0) {
            for (int i = 0; i < n; i++) {
                if (differences[i] < 0) {
                    minuses.add(new Line(differences[i], i));
                    result += operate(differences, pluses);
                } else if (differences[i] > 0) {
                    pluses.add(new Line(differences[i], i));
                    result += operate(differences, minuses);
                } else {
                    result += operate(differences, pluses);
                    result += operate(differences, minuses);
                }
            }

            result += operate(differences, pluses);
            result += operate(differences, minuses);
        }

        System.out.println(result);
    }

    private static int operate(int[] differences, PriorityQueue<Line> queue) {
        int count = 0;
        if (!queue.isEmpty()) {
            int min = queue.peek().difference;
            count += Math.abs(min);
            while (!queue.isEmpty()) {
                Line line = queue.poll();
                diffSum -= count;
                differences[line.index] -= min;
            }
        }

        return count;
    }

    private static class Line implements Comparable<Line> {
        int difference;
        int index;

        public Line(int difference, int index) {
            this.difference = difference;
            this.index = index;
        }

        @Override
        public int compareTo(Line o) {
            return Math.abs(difference) - Math.abs(o.difference);
        }
    }
}
