import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10025_게으른백곰_오승기 {

    static int N,K;
    static long max;
    static int[] bucket;

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 좌표 수
        K = Integer.parseInt(st.nextToken()); // 좌우거리
        bucket = new int[1_000_001];
        max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            bucket[x] = g;
        }

        // 초기 세팅
        int i = 0; // 시작
        int j = (2*K); // 끝
        int sum = 0;
        for(int a = i; a <= j && a < bucket.length-1; a++) {
            sum += bucket[a];
            if(a == bucket.length-1) {
                System.out.println(sum);
                System.exit(0);
            }
        }

        max = Math.max(max,sum);

        while(j < bucket.length-1) {
            sum -= bucket[i++];
            sum += bucket[++j];
            max = Math.max(max,sum);
        }

        System.out.println(max);

    }

}