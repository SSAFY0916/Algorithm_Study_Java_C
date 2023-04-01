import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] numbers = new boolean[4_000_001]; // 최초 0 ~ n 까지의 모든 수가 소수(false)라고 가정한다.
        numbers[0] = numbers[1] = true; // 0과 1은 소수가 아니다.
        for (int i = 2; i * i <= 4_000_000; i++) {
            if (!numbers[i]) { // i가 소수인 경우
                for (int j = i * i ; j <= 4_000_000; j += i) { // i 자기 자신을 제외한 i의 배수의 수는 소수가 아니다.
                    numbers[j] = true;
                }
            }
        }

        int result = numbers[n] ? 0 : 1;

        List<Integer> primes = new ArrayList<>();
        int size = 283_146;
        int[] sum = new int[size + 1];
        sum[1] = 2;
        int idx = 1;
        for (int i = 2; i < 4_000_001; i++) {
            if (!numbers[i]) {
                primes.add(i);
                sum[idx] = i + sum[idx - 1];
                idx++;
            }
        }

        idx = size;
        for (int i = 0; i < size; i++) {
            if (primes.get(i) >= n) {
                idx = i;
                break;
            }
        }

        for (int i = 0; i < idx; i++) {
            for (int j = i + 1; j <= idx; j++) {
                if (sum[j] - sum[i] > n) {
                    break;
                }

                if (sum[j] - sum[i] == n) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
