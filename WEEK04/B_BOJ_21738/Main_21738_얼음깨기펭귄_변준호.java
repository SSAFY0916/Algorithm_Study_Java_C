import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21738_얼음깨기펭귄_변준호 {
	// N  얼음 블록의 갯수 S(1~S지지대) 펭귄이 위치한 얼음 블록 P
	// N -> 연결
	//BFS 로 가장 빨리 도착 찾기?
	static int result = 0;
	static int N;
	static int S;
	static int P;
	static List<ArrayList<Integer>> list = new ArrayList<>();
	static Queue<Integer> mq = new ArrayDeque<>();
	static int visit[];
	public static void main(String[] args) throws IOException {
//		System.out.println(1);
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i=0;i<N;i++) {
			Collections.sort(list.get(i));
		}
		visit = new int[N+1];
		for(int i=1;i<=S;i++) {
			mq.add(i);
			visit[i] = 1;
		}
		bfs();
		System.out.println(N-result+1);
	}
	private static void bfs() {
		int flag = 0;
		// TODO Auto-generated method stub
		while(!mq.isEmpty()) {
			int curr = mq.poll();
//			System.out.print(curr+" ");

			for(int i=0;i<list.get(curr).size();i++) {
				int tmp = list.get(curr).get(i);
				if(visit[tmp]==0) {
					if(tmp == P) {
						flag++;
						result += visit[curr]+1;
						if(flag==2) {
							return;
						}
						continue;
					}
					mq.add(tmp);
					visit[tmp] = visit[curr]+1;
				}
			}
		}
	}

}
