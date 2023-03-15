package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1058 {


    static int N;
    static boolean[][] adjMatrix;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adjMatrix = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            String str = br.readLine();
            for (int j = 0; j < N; ++j) {
                if (str.charAt(j) == 'Y') adjMatrix[i][j] = true;
            }
        } // 입력 완료


        int cnt;
        for (int i = 0; i < N; ++i) {
            cnt = getFriends(i);
            max = Math.max(cnt, max);
        }
        System.out.println(max);

    }

    private static int getFriends(int n) {
        int cnt = 0;
        // i : 친구인지 체크 대상
        for (int i = 0; i < N; ++i) {
            if (n == i) continue;

            if (adjMatrix[n][i]){
                cnt++;
                continue;
            }

            int tmp = 0;
            // false 일 때 2-친구 인지 체크
            // 체크 대상 친구의 친구 찾기
            for (int j = 0; j < N; ++j) {
                if (j == i) continue;

                // 체크 대상 친구의 친구가 n이랑 친구인지
                if (adjMatrix[i][j]) {
                    if (adjMatrix[j][n]) {
                        cnt++;
                        // 여러가지 경우의 수가 있을 수 있기에 끊어줘야 함
                        break;
                    }
                }
            }
        }
        return cnt;
    }


}