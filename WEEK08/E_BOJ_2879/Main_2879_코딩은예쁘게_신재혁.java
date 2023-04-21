import java.io.*;
import java.util.*;

public class Main_2879_코딩은예쁘게_신재혁 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] start = new int[N];
        int[] dest = new int[N];
        int[] diff = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            start[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            dest[i] = Integer.parseInt(st.nextToken());
            diff[i] = dest[i] - start[i];
        }
        int count = 0;
        for(int i = 0; i < N; i++){
            int delta = diff[i];
            if(delta== 0) continue;
            count += Math.abs(delta);
            boolean sign = delta > 0;
            int deltaPrev = delta;
            for(int j = i; j < N && diff[j] > 0 == sign; j++){
                int nextDelta = diff[j];
                if(Math.abs(diff[j]) > Math.abs(deltaPrev))
                    diff[j] -= deltaPrev;
                else{
                    diff[j] = 0;
                    deltaPrev = nextDelta;
                }
            }
        }
        System.out.println(count);
    }
}
