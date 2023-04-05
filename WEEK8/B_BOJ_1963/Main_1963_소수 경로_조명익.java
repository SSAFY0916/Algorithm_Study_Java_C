import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX = 10_001;
        boolean[] primes = new boolean[MAX];
        primes[0] = primes[1] = true;
        for (int i = 2; i * i < MAX; i++) {
            for (int j = i * i; j < MAX; j += i) {
                primes[j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            String e = st.nextToken();

            int[] present = new int[4], target = new int[4];
            for (int j = 0; j < 4; j++) {
                present[j] = s.charAt(j) - 48;
                target[j] = e.charAt(j) - 48;
            }

            if (check(present, target)) {
                result.append(0).append('\n');
                continue;
            }

            int answer = -1;

            boolean[] visited = new boolean[MAX];
            Queue<Node> queue = new ArrayDeque<>();
            int p = convertToInt(present);
            visited[p] = true;
            queue.add(new Node(present, 0));

            BFS : while (!queue.isEmpty()) {
                Node node = queue.poll();

                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 10; k++) {
                        if (node.number[j] != k) {
                            int[] newNumber = Arrays.copyOf(node.number, 4);
                            newNumber[j] = k;
                            int newNumberInt = convertToInt(newNumber);

                            if (newNumberInt < 1000 || newNumberInt > 9999 || visited[newNumberInt] || primes[newNumberInt]) {
                                continue;
                            }

                            if (check(newNumber, target)) {
                                answer = node.dist + 1;
                                break BFS;
                            }

                            visited[newNumberInt] = true;
                            queue.add(new Node(newNumber, node.dist + 1));
                        }
                    }
                }
            }

            if (answer == -1) {
                result.append("Impossible").append('\n');
            } else {
                result.append(answer).append('\n');
            }
        }

        System.out.println(result);
    }

    private static int convertToInt(int[] a) {
        int number = 0, m = 1;
        for (int i = 3; i > -1; i--) {
            number += a[i] * m;
            m *= 10;
        }
        return number;
    }

    private static boolean check(int[] a, int[] b ) {
        for (int i = 0; i < 4; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    private static class Node {
        int[] number;
        int dist;

        public Node(int[] number, int dist) {
            this.number = number;
            this.dist = dist;
        }
    }
}
