import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] ices = new int[1_000_001];
        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            ices[pos] = ice;
            total += ice;
        }

        if (k >= 500_000) {
            System.out.println(total);
            return;
        }

        int sum = 0;
        int length = k * 2;
        for (int i = 0; i <= length; i++) {
            sum += ices[i];
        }

        int max = sum;
        for (int i = 1; i + length <= 1_000_000; i++) {
            sum -= ices[i - 1];
            sum += ices[i + length];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
