import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            pq.offer(Integer.parseInt(br.readLine()));
        } // 입력 완료

        int answer = 0;
        if (pq.size() == 1) {
            System.out.println(0);
            return ;
        }
        while (pq.size() > 1) {
            int tmp = pq.poll() + pq.poll();
            pq.offer(tmp);
            answer += tmp;
        }

        System.out.println(answer);

    }

}
