import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로_변준호{
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		//가로
		int result = 0;
		for(int i=0;i<N;i++) {
			boolean flag = true;

			int pp = 1;  //평지의 개수
			int pd = 0;  //평지의 개수(내려갔을떄)
			int len = arr[i][0];
			for(int k=1;k<N;k++) {				
				if(len==arr[i][k]) { //평지일때
					pp++;
					if(pd>0) {
						pd++; //내려가고 난 이후상황일때
					}
				}
				else if(len+1==arr[i][k]) { //올라가기
					if(pd>0&&pd<C) { //내려갓다 올라온 경우
						flag = false;
					}
					else if(pd>0&&pd>=C) { //위의 조건 충족
						if(pd<2*C) {
							flag = false; //올라갈때의 조건 충족안함 
						}
						else {
							pd = 0;
							len  = arr[i][k];
						}
					}
					else if(pp>=C) { //올라갓다 올라온 경우
						pp=1;
						len = arr[i][k];
					}else {
						flag = false;
					}
				}else if(len-1==arr[i][k]) { //내려가기
					//올라갓다 내려운 경우는 생각 X
					if(pd>0&&pd<C) { //내려갓다가 또내려갓는데 조건 충족 X
						flag = false;
					}
					else if(pd>0&&pd>=C) { //조건 충족 O
						len = arr[i][k];
						pd = 1;
						pp = 0;
					}
					else {  //평지였다가 내려간 경우
						pd++;
						len = arr[i][k];
					}
				}else { //두세칸 씩 점프
					flag = false;
				}
				
			}
			if(pd>0&&pd<C) {
				flag = false;
			}
			if(flag) {
//				System.out.println("가로"+i);
				result++;
			}
		}
		
		////////////
		for(int i=0;i<N;i++) {
			boolean flag = true;
			int up = 0;
			int down = 0;
			int pp = 1;
			int pd = 0;
			int len = arr[0][i];
			for(int k=1;k<N;k++) {				
				if(len==arr[k][i]) {
					pp++;
					if(pd>0) {
						pd++;
					}
				}
				else if(len+1==arr[k][i]) { //올라가기
					if(pd>0&&pd<C) {
						flag = false;
					}
					else if(pd>0&&pd>=C) {
						if(pd<2*C) {
							flag = false;
						}
						else {
							pd = 0;
							len  = arr[k][i];
						}
					}
					else if(pp>=C) {
						pp=1;
						len = arr[k][i];
					}else {
						flag = false;
					}
				}else if(len-1==arr[k][i]) { //내려가기
					if(pd>0&&pd<C) {
						flag = false;
					}
					else if(pd>0&&pd>=C) {
						len = arr[k][i];
						pd = 1;
						pp = 0;
					}
					else {
						pd++;
						len = arr[k][i];
					}
				}else {
					flag = false;
				}
				
			}
			if(pd>0&&pd<C) {
				flag = false;
			}
			if(flag) {
//				System.out.println("세로"+i);
				result++;
			}
		}
		System.out.println(result);
	}
}

/*

*/


