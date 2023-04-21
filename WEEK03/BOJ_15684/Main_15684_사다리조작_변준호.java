import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작_변준호{
	static int M,N;
	static int arr[][];
	static boolean end;
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; //오
			arr[a][b+1] = 2; //왼
		}
		
		//0~3 
		for(int i=0;i<=3;i++) {
			dfs(1,1,0,i);
			if(end==true) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
		
	}
	private static void dfs(int x, int y, int def, int n) {
		// TODO Auto-generated method stub
		if(end==true) {
			return;
		}
		if(def == n) {
			if(down()) {
				end = true;
			}
			return;
		}
		for(int i=y;i<=N;i++) {
			for(int k=x;k<M;k++) {
				if(arr[i][k]==0&&arr[i][k+1]==0) {
					arr[i][k] = 1;
					arr[i][k+1] =2;
					dfs(1,1,def+1,n);
					arr[i][k] = 0;
					arr[i][k+1] = 0;
				}
			}
		}
	}
	private static boolean down() {
        for (int i = 1; i <= M; i++) {
            int nx = i;
            int ny = 1;
 
            while (ny <= N) {
                if (arr[ny][nx] == 1) {
                	nx++; 
                }
                else if (arr[ny][nx] == 2) {
                	nx--; 
                }
                ny++; //무조건 내려가야함
            }
 
            if (nx != i) return false; 
        }
 
        return true;
    }
	public static void print() {
		for(int i=1;i<=N;i++) {
			for(int k=1;k<=M;k++) {
				System.out.print(arr[i][k]+" ");
			}
			System.out.println();
		}
		System.out.println();
		}
}