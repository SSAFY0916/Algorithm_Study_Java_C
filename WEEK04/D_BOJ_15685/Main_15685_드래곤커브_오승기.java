package solved;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_15685_드래곤커브 {

	/*
	 * n세대 선분 수 -> 2^n
	 * 
	 * 우 / 우 상 / 우상 좌상 / 우상좌상 좌하좌상 -> 우상좌상 상(90도)좌(90도)상(90도)우(90도)
	 * 
	 * 90도 기준 우 -> 상 / 상 -> 좌 / 좌 -> 하 / 하 -> 우 
	 * 0: x좌표가 증가하는 방향 (→) 1: y좌표가 감소하는 방향 (↑) 
	 * 2: x좌표가 감소하는 방향 (←) 3: y좌표가 증가하는 방향 (↓)
	 */

	static int N, x, y, d, g;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] map;
	static List<Integer> dList;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 드래곤커브 개수
		map = new boolean[101][101]; // 초기화

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // 시작점 x좌표
			y = Integer.parseInt(st.nextToken()); // 시작점 y좌표
			d = Integer.parseInt(st.nextToken()); // 시작방향
			g = Integer.parseInt(st.nextToken()); // 세대
			
			
			map[y][x] = true; // 시작점 설정
			dList = new ArrayList<Integer>();
			dList.add(d); // 방향순서 저장용
			
			for(int a = 0; a < g; a++) {
				for(int b = dList.size()-1; b >= 0; b--) {
					dList.add( (dList.get(b)+1)%4 );
				}
			}
			
			
			for(int a = 0; a < dList.size(); a++) { // 점 찍어주기
				x = x + dx[dList.get(a)]; 
				y = y + dy[dList.get(a)];
				map[y][x] = true;
			}
			
		}
		
		// 모든 점 찍었으면 사각형 수 세기
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
