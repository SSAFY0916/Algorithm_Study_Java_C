package Algorithm_Study_Java2.WEEK7.C_BOJ_1640;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1640_동전뒤집기_신재혁 {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char [N][M];
        boolean[] rows = new boolean[N];
        boolean[] cols = new boolean[M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(map[i][j] == '0'){
                    rows[i] = !rows[i];
                    cols[j] = !cols[j];
                }
            }
        }
        int rowCount = 0; // 홀수인 행 개수
        for(int i = 0; i < N; i++){
            if(!rows[i])
                rowCount++;
        }
        int colCount = 0; // 홀수인 열 개수
        for(int i = 0; i < M; i++){
            if(!cols[i])
                colCount++;
        }
        System.out.println(Math.min(rowCount, colCount) % 2 == 0 ? Math.min(rowCount + colCount, N - rowCount + M - colCount) : Math.min(rowCount + M - colCount, N - rowCount + colCount));
    }
}