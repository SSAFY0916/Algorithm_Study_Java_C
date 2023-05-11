import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1368_물대기_변준호{
	static int parent[];
	static int N;
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		parent = new int[N+1];
		for(int i=0;i<=N;i++) {
			parent[i] = i;
		}
		PriorityQueue<Node> mq = new PriorityQueue<>();

		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			mq.add(new Node(N,i,arr[i]));
		}
		int matrix[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				matrix[i][k] = Integer.parseInt(st.nextToken());
				mq.add(new Node(i,k,matrix[i][k]));

			}
		}
	
		long result = 0;
		int cnt = 0;
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
//			System.out.println(tmp);
			if(union(tmp.n1,tmp.n2)) { //합쳐져안있으면
//				System.out.println(Arrays.toString(parent));
				result = result+tmp.w;
				cnt++;
			}
			if(cnt==N) {
				break;
			}
		}
		System.out.println(result);
	}
	
	private static boolean union(int a, int b) {
		// TODO Auto-generated method stub
		a = find(a);
		b = find(b);
		if(a==b) {
			return false;
		}else {
			parent[b] = a;
			return true;
		}
	}

	private static int find(int a) {
		// TODO Auto-generated method stub
		if(parent[a]==a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}











	static class Node implements Comparable<Node>{
		int n1;
		int n2;
		int w;
		public Node(int n1, int n2, int w) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		@Override
		public String toString() {
			return "Node [n1=" + n1 + ", n2=" + n2 + ", w=" + w + "]";
		}
		
		
		
	}
}