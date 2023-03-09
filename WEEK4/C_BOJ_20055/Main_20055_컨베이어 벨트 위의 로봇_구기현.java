package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B20055 {

    static int N, K;
    static int[] durability;
    static boolean[] hasRobot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 벨트 길이
        K = Integer.parseInt(st.nextToken()); // 내구도 0인 칸의 수가 K 이상일 때 종료
        hasRobot = new boolean[N];
        durability = new int[2*N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; ++i) {
            durability[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        int cnt = 0;

        while(check()) {
            cnt++;
            
            rotate();
            hasRobot[N-1] = false; // 이동시 내려주기
            move();
            hasRobot[N-1] = false; // 이동시 내려주기
            putRobot();
        }

        System.out.println(cnt);



    }

    private static void putRobot() {
        if (durability[0] > 0){
            hasRobot[0] = true;
            durability[0]--;
        }
    }

    private static void move() {
        for (int i = N - 1; i > 0; --i) {
            if (hasRobot[i-1] && !hasRobot[i] && durability[i] >= 1) {
                hasRobot[i] = true;
                hasRobot[i-1] = false;
                durability[i] --;
            }
        }
    }

    private static void rotate() {
        int tmp = durability[2*N-1];
        for (int i = 2*N-1; i > 0; --i) {
            durability[i] = durability[i-1];
        }
        durability[0] = tmp;

        boolean ttmp = hasRobot[N - 1];
        for (int i = N-1; i > 0; --i) {
            hasRobot[i] = hasRobot[i-1];
        }
        hasRobot[0] = ttmp;
    }

    private static boolean check() {

        int cnt = 0;
        for (int i = 0; i < 2*N; ++i) {
            if (durability[i] == 0) cnt++;
        }

        if (cnt >= K) return false;

        return true;
    }

}