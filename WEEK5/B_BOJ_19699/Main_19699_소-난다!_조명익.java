import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 9000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] cows = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> weights = new ArrayList<>();
        backTrack(weights, getPrimes(), cows, 0, n, 0, m, 0);

        if (weights.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(weights);
        StringBuilder result = new StringBuilder();
        for (Integer weight : weights) {
            result.append(weight).append(' ');
        }

        System.out.println(result);
    }

    private static void backTrack(List<Integer> weights, boolean[] primes, int[] cows, int depth, int n, int count, int target, int sum) {
        if (count == target) {
            if (!primes[sum]) {
                primes[sum] = true;
                weights.add(sum);
            }
            return;
        }

        if (depth == n) {
            return;
        }

        backTrack(weights, primes, cows, depth + 1, n, count + 1, target, sum + cows[depth]);
        backTrack(weights, primes, cows, depth + 1, n, count, target, sum);
    }

    private static boolean[] getPrimes() {
        boolean[] primes = new boolean[MAX + 1]; // 최초 0 ~ n 까지의 모든 수가 소수(false)라고 가정한다.
        primes[0] = primes[1] = true; // 0과 1은 소수가 아니다.
        for (int i = 2; i * i <= MAX; i++) {
            if (!primes[i]) { // i가 소수인 경우
                for (int j = i * i ; j <= MAX; j += i) { // i 자기 자신을 제외한 i의 배수의 수는 소수가 아니다.
                    primes[j] = true;
                }
            }
        }

        return primes;
    }
}
