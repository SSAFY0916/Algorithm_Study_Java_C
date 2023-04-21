package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B19699 {

    static StringBuilder sb;
    static int N, M;
    static int[] weight;
    static int sum;
    static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weight = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            weight[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        combination(0, 0);

        if (set.size() == 0) {
            sb.append(-1);
        } else {
            for (int x : set) {
                sb.append(x + " ");
            }
        }

        
        System.out.println(sb);
    }

    private static void combination(int start, int cnt) {
        if (cnt == M) {
            if (isPrime(sum)) {
                set.add(sum);
            }
            return ;
        }

        for (int i = start; i < N; ++i) {
            sum += weight[i];
            combination(i+1, cnt+1);
            sum -= weight[i];
        }
    }

    private static boolean isPrime(int sum) {
        for (int i = 2; i <= (int) Math.sqrt(sum); ++i) {
            if (sum % i == 0) return false;
        }
        return true;
    }


}