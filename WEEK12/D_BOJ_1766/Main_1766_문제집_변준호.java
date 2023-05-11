import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1766_문제집_변준호{
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		int count[] = new int[N+1];
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			count[b]++;
		}
		
		PriorityQueue<Integer> mq = new PriorityQueue<>();
		for(int i=1;i<=N;i++) {
			if(count[i]==0) {
				mq.add(i);
			}
		}
		while(!mq.isEmpty()) {
			int tmp = mq.poll();
			System.out.print(tmp+" ");
			for(int i=0;i<list.get(tmp).size();i++) {
				count[list.get(tmp).get(i)]--;
				if(count[list.get(tmp).get(i)]==0) {
					mq.add(list.get(tmp).get(i));
				}
			}
		}
		br.close();
	}
	static class Node implements Comparable<Node>{
		int def;
		int c;
		public Node(int def, int c) {
			super();
			this.def = def;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.def==o.def) {
				return this.c-o.c;
			}else {
				return this.def - o.def;
			}
		}
		
	}
}