import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6087_레이저통신_변준호 {
	static int N,M;
	static char[][] arr;
	static Queue<Node> mq = new ArrayDeque<>();
	static int dy[] = {-1,0,1,0}; //상좌하우
	static int dx[] = {0,-1,0,1};
	static int visit[][];
	static boolean visited[][][];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int startx = 0;int starty=0;
		int endx=0;int endy=0;
		arr = new char[N][M];
		visit = new int[N][M];
		visited = new boolean[N][M][4];
		boolean flag = false;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				arr[i][k] = str.charAt(k);
				if(arr[i][k]=='C') {
					if(!flag) {
						starty = i; startx= k;
						flag = true;
					}else {
						endy=i;endx=k;
					}
				}
			}
		}
		visit[starty][startx] = 1;
		mq.add(new Node(starty,startx,-1,0));
		
		bfs(endy,endx);
		System.out.println(result-1);
//		print();
	}
	
	private static void print() {
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				System.out.print(visit[i][k]+" ");
			}
			System.out.println();
		}
	}
	
	
	private static void bfs(int endy,int endx) {
		// TODO Auto-generated method stub
		while(!mq.isEmpty()) {
			
			Node tmp = mq.poll();
			int cy = tmp.y;
			int cx = tmp.x;
			int cd = tmp.d;
			int cm = tmp.m;
//			System.out.println(cy+" "+cx);
			if(cy==endy&&cx==endx) {
				result = Math.min(result,cm);
				continue;
			}
			for(int i=0;i<4;i++) {
				int ny = cy+dy[i];
				int nx = cx+dx[i];
				if(nx>=0&&ny>=0&&ny<N&&nx<M&&arr[ny][nx]!='*') {
					int nm = cm;
					if(cd!=i) {
						nm++;
					}
					if(visit[ny][nx]==0) {
						visit[ny][nx] = nm;
						visited[ny][nx][i] = true;
						mq.add(new Node(ny,nx,i,nm));
					}else if(visit[ny][nx]>nm) {
						visit[ny][nx] = nm;
						visited[ny][nx][i] = true;
						mq.add(new Node(ny,nx,i,nm));
					}else if(visit[ny][nx]==nm&&!visited[ny][nx][i]) {
						visited[ny][nx][i] = true;
						mq.add(new Node(ny,nx,i,nm));
					}
				}
			}
		
		}
	}




	static class Node{
		int y;
		int x;
		int d;
		int m;
		public Node(int y, int x, int d,int m) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.m = m;
		}
		
	}
}
/*
15 10
...*...***.C..*
.*.*.*........*
.*...*...*....*
.*.*....****.**
.*..**........*
.**..********.*
.*...*...*..*.*
.**..***.*.**.*
C........*.....
..***..........
답 6


*/