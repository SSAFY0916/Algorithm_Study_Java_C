import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_5430_AC_오승기 {
	
	static int T,n;
	static String p,sArr;
	static ArrayDeque<Integer> ad;
	static List<Integer> list;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		loop :
		for(int tc = 1; tc <= T; tc++) {
			p = br.readLine();
			n = Integer.parseInt(br.readLine());
			sArr = br.readLine(); // 배열 String 입력
			ad = new ArrayDeque<>();
			list = new ArrayList<>();
			flag = true; // true->앞 / false->뒤
			
			st = new StringTokenizer(sArr,"[|,|]");
			
			for(int i = 0; i < n; i++) {
				ad.add(Integer.parseInt(st.nextToken()));
			}
			
			// AC연산을 위한 로직
			for(int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'R') {
					flag = !flag;
				} else { // D
					if(ad.isEmpty()) {
						sb.append("error\n");
						continue loop;
					} else if(flag) { // true일때
						ad.pollFirst();
					} else if(!flag) { // false일때
						ad.pollLast();
					}
				}
			}
			
			// AC연산이 끝나고 큐에 남은 값을 플래그에 따라 방향을 정해 리스트에 담는다
			// 리스트에 담는 이유 : list.toString()을 했을때 모먕이 출력에서 요구하는 모양과 비슷하다 생각
			// 따라서 list.toString() 후에 공백만 제거해주면 편하겠다는 생각이 들었다
			if(flag) { // true일때
				while(!ad.isEmpty()) {
					list.add(ad.pollFirst());
				}
			} else { // false일때
				while(!ad.isEmpty()) {
					list.add(ad.pollLast());
				}
			}
			
			sb.append(list.toString().replaceAll(" ", "")).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}
