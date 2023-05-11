package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10942 {

    static int N, M;
    static int[] arr;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(check(S-1, E-1)).append("\n");
        }
        System.out.println(sb);

    }

    private static int check(int S, int E) {
        if (S == E) return 1;

        while (S <= E) {
            if (arr[S] != arr[E]) return 0;
            S++;
            E--;
        }

        return 1;
    }


}
