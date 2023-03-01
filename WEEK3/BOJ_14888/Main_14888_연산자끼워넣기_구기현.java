import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] operator = new int[4];


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            operator[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        dfs(arr[0], 1);
        sb.append(max + "\n");
        sb.append(min);

        System.out.println(sb);
    }

    static void dfs(int value, int idx) {
        if (idx == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return ;
        }

        for (int i = 0; i < 4; ++i) {
            if (operator[i] > 0) {

                operator[i]--; // 사용했으니 감소

                if (i == 0){ // +
                    dfs(value + arr[idx], idx+1);
                }
                if (i == 1){ // -
                    dfs(value - arr[idx], idx+1);
                }
                if (i == 2){ // *
                    dfs(value * arr[idx], idx+1);
                }
                if (i == 3){ // /
                    dfs(value / arr[idx], idx+1);
                }

                operator[i]++; // 복원
            }
        }

    }

}

