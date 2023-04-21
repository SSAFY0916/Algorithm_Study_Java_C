import java.io.*;
import java.util.*;
public class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int src[] =new int[N];
        for(int x=0;x<N;x++) src[x] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int dst[] = new int[N];
        for(int x=0;x<N;x++) dst[x] = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int x=0;x<N;x++){
            int idx = 0;
            for(int y=1;y<N;y++){
	        	int diff = dst[y]-src[y];
	            if(diff*(dst[y-1]-src[y-1])<=0){
	                int m = dst[y-1]-src[y-1]<0 ? -1 : 1;
	                int temp = Integer.MAX_VALUE;
	                for(int z=idx;z<y;z++){
	                    temp = Integer.min(Math.abs(dst[z]-src[z]),temp);
	                }
	                for(int z=idx;z<y;z++){
	                	src[z]+=temp*m;
	                }
	                idx = y;
	                ans+=temp;
	            }
            }
            int m = dst[idx]-src[idx]<0 ? -1 : 1;
            int temp = Integer.MAX_VALUE;
            for(int z=idx;z<N;z++){
                temp = Integer.min(Math.abs(dst[z]-src[z]),temp);
            }
            for(int z=idx;z<N;z++){
            	src[z]+=temp*m;
            }
            ans+=temp;
        }
        System.out.println(ans);
    }
}