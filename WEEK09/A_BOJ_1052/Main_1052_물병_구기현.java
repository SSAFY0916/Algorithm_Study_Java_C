import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0; // 구매한 물병 수
        while(true) {

            int total = N + cnt; // 총 물병

            int tmp = 0; // 2로 나누면서 남는 놈들 세기 위한 임시 변수
            while (total > 0) {
                if (total % 2 == 1) tmp++;
                total /= 2;
            }
            // 최대한 합쳐보고 남은 물병 수 K보다 크면 구매하고 재도전
            if (tmp <= K) break;
            cnt++; // 체크 해보고 안되면 물병 하나씩 구매
        }
        System.out.println(cnt);

    }

}
