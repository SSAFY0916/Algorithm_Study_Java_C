package Algorithm_Study_Java2.WEEK7.A_BOJ_3980;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3980_선발명단_신재혁 {
    public static boolean[] selected;
    public static int maxSum;
    public static int[][] position;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            position = new int[11][11];
            for(int i = 0; i < 11; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 11; j++){
                    position[i][j] = Integer.parseInt(st.nextToken());
                }
//                System.out.println(Arrays.toString(position[i]));
            }
            maxSum = 0;
            selected = new boolean[11];
            permute(0, 0);
            System.out.println(maxSum);
        }
    }
    public static void permute(int count, int sum){
        if(count == 11){
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for(int i = 0; i < 11; i++){
            if(!selected[i] && position[i][count] > 0){
                selected[i] = true;
                permute(count+1,sum+position[i][count]);
                selected[i] = false;
            }
        }
    }
}
