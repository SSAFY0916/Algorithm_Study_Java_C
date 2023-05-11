package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1963 {

    static class Prime {
        int n, cnt;

        public Prime(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Prime{" +
                    "n=" + n +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    static boolean[] pNums = new boolean[10000];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        makePrime();

        for (int i = 0; i < TC; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int result = change(from, to);
            sb.append(result == -1? "Impossible" : result).append("\n");
        }

        System.out.println(sb);

        }

    private static void makePrime() {
        Arrays.fill(pNums, true);
        pNums[0] = pNums[1] = false;

        for (int i = 2; i < 10000; ++i) {
            if (!pNums[i]) continue;
            for (int j = i*i; j < 10000; j += i) {
                pNums[j] = false;
            }
        }
    }

    private static int change(int from, int to) {
        Queue<Prime> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        queue.offer(new Prime(from ,0));
        visited[from] = true;

        while (!queue.isEmpty()) {
            Prime curr = queue.poll();
            if (curr.n == to) return curr.cnt;

            for (int i = 0; i < 4; ++i) { // 각 자리수
                for (int j = 0; j <= 9; ++j) { // 대입할 숫자
                    int next = 0;
                    if (i == 0) { // 1000의 자리
                        if(j == 0) continue;
                        next = j * 1000 + curr.n % 1000;
                    } else if (i == 1) { // 100의 자리
                        next = curr.n / 1000 * 1000 + j * 100 + curr.n % 100;
                    } else if (i == 2) { // 10의 자리
                        next = curr.n / 100 * 100 + j * 10 + curr.n % 10;
                    } else { // 1의 자리
                        next = curr.n / 10 * 10 + j;
                    }

                    if (pNums[next] && !visited[next]) {
                        visited[next] = true;
                        queue.offer(new Prime(next, curr.cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

}
