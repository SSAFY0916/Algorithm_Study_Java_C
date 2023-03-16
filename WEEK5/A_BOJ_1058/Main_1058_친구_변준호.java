import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1058_친구_변준호{
	static int N;
	static int arr[][];
	static int result = 0;
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<N;k++) {
				if(str.charAt(k)=='N') {
					arr[i][k] = 0;
				}else {
					arr[i][k] = 1;
				}
			}
		}
		for(int i=0;i<N;i++) {
			int a = bfs(i);
			result = Math.max(a, result);
		}
		System.out.println(result);
	}
	private static int bfs(int node) {
		// TODO Auto-generated method stub
		int visit[] = new int[N];
		Queue<Integer> mq = new ArrayDeque<>();
		mq.add(node);
		visit[node] = 1;
		while(!mq.isEmpty()) {
			int curr = mq.poll();
			for(int i=0;i<N;i++) {
				if(arr[curr][i]==1&&visit[i]==0) {
					visit[i]=visit[curr]+1;
					mq.add(i);
				}
			}
		}
		int tmp = 0;
		for(int i=0;i<N;i++) {
			if(visit[i]<4&&visit[i]>1) {
				tmp++;
			}
		}
		return tmp;
	}
}