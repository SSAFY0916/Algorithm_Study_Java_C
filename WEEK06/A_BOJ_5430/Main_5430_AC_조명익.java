import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int testCase = 0; testCase < t; testCase++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> queue = new LinkedList<>();

            String s = br.readLine();
            String sub = s.substring(1, s.length() - 1);
            StringTokenizer st = new StringTokenizer(sub, ",");
            for (int i = 0; i < n; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            boolean error = false;
            boolean flag = false; // false : 정면, ture : 후면

            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'R') {
                    flag = !flag;
                } else {
                    if (queue.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (flag) {
                        queue.pollLast();
                    } else {
                        queue.pollFirst();
                    }
                }
            }

            if (error) {
                result.append("error\n");
                continue;
            }

            result.append('[');
            int size = queue.size();
            if (flag) {
                for (int i = 0; i < size - 1; i++) {
                    result.append(queue.pollLast()).append(',');
                }
                if (!queue.isEmpty()) {
                    result.append(queue.pollLast());
                }
            } else {
                for (int i = 0; i < size - 1; i++) {
                    result.append(queue.poll()).append(',');
                }
                if (!queue.isEmpty()) {
                    result.append(queue.poll());
                }
            }
            result.append("]\n");
        }

        System.out.println(result);
    }
}
