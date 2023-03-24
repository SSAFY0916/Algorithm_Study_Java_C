package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16987 {

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Egg{" +
                    "durability=" + durability +
                    ", weight=" + weight +
                    '}';
        }
    }

    static int N;
    static Egg[] eggs;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        } // 입력 완료

        beatEggs(0, 0);

        System.out.println(max>0? max:0);
    }

    // idx : 집은 계란
    private static void beatEggs(int idx, int sum) {
        if (idx == N) return ;

        // 집은 계란이 깨져있을 경우 다음 계란 집기
        if (eggs[idx].durability <= 0) {
            beatEggs(idx+1, sum);
            return ;
        }

        // i : 깨지지 않은 계란 중 하나 고르기
        for (int i = 0; i < N; ++i) {

            if (idx == i) continue; // 같은 계란 집었을 경우 스킵
            if (eggs[i].durability <= 0) continue; // 때릴 계란이 깨져있을 경우 스킵

            // 계란치기
            eggs[idx].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[idx].weight;

            int cnt = 0;
            if (eggs[idx].durability <= 0) cnt++;
            if (eggs[i].durability <= 0) cnt++;

            max = Math.max(max, sum + cnt);

            beatEggs(idx+1, sum+cnt);

            // 복원
            eggs[idx].durability += eggs[i].weight;
            eggs[i].durability += eggs[idx].weight;
        }



    }
}