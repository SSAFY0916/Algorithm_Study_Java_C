package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B14369 {

    static String[] alphabet = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    static int[] charCnt;

    static StringBuilder sb;

    static int[] result;

    static boolean flag;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            flag = false;
            charCnt = new int[26];
            result = new int[10];
            String input = br.readLine();
            for (int j = 0; j < input.length(); ++j) {
                charCnt[input.charAt(j) - 'A'] += 1;
            }
            backtracking(i+1);
        }
        System.out.println(sb);
    }

    private static void backtracking(int n) {

        if (flag) return ;

        if (isEmpty()) {
            sb.append("Case #" + n + ": ");
            for (int i = 0; i <= 9; ++i) {
                if (result[i] > 0) {
                    for (int j = 0; j < result[i]; ++j) {
                        sb.append(i);
                    }
                }
            }
            sb.append("\n");
            flag = true;

            return ;
        }

        for (int i = 0; i <= 9; ++i) {
            String tmp = alphabet[i];
            for (int j = 0; j < tmp.length(); ++j) {
                charCnt[tmp.charAt(j)-'A']--;
            }
            if (check()) {
                result[i]++;
                backtracking(n);
                result[i]--;
            }

            for (int j = 0; j < tmp.length(); ++j) {
                charCnt[tmp.charAt(j)-'A']++;
            }

        }
    }

    private static boolean isEmpty() {
        for (int i = 0; i < charCnt.length; ++i) {
            if (charCnt[i] != 0) return false;
        }
        return true;
    }

    private static boolean check() {
        for (int i = 0; i < charCnt.length; ++i) {
            if (charCnt[i] < 0) return false;
        }
        return true;
    }

}
