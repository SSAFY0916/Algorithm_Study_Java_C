import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션_변준호 {
	/*
	 * A : 가로 B : 세로 
	 * N : 로봇 M : 명령 수 
	 * N북 W서 E동 S남
	 * L R F 
	 *  Robot X crashes into the wall 벽 뷰
	 *  Robot X crashes into robot Y 로 뷰
	 */
	static char dir[] = {'N','E','S','W'}; //북동남서
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int A,B;
	static int arr[][]; //로봇의 현재 위치 저장 
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[B+1][A+1];
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Robot robot[] = new Robot[N+1]; 
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = B+1-Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			if(d=='N') {
				robot[i] = new Robot(i,y,x,0);
			}else if(d=='E') {
				robot[i] = new Robot(i,y,x,1);
			}
			else if(d=='S') {
				robot[i] = new Robot(i,y,x,2);
			}else {
				robot[i] = new Robot(i,y,x,3);
			}
			arr[y][x] = i; // 로봇 현재 위치 저장 
		}
		
		for(int i=0;i<M;i++) {
//			print();
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			int cnt = Integer.parseInt(st.nextToken());
			while(cnt>0) {
				cnt--;
				if(d=='F') {
					Robot cur = robot[idx];
					int cy = cur.y+dy[cur.d];
					int cx = cur.x+dx[cur.d];
//					System.out.println(cy+""+cx);
					if(cy<=0||cx<=0||cy>B||cx>A) {
						System.out.printf("Robot %d crashes into the wall",idx);
						return;
					}
					if(arr[cy][cx]!=0) {
						System.out.printf("Robot %d crashes into robot %d",idx,arr[cy][cx]);
						return;
					}
					arr[cy][cx] = idx;
					arr[cur.y][cur.x] = 0;
					robot[idx] = new Robot(idx,cy,cx,cur.d);
				}else if(d=='L') {
					Robot cur = robot[idx];
					robot[idx] = new Robot(idx,cur.y,cur.x,((cur.d-1+4)%4));
				}else {
					Robot cur = robot[idx];
					robot[idx] = new Robot(idx,cur.y,cur.x,((cur.d+1)%4));
				}
			}
		}
		System.out.println("OK");
	}
	
	public static void print() {
		System.out.println();
		for(int i=1;i<=B;i++) {
			for(int k=1;k<=A;k++) {
				System.out.print(arr[i][k]+" ");
			}
			System.out.println();
		}
	}
	
	
	
	static class Robot{
		int index;
		int y;
		int x;
		int d;
		public Robot(int index, int y, int x, int d) {
			super();
			this.index = index;
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
}
