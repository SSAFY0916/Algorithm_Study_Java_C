import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] score = new int[n];

        int[][] stds = new int[n][m];

        for(int i=0; i<n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; ++j) {
                stds[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(stds[i]);
        } // 입력 완료
        for(int j=m-1; j>=0; --j) {
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; ++i) {
                if (stds[i][j] > max) {
                    max = stds[i][j];
                }
            }
            for(int i=0; i<n; ++i) {
                if (stds[i][j] == max) {
                    score[i]++;
                }
            }
        }

//		System.out.println(Arrays.toString(score));

        int maxScore = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i) {
            if(score[i] > maxScore) maxScore = score[i];
        }


        for(int i=0; i<n; ++i) {
            if(score[i] ==  maxScore) System.out.print((i+1) + " ");;
        }

    }

}
