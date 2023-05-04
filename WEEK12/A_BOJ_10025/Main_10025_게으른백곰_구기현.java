package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10025 {


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000002];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[x+1] = val;
        } // 입력 완료

        int max = 0;

        for (int i = 1; i < 1000002; ++i) {
            arr[i] += arr[i - 1];
        }

        int left, right;
        for (int i = 1; i < 1000002; ++i) {
            right = i + K;
            if (right >= 1000002) right = 1000001;
            left = i - K;
            if (left < 1) left = 1;

            max = Math.max(max, arr[right] - arr[left-1]);
        }

        System.out.println(max);
    }



}
