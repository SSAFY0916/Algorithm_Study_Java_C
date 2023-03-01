import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기_변준호{
	static int N,C;
	static int arr[][];
	static int command[][];
	static int dy[] = {0,-1,-1,-1,0,1,1,1}; // 좌 - 상 - 우 - 하 - 
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	//대각선 
	static int ddy[] = {-1,-1,1,1}; 
	static int ddx[] = {-1,1,-1,1};
	
	static boolean visit[][];
	
	static Queue<int[]> cloud = new ArrayDeque<>();
	public static void main(String[] agrs) throws IOException {
	/*
	 * 1. 구름 이동  
	 * 2. 구름 칸 물+1
	 * 3. 대각선 방향 물 있는 수 만큼 물 증가 
	 * 4. 2이상 칸 구름 생기고 물-2
	 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		command = new int[C][2];
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0] = Integer.parseInt(st.nextToken());
			command[i][1] = Integer.parseInt(st.nextToken());
		}
		cloud.add(new int[] {N-1,0});
		cloud.add(new int[] {N-1,1});
		cloud.add(new int[] {N-2,0});
		cloud.add(new int[] {N-2,1});
		for(int i=0;i<C;i++) {
			move(command[i][0],command[i][1]);
			rain(); //비내리기
			bug();  //물복사 버그 
			makeCloud();
//			print();
//			System.out.println();
		}
		//물의 합 구하기
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				sum = sum+arr[i][k];
			}
		}
		System.out.println(sum);
	
	}
//	private static void print() {
//		// TODO Auto-generated method stub
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<N;k++) {
//				System.out.print(arr[i][k]+" ");
//			}
//			System.out.println();
//		}
//	}
	private static void makeCloud() {
		// TODO Auto-generated method stub
		cloud.clear();
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visit[i][k]&&arr[i][k]>=2) {
					cloud.add(new int[] {i,k});
					arr[i][k] = arr[i][k] -2;
				}
			}
		}
		for(int i=0;i<N;i++) {
			Arrays.fill(visit[i], false);
		}
		
	}
	private static void bug() {
		// TODO Auto-generated method stub
		while(!cloud.isEmpty()) {
			int tmp[] = cloud.poll();
			int cnt = 0;
			for(int i=0;i<4;i++) {
				int cy = tmp[0]+ddy[i];
				int cx = tmp[1]+ddx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<N&&arr[cy][cx]!=0) {
					cnt++;
				}
			}
			arr[tmp[0]][tmp[1]] = arr[tmp[0]][tmp[1]]+cnt;
			visit[tmp[0]][tmp[1]] = true;
		}
	}
	private static void rain() {
		// TODO Auto-generated method stub
		for(int i=0;i<cloud.size();i++) {
			int tmp[] = cloud.poll();
			arr[tmp[0]][tmp[1]]+=1;
			cloud.add(tmp);
		}
	}
	private static void move(int d, int s) {
		// TODO Auto-generated method stub
		s = s%N;
		for(int i=0;i<cloud.size();i++) {
			int tmp[] = cloud.poll();
			tmp[0] = (tmp[0]+(s*dy[d-1]+N))%N;
			tmp[1] = (tmp[1]+(s*dx[d-1]+N))%N;
			cloud.add(tmp);
//			System.out.println(tmp[0]+" "+tmp[1]);
		}
	}
}