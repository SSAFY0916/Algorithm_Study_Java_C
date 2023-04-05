import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] palindromes = new int[2001][2001];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    palindromes[i][j] = 1;
                } else if (isPalindromes(arr, i, j)) {
                    palindromes[i][j] = 1;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder(m * 3);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            result.append(palindromes[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append('\n');
        }

        System.out.println(result);
    }

    private static boolean isPalindromes(int[] arr, int s, int e) {
        int length = (e - s) / 2;
        for (int i = 0; i <= length; i++) {
            if (arr[s + i] != arr[e - i]) {
                return false;
            }
        }

        return true;
    }
}
