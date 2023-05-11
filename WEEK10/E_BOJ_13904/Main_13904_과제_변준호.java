import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13904_과제_변준호{
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int time[] = new int[1001];
		int N = Integer.parseInt(br.readLine());
		Node node[] = new Node[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			node[i] = new Node(a,b);
			time[a]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Arrays.sort(node);
//		for(Node n : node) {
//			System.out.println(n.time+" "+n.w);
//		}
		int n = 1000;
		int i = 0;
		int result = 0;
		while(n>0) {
			if(time[n]>0||!pq.isEmpty()) {
				while(true) {
//					System.out.println(node[i].time+" "+n);
					if(i<N&&node[i].time==n) {
						pq.add(node[i].w);
						i++;

					}else {
						break;
					}
				}
//				System.out.println(n+" "+pq.peek());
				result = result + pq.poll();
			}
			n--;
		}
		System.out.println(result);
		
	}
	
	
	
	static class Node implements Comparable<Node>{
		int time;
		int w;
		public Node(int time, int w) {
			super();
			this.time = time;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.time-this.time;
		}
		
	}
}