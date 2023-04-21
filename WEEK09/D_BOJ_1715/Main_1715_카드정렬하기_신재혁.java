import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1715_카드정렬하기_신재혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Long> PQ = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
            PQ.offer(Long.parseLong(br.readLine()));
        long sum = 0;
        while(PQ.size() >= 2){
            long num = PQ.poll() + PQ.poll();
            sum += num;
            PQ.offer(num);
        }
        System.out.println(sum);
    }

}