import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13424_비밀모임_변준호 {
	static int V;
	static List<Edge> []list;
	static int result[];
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V+1];
			result = new int[V+1];
			for(int i=1;i<=V;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[a].add(new Edge(b,c));
				list[b].add(new Edge(a,c));
			}
			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int friends[] = new int[num];
			for(int i=0;i<num;i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<num;i++) {
				dijk(friends[i]);
			}
			int roomNo = 0;
			int min =Integer.MAX_VALUE;
			for(int i=1;i<=V;i++) {
				if(min>result[i]) {
					min = result[i];
					roomNo =i;
				}
			}
			sb.append(roomNo).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dijk(int start) {
		// TODO Auto-generated method stub
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		int distance[] = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		pq.add(new Edge(start,0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int curr = tmp.index;
			//방문햇으면 넘어가기 
			if(check[curr]) {
				continue;
			}
			check[curr] = true; //방문체크
			
			for(Edge edge : list[curr]) {
				if(distance[edge.index]>distance[curr]+edge.w) {
					distance[edge.index]=distance[curr]+edge.w;
					pq.add(new Edge(edge.index,distance[edge.index]));
				}
			}
			
		}
		for(int i=1;i<=V;i++) {
			result[i] += distance[i];
		}
//		System.out.println(Arrays.toString(distance));
	}

	static class Edge implements Comparable<Edge>{

		int index;
		int w;
		public Edge(int index, int w) {
			super();
			this.index = index;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}
}
