package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2156 {

    static int N;
    static int[] wine;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        wine = new int[N];
        for (int i = 0; i < N; ++i) {
            wine[i] = Integer.parseInt(br.readLine());
        } // 입력 완료
        dp = new int[N];

        solution();
        System.out.println(dp[N - 1]);

    }

    static void solution() {
        dp[0] = wine[0];
        if (N == 1) return ;

        dp[1] = wine[0] + wine[1];
        if (N == 2) return ;

        dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));

        for (int i = 3; i < N; ++i) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));

        }
    }





}