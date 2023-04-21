import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3_변준호{
	/*
	 * 0 -> 빈칸 1 -> 벽 2 -> 바이러스
	 * N*N M개의 바이러스 
	 * 1. M개 바이러스 고르기
	 * 2. BFS
	 * 3. 원래 바이러스 있었던 자리는 빼야함 
	 */
	static int N,M;
	static int arr[][] ; 
	static List<Location> virus = new ArrayList<>();
	static boolean visit[];
	static Location result[];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,1,-1};
	static int realresult = Integer.MAX_VALUE;
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		result = new Location[M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				if(arr[i][k]==2) {
					arr[i][k] = 0;
					//바이러스 저장 
					virus.add(new Location(i,k));
				}
			}
		}
		visit = new boolean[virus.size()];
		back(0,0);//바이러스 고르기 M개
		if(realresult == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(realresult-2);
		}
	}

	private static void back(int def, int start) {
		// TODO Auto-generated method stub
		if(def==M) {
			//퍼지기 하기
			bfs();
			return;
		}
		for(int i=start;i<virus.size();i++) {
			result[def] = virus.get(i);
			back(def+1,i+1);
		}
	}
	
	
	
	private static void bfs() {
		// TODO Auto-generated method stub
		int arrC[][] = copy();
		Queue<Location> mq = new ArrayDeque<>();
		for(int i=0;i<M;i++) {
			mq.add(result[i]);
			arrC[result[i].y][result[i].x] = 2; //벽이 1이라 2부터 시작 
		}
		while(!mq.isEmpty()) {
			Location tmp = mq.poll();
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<N&&arrC[cy][cx]==0) {
					arrC[cy][cx] = arrC[tmp.y][tmp.x]+1;
					mq.add(new Location(cy,cx));
				}
			}
		}

		//결과값 계산하기
		//1. 바이러스 있던 자리 2로 채워 넣기 why
		for(int i=0;i<virus.size();i++) {
			arrC[virus.get(i).y][virus.get(i).x] = 2;
		}
		int result = Integer.MIN_VALUE;
		boolean flag = true;
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(arrC[i][k]!=1) { //벽이 아니라면 
					result = Math.max(result, arrC[i][k]);
				}
				if(arrC[i][k]==0) {
					flag = false;
				}
			}
		}
		// !flag -> 모든 곳에 바이러스를 퍼트릴 수 없었음 
		if(flag) {
			realresult = Math.min(result, realresult);
		}
	}


	private static int[][] copy() {
		// TODO Auto-generated method stub
		int arrC[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				arrC[i][k] = arr[i][k];
			}
		}
		return arrC;
	}





	static class Location{
		int y;
		int x;
		public Location(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}