import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052_물병_신재혁 {
    static int N, K, bitCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 정수 N의 1 비트가 K개 이내가 되기 위해 더해야하는 수의 최소값은?
        int ans = 0;
        while(true){
            // 일단 현재 N의 1 비트 수를 세어야한다
            countBits();
            if(bitCount <= K)
                break;
            // 비트 수가 충분히 줄어들 때 까지 가장 낮은 비트를 더해야 한다. (펜윅트리에서 배운 내용과 비슷하다)
            int lo = N & -N; // 가장 낮은 비트 (펜윅트리에서 배운거)
            ans += lo;
            N += lo; // 가장 낮은 비트를 더함
        }
        System.out.println(ans);
    }
    static void countBits(){
        int n = N;
        bitCount = 0;
        while(n > 0){
            if((n & 1) != 0)
                bitCount++;
            n >>= 1;
        }
    }
}