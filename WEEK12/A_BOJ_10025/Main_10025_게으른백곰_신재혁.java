import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10025_게으른백곰_신재혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int [1000001];//1000001
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }
//        System.out.println(Arrays.toString(arr));
        int sum = 0;
        int pos = 0;
        int max = -1;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(i > 2*K){
                sum -= arr[i-2*K-1];
            }

            if(sum > max){
                max = Math.max(max,sum);
                pos = i-K;
            }

        }
        System.out.println(max);
    }
}
