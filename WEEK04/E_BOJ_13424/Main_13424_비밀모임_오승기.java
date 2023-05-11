import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_13424_비밀모임 {
	
	static int T,N,M,a,b,c,K,min;
	static List<Node>[] nodeList;
	static int[] roomNum;
	static int[] result,sumResult;
	static Queue<Node> q;
	
	static class Node implements Comparable<Node>{
		int end,w;

		public Node(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine()); // 테케 수
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 방 수
			M = Integer.parseInt(st.nextToken()); // 비밀통로 수
			
			nodeList = new ArrayList[N+1]; // 방번호 1번부터 시작
			for(int i = 0; i < N+1; i++) {
				nodeList[i] = new ArrayList<>(); // 초기화
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				
				nodeList[a].add(new Node(b, c)); // 양방향이므로 바꿔서 두번 저장
				nodeList[b].add(new Node(a, c));
			}
			
			K = Integer.parseInt(br.readLine()); // 친구 수
			roomNum = new int[K];
			result = new int[N+1];
			sumResult = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < K; i++) { // 친구가 있는 방 저장
				roomNum[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < K; i++) {
				Arrays.fill(result, 999999); // 임시 큰 값
				result[roomNum[i]] = 0; // 본인 방
				
				dijkstra(roomNum[i]);
				
				for(int j = 0; j < N+1; j++) { // 또또 i j 틀림 ㅡㅡ
					sumResult[j] += result[j]; // 친구별로 각 방 최단거리 누적
				}
			}
			
			min = Integer.MAX_VALUE;
			int temp = 0;
			for(int i = 1; i < N+1; i++) {
				if(sumResult[i] < min) {
					min = sumResult[i];
					temp = i;
				}
			}
			sb.append(temp).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
		
	}

	private static void dijkstra(int s) {
		// TODO Auto-generated method stub
		q = new PriorityQueue<Node>();
		q.offer(new Node(s, 0)); // 시작 노드
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(result[cur.end] < cur.w) { // 저장된 값과 비교
				continue;
			}
			
			for(Node node : nodeList[cur.end]) {
				if(result[node.end] > result[cur.end] + node.w) {
					result[node.end] = result[cur.end] + node.w;
					q.offer(new Node(node.end, result[node.end]));
				}
			}
		}
	}

}
