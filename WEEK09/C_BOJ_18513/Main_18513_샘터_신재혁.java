import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18513_샘터_신재혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Long> Q = new ArrayDeque<>();
        Set<Long> hice = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            long pond = Long.parseLong(st.nextToken());
            Q.offer(pond);
            hice.add(pond);
        }
        System.out.println(bfs(Q, hice, K));
    }
    public static long bfs(Queue<Long> Q, Set<Long> hice, int K){
        long sum = 0;
        long depth = 1;
        while(!Q.isEmpty()){
            int size = Q.size();
            while(size > 0){
                long d = Q.poll();
                for(long i = d-1; i <= d+1; i += 2){ // d-1, d+1
                    if(K > 0 && !hice.contains(i)){
                        K--;
                        sum += depth;
                        hice.add(i);
                        Q.offer(i);
                    }
                    if(K == 0){
                        return sum;
                    }
                }
                size--;
            }
            depth++;
        }
        return sum;
    }

}