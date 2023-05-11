import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션_오승기 {
	
	static int ROW,COL,N,M;
	static int[][] board;
	static List<Robot> robots;
	static int[] dx = {-1,0,1,0}; // 상 우 하 좌
	static int[] dy = {0,1,0,-1};
	static boolean flag = false;
	
	static class Robot {
		int x,y,dir;
		
		public Robot(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		board = new int[COL][ROW];
		robots = new ArrayList<Robot>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) { // 로봇 입력 부분
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			board[x][y] = i;
			String temp = st.nextToken();
			int dir = -1;
			if(temp.equals("N")) { //하
				dir = 2;
			} else if(temp.equals("W")) { //좌
				dir = 3;
			} else if(temp.equals("E")) { //우
				dir = 1;
			} else if(temp.equals("S")) { //상
				dir = 0;
			}
			robots.add(new Robot(x, y, dir));
			//System.out.println(dir);
		}
		
		loop:
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if(flag) {
				continue;
			}
			int num = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			int repeat = Integer.parseInt(st.nextToken());
			
			Robot curR = robots.get(num-1);
			if(command.equals("F")) {
				int nx = curR.x;
				int ny = curR.y;
				int curDir = curR.dir;
				board[nx][ny] = 0;
				for(int j = 0; j < repeat; j++) {
					nx += dx[curDir];
					ny += dy[curDir];
					
					//System.out.println("nx >> " + nx);
					//System.out.println("ny >> " + ny);
					
					if(nx<0 || nx>=COL || ny<0 || ny>=ROW) {
						sb.append("Robot "+num+" crashes into the wall");
						flag = true;
					} else if(board[nx][ny] > 0) {
						sb.append("Robot "+num+" crashes into robot "+board[nx][ny]);
						flag = true;
					}
					
					if(flag) {
						continue loop;
					}
				}
				board[nx][ny] = num;
				robots.get(num-1).x = nx;
				robots.get(num-1).y = ny;
			} else if(command.equals("R")) { // 상 우 하 좌
				int dir = curR.dir;
				for(int j = 0; j < repeat; j++) {
					dir = (dir+3)%4;
				}
				//System.out.println(dir);
				robots.get(num-1).dir = dir;
			} else if(command.equals("L")) {
				int dir = curR.dir;
				for(int j = 0; j < repeat; j++) {
					dir = (dir+1)%4;
				}
				//System.out.println(dir);
				robots.get(num-1).dir = dir;
			}
		}
		
		if(flag) {
			System.out.println(sb.toString());
		} else {
			System.out.println("OK");			
		}
		

	}

}
