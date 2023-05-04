package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B15927 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean flag = false;
        int len = input.length();

        for (int i = 0; i < len / 2; ++i) {
            if (input.charAt(i) != input.charAt(len-i-1)) {
                System.out.println(len);
                return ;
            } else if (input.charAt(i) != input.charAt(i+1)) flag = true;
        }

        if (flag) System.out.println(len-1);
        else System.out.println(-1);
    }





}

