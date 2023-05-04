package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B7682 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;

            if(isValid(str)) sb.append("valid").append("\n");
            else sb.append("invalid").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isValid(String str) {
        char[] arr = str.toCharArray();

        int xNum=0, oNum=0;
        for (int i=0; i<9; ++i) {
            if (arr[i] == 'X') xNum++;
            if(arr[i] == 'O' ) oNum++;
        }

        int xMade = check('X', arr);
        int oMade = check('O', arr);

        if (xMade > 0 && oMade == 0 && xNum == oNum+1) return true;
        if (xMade == 0 && oMade > 0 && xNum == oNum) return true;
        if (xMade == 0 && oMade == 0 && xNum == 5 && oNum == 4) return true;

        return false;


    }

    private static int check(char c, char[] arr) {
        int cnt = 0;

        // 행
        for (int i=0; i<=6; i+=3){
            boolean flag = true;
            if (arr[i] != c) continue;

            for (int j = i+1; j < i + 3; ++j) {
                if (arr[i] != arr[j]) flag = false;
            }
            if (flag) cnt++;
        }

        // 열
        for (int i=0; i<=2; i++){
            boolean flag = true;
            if (arr[i] != c) continue;

            for (int j = i+3; j < 9; j+=3) {
                if (arr[i] != arr[j]) flag = false;
            }
            if (flag) cnt++;
        }

        // 대각
        if (arr[0] == c && arr[4] == c && arr[8] == c) cnt++;
        if (arr[2] == c && arr[4] == c && arr[6] == c) cnt++;

        return cnt;
    }

}
