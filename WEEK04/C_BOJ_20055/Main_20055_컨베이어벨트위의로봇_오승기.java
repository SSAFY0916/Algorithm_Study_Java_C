package solved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_20055_컨베이어벨트위의로봇 {
	
	static int N,K,cnt = 0;
	static int[][] conveyer;
	static boolean[] robot;
	static int level = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 한줄 길이
		K = Integer.parseInt(st.nextToken()); // 내구도  0 제한수
		
		conveyer = new int[2][N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) { // 내구도 세팅
			conveyer[0][i] = Integer.parseInt(st.nextToken());
		}
		for(int i = N-1; i >= 0; i--) {
			conveyer[1][i] = Integer.parseInt(st.nextToken());
		}
		
		
		Cycle();
		
		System.out.println(level);
		

	}

	private static void Cycle() {
		// TODO Auto-generated method stub
	
		level++;
		// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다
		int temp = conveyer[1][0];
		for(int i = 0; i < N-1; i++) { // 아랫줄 좌로 이동 
			conveyer[1][i] = conveyer[1][i+1];
		}
		
		conveyer[1][N-1] = conveyer[0][N-1]; // N -> N+1
	
		for(int i = N-1; i >= 1; i--) { // 윗줄 우로 이동
			conveyer[0][i] = conveyer[0][i-1];
			robot[i] = robot[i-1];
		}
		
		if(robot[N-1]) robot[N-1] = false; // 로봇 내리기
		
		conveyer[0][0] = temp;
		robot[0] = false;
		
		
		// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 
		// 만약 이동할 수 없다면 가만히 있는다
		// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다
		
		
		
		for(int i = N-1; i >= 1; i--) { // 윗줄이동
			if(conveyer[0][i] >= 1 && robot[i] == false && robot[i-1] == true) {
				robot[i] = true;
				robot[i-1] = false;
				conveyer[0][i]--;
				if(conveyer[0][i] == 0) cnt++;
			}
		}
		
		if(robot[N-1]) robot[N-1] = false; // 로봇이 있다면 내리기
		robot[0] = false;
		
		// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		//&& robot[0][0] == false
		if(conveyer[0][0] >= 1) {
			robot[0] = true;
			conveyer[0][0]--;
			if(conveyer[0][0] == 0) cnt++;
		}
		
		// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		if(cnt >= K) {
			return; 
		} else {
			Cycle();
		}
	}
	
	
}


/*// 뻘짓한 코드 ... 문제 좀 잘 읽자 ..
 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_20055_컨베이어벨트위의로봇 {
	
	static int N,K,cnt = 0;
	static int[][] conveyer;
	static boolean[][] robot;
	static int level = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 한줄 길이
		K = Integer.parseInt(st.nextToken()); // 내구도  0 제한수
		
		conveyer = new int[2][N];
		robot = new boolean[2][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) { // 내구도 세팅
			conveyer[0][i] = Integer.parseInt(st.nextToken());
		}
		for(int i = N-1; i >= 0; i--) {
			conveyer[1][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(conveyer[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		Cycle();
		
		System.out.println(level);
		

	}

	private static void Cycle() {
		// TODO Auto-generated method stub
	
		level++;
		// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다
		int temp = conveyer[1][0];
		for(int i = 0; i < N-1; i++) { // 아랫줄 좌로 이동 
			conveyer[1][i] = conveyer[1][i+1];
			robot[1][i] = robot[1][i];
		}
		
		if(robot[1][0]) robot[1][0] = false; // 로봇 내리기
		
		conveyer[1][N-1] = conveyer[0][N-1]; // N -> N+1
		robot[1][N-1] = robot[0][N-1];
		
		for(int i = N-1; i >= 1; i--) { // 윗줄 우로 이동
			conveyer[0][i] = conveyer[0][i-1];
			robot[0][i] = robot[0][i-1];
		}
		
		conveyer[0][0] = temp;
		robot[0][0] = false;
		
		
		// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 
		// 만약 이동할 수 없다면 가만히 있는다
		// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다
		
		for(int i = 0; i < N-1; i++) { // 아랫줄부터 이동 (2N칸은 비워져있음)
			if(conveyer[1][i] >= 1 && robot[1][i] == false && robot[1][i+1] == true) {
				// 이동되어질 칸이 비어있고 로봇이 존재하는 칸의 내구도가 1이상일 때 이동 가능
				robot[1][i] = true; 
				robot[1][i+1] = false;
				conveyer[1][i]--;
				if(conveyer[1][i] == 0) cnt++;
			}
		}
		
		if(robot[1][0]) robot[1][0] = false; // 로봇이 있다면 내리기
		
		if(conveyer[1][N-1] >= 1 && robot[1][N-1] == false && robot[0][N-1] == true) {
			robot[1][N-1] = true;  // N -> N+1
			robot[0][N-1] = false;
			conveyer[1][N-1]--;
			if(conveyer[1][N-1] == 0) cnt++;
		}
		
		
		for(int i = N-1; i >= 1; i--) { // 윗줄이동
			if(conveyer[0][i] >= 1 && robot[0][i] == false && robot[0][i-1] == true) {
				robot[0][i] = true;
				robot[0][i-1] = false;
				conveyer[0][i]--;
				if(conveyer[0][i] == 0) cnt++;
			}
		}
		
		robot[0][0] = false;
		
		// 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		//&& robot[0][0] == false
		if(conveyer[0][0] >= 1) {
			robot[0][0] = true;
			conveyer[0][0]--;
			if(conveyer[0][0] == 0) cnt++;
		}
		
		System.out.println("--------------------");
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(conveyer[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println(cnt);
		
		// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		if(cnt >= K) {
			return; 
		} else {
			Cycle();
		}
	}
	
	
}

 */

