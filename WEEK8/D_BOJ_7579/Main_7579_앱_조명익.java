import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] apps = new int[n][2];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            apps[i][0] = Integer.parseInt(st1.nextToken()); // 메모리
            apps[i][1] = Integer.parseInt(st2.nextToken()); // 비용
            totalCost += apps[i][1];
        }

        int[] memo = new int[totalCost + 1];

        for (int i = 0; i < n; i++) {
            for (int j = totalCost; j - apps[i][1] > -1; j--) {
                memo[j] = Math.max(memo[j], memo[j - apps[i][1]] + apps[i][0]);
            }
        }

        for (int i = 0; i <= totalCost; i++) {
            if (memo[i] >= m) {
                System.out.println(i);
                return;
            }
        }
    }
}
