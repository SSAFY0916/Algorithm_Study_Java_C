package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {

    static int H, W;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken()); // 세로 길이
        W = Integer.parseInt(st.nextToken()); // 가로 길이
        height = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; ++i) {
            height[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        int result=0;
        int leftMax, rightMax, minOfMax;
        for (int i=1; i<W-1; ++i) {
            leftMax=0; rightMax=0; minOfMax=0;
            // 왼쪽 최대 값
            for (int j = i; j >= 0; --j) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < W; ++j) {
                rightMax = Math.max(rightMax, height[j]);
            }
            minOfMax = Math.min(leftMax, rightMax);
            if (minOfMax > height[i]) result += minOfMax - height[i];
//            System.out.println(minOfMax);
        }

        System.out.println(result);

    }





}