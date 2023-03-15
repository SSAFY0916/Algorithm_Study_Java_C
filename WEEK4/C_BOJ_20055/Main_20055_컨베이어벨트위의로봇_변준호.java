import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇_변준호 {
	/*
	 * 1----> 2N(하차)
	 * 1승차 내구도 감소 
	 * 
	 * 1. 벨트 회전
	 * 2. 로봇 이동
	 * 
	 */
	static int N,K;
	static int robot[];
	static int damage[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		robot = new int[2*N]; //로봇 이동 표현
		damage = new int[2*N]; // 내구도
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) {
			damage[i] = Integer.parseInt(st.nextToken());
		}
		boolean flag = true;
		int level = 0;
		while(flag) {
			level++;
			rotate();
//			System.out.println(Arrays.toString(robot));
//			System.out.println(Arrays.toString(damage));
//			System.out.println();

			moveRobot();
//			System.out.println(Arrays.toString(robot));
//			System.out.println(Arrays.toString(damage));
//			System.out.println();

			if(damage[0]>0) {
				robot[0] = 1;
				damage[0]--;
			}
//			System.out.println(Arrays.toString(robot));
//			System.out.println(Arrays.toString(damage));
//			System.out.println();
			flag = check();
			
		}
		System.out.println(level);
	}
	private static boolean check() {
		// TODO Auto-generated method stub
		int tmp = 0;
		for(int i=0;i<2*N;i++) {
			if(damage[i]==0) {
				tmp++;
			}
		}
		if(tmp>=K) {
			return false;
		}
		else {
			return true;
		}
	}
	private static void moveRobot() {
		// TODO Auto-generated method stub
		for(int i = N-2;i>=0;i--) {
			if(robot[i]>0) {
				if(robot[i+1]==0&&damage[i+1]>0) {
					damage[i+1]--;
					robot[i+1] = 1;
					robot[i] = 0;
				}
			}
		}
		robot[N-1] = 0;
	}
	private static void rotate() {
		// TODO Auto-generated method stub
		int tmp1 = robot[2*N-1];
		int tmp2 = damage[2*N-1];
		for(int i=2*N-2;i>=0;i--) {
			robot[i+1] = robot[i];
			damage[i+1] = damage[i];
		}
		robot[N-1] = 0;
		robot[0] = tmp1;
		damage[0] = tmp2;
	}

}
