import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_13904_과제_신재혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> PQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1],o1[1]));
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] task = new int[2];
            task[0] = Integer.parseInt(st.nextToken());
            task[1] = Integer.parseInt(st.nextToken());
            PQ.offer(task);
        }
        int sum = 0;
        boolean[] scores = new boolean[1001];
        while(!PQ.isEmpty()){
            int[] task = PQ.poll();
            for(int i = task[0]; i > 0; i--){
                if(!scores[i]) {
                    sum += task[1];
                    scores[i] = true;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}