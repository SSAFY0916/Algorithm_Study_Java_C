package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B5430 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deq;
        String operator;
        int N;
        int TC = Integer.parseInt(br.readLine());
        String tmp;
        for (int t = 0; t < TC; ++t) {
            boolean flag = false;
            deq = new ArrayDeque<>();
            operator = br.readLine();
            N = Integer.parseInt(br.readLine());
            tmp = br.readLine();
            tmp = tmp.substring(1, tmp.length()-1);
            String[] ttmp = tmp.split(",");

            for (int i = 0; i < N; ++i) {
                deq.offer(Integer.parseInt(ttmp[i]));
            }


            boolean isReverse = false;

            for (int i = 0; i < operator.length(); ++i) {
                char op = operator.charAt(i);

                if (op == 'R') {
                    isReverse = !isReverse;
                } else { // D
                    if (deq.size() == 0) {
                        sb.append("error").append("\n");
                        flag = true;
                        break;
                    } else if(isReverse) {
                        deq.pollLast();
                    } else deq.pollFirst();
                }
            }

            if (flag) continue;
            sb.append("[");
            while (!deq.isEmpty()) {
                if (isReverse) {
                    sb.append(deq.pollLast());
                } else sb.append(deq.poll());

                if (!deq.isEmpty()) sb.append(",");
            }
            sb.append("] \n");
        }
        System.out.println(sb);
    }
}