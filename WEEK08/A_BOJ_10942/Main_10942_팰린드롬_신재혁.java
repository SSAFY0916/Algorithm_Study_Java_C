import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬_신재혁 {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(isPalindrome(S,E)).append('\n');
        }
        System.out.println(sb);
    }
    public static int isPalindrome(int S, int E){
        int first = S-1;
        int last = E-1;
        while(first < last){
            if(arr[first] != arr[last]){
                return 0;
            }
            first++;
            last--;
        }
        return 1;
    }
}
