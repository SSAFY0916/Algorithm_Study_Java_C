package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17609 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String str;
        for (int i = 0; i < N; ++i) {
            str = br.readLine();
            check(str);
            System.out.println(result);
        }


    }

    private static void check(String str) {
        result = 0;
        int left=0;
        int right = str.length()-1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                boolean removeLeft = removeAndCheck(left+1, right, str);
                boolean removeRight = removeAndCheck(left, right-1, str);

                if ((removeLeft  || removeRight)) result = 1;
                else result = 2;

                break;

            }
            left++;
            right--;
        }
    }

    private static boolean removeAndCheck(int left, int right, String str) {
        while(left <= right){
            if(str.charAt(left) != str.charAt(right)) return false;

            left++;
            right--;
        }
        return true;

    }

}