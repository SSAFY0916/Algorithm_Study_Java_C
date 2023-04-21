import java.io.*;
import java.util.*;
public class Main{
    public static void main(String args[]) throws Exception{
        int N,M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int m[] = new int[N];
        int c[] = new int[N];
        int dp[] = new int[10001];
        st = new StringTokenizer(br.readLine());
        for(int x=0;x<N;x++){
            m[x] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int x=0;x<N;x++){
            c[x] = Integer.parseInt(st.nextToken());
        }
        for(int x=0;x<N;x++){
            for(int y=10000-c[x];y>=0;y--){
                dp[y+c[x]] = Integer.max(dp[y+c[x]],dp[y]+m[x]);
            }
            dp[c[x]] = Integer.max(dp[c[x]],m[x]);
        }
        for(int x=0;x<=10000;x++){
            if(dp[x]>=M){
                System.out.println(x);
                break;
            }
        }
    }
}