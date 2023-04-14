import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_12869_뮤탈리스크_변준호{
	static int damage[][] = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,3,9},{1,9,3}};
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[3];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Queue<Node> mq = new ArrayDeque<>();
		boolean visit[][][] = new boolean[61][61][61];
		visit[arr[0]][arr[1]][arr[2]] = true;
		mq.add(new Node(arr[0],arr[1],arr[2],0));
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			if(tmp.s1==0&&tmp.s2==0&&tmp.s3==0) {
				System.out.println(tmp.cnt);
			}
			for(int i=0;i<6;i++) {
				int tmp1 = tmp.s1 - damage[i][0];
				int tmp2 = tmp.s2 - damage[i][1];
				int tmp3 = tmp.s3 - damage[i][2];
				if(tmp1<0) {
					tmp1 = 0;
				}
				if(tmp2<0) {
					tmp2 = 0;
				}
				if(tmp3<0) {
					tmp3 = 0;
				}
				if(visit[tmp1][tmp2][tmp3]) {
					continue;
				}
				visit[tmp1][tmp2][tmp3] = true;
				mq.add(new Node(tmp1,tmp2,tmp3,tmp.cnt+1));
			}
		}
		
	}
	
	static class Node{
		int s1;
		int s2;
		int s3;
		int cnt;
		public Node(int s1, int s2, int s3, int cnt) {
			super();
			this.s1 = s1;
			this.s2 = s2;
			this.s3 = s3;
			this.cnt = cnt;
		}
		
	}

}