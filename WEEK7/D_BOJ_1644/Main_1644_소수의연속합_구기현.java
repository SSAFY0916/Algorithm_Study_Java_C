import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static boolean[] primeNums = new boolean[4000001];
    static List<Integer> pNumList = new ArrayList<>();
    static int answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        getPrimeNums();
        solution(); // 연속된 소수의 합 경우의 수
        System.out.println(answer);
    }

    private static void solution() {
        int from=0, to=0, size = pNumList.size();
        int sum=2;
        while (true) {
            if (sum == N) {
                answer++;
                sum -= pNumList.get(from);
                from++;
            }
            else if (sum < N) {
                if (to == size-1) break;
                to++;
                sum += pNumList.get(to);
            }
            else { // sum > N
                sum -= pNumList.get(from);
                from++;
//                if (pNumList.get(from) > N) break;
            }
        }
    }

    private static void getPrimeNums() {
        Arrays.fill(primeNums, true);
        primeNums[0] = primeNums[1] = false;

        for (int i = 2; i < primeNums.length; ++i) {
            if (!primeNums[i]) continue;
            for (int j = i * 2; j < primeNums.length; j+=i) {
                primeNums[j] = false;
            }
        }
        for (int i = 0; i <= 4000000; ++i) {
            if (primeNums[i]) pNumList.add(i);
        }
    }


}