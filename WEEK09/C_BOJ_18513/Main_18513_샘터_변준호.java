
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18513_샘터_변준호 {
	/*
	 * N개의 샘터 K채의 집 BFS로 풀어야 겠다.
	 */
	static long N;
	static long K;
	static int move[] = { -1, 1 };

	static Queue<Node> mq = new ArrayDeque<>();
	static long sad = 0;
	static HashSet<Long> set = new HashSet<>();

	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long a = Long.parseLong(st.nextToken());
			mq.add(new Node(a, a));
			set.add(a);
		}

		bfs();
		System.out.println(sad);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		int k = 0;
		while (!mq.isEmpty()) {
			Node tmp = mq.poll();
			for (int i = 0; i < 2; i++) {
				if (K == k) {
					return;
				}
				long dindex = move[i] + tmp.index;

				if (!set.contains(dindex)) {
					sad = sad + Math.abs(dindex - tmp.home);
					set.add(dindex);
					mq.add(new Node(dindex, tmp.home));
					k++;
				}
			}
		}
	}

	static class Node {
		long index;
		long home;

		public Node(long index, long home) {
			super();
			this.index = index;
			this.home = home;
		}

	}
}