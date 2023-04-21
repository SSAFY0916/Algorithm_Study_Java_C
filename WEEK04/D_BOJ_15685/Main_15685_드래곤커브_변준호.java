import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브_변준호{
/*
 * 0 x증가
 * 1 y증가
 * 2 x감소
 * 3 y감소 
 * 
 * 0세대 
 * 0 
 * 1세대 
 * 0    ->    1
 * 2세대
 * 0, 1  -> 2, 1
 * 3세대 
 * 0, 1, 2 ,1 -> 2,3,2,1
 * 어레이 리스트? 스택?
 */
	static int dy[] = {0,-1,0,1};
	static int dx[] = {1,0,-1,0};
	static boolean arr[][] = new boolean[101][101];
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragon(x,y,d,g);
			
		}
		int result = checkDragon();
		
		System.out.println(result);
		
	}
	private static int checkDragon() {
		// TODO Auto-generated method stub
		int result = 0;
		for(int i=0;i<100;i++) {
			for(int k=0;k<100;k++) {
				if(arr[i][k]&&arr[i+1][k]&&arr[i+1][k+1]&&arr[i][k+1]) {
					result++;
				}
			}
		}
		return result;
	}
	private static void dragon(int x, int y, int d, int g) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(d); //0세대 
		
		for(int i=0;i<g;i++) { //세대까지
			int size = list.size()-1;
			for(int k=size;k>=0;k--) {
				int newD = (list.get(k)+1)%4;
				list.add(newD);
			}
		}
		//그림그리기
		int cy = y;
		int cx = x;
		arr[cy][cx] = true;
		for(int i=0;i<list.size();i++) {
			cy = cy+dy[list.get(i)];
			cx = cx+dx[list.get(i)];
			arr[cy][cx] = true; 
		}

	}
}

//for(int i=0;i<20;i++) {
//	for(int k=0;k<20;k++) {
//	System.out.print(arr[i][k]+" ");
//}
//System.out.println();
//}
//System.out.println();