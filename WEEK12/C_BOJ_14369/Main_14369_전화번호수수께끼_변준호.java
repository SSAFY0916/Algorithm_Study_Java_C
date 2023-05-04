import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_14369_전화번호수수께끼_변준호 {
	/* ZERO ONE TWO TRHEE FOUR FIVE SIX SEVENE EIGHT NINE TEN	
	 *    	 
	 * Z -> 0
	 * X -> 6
	 * 
	 * */
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[26];
		StringBuilder sb = new StringBuilder();

		for(int test=1;test<=N;test++) {
			String str = br.readLine();
			for(int i=0;i<str.length();i++) {
				arr[str.charAt(i)-'A']++;
			}
			List<Integer> list = new ArrayList<>();
			while(arr['Z'-'A']!=0) { //0
				list.add(0);
				arr['Z'-'A']--;
				arr['E'-'A']--;
				arr['R'-'A']--;
				arr['O'-'A']--;
			}
			while(arr['W'-'A']!=0) { // 2
				list.add(2);
				arr['T'-'A']--;
				arr['W'-'A']--;
				arr['O'-'A']--;
			}
			while(arr['U'-'A']!=0) { // 4
				list.add(4);
				arr['F'-'A']--;
				arr['O'-'A']--;
				arr['U'-'A']--;
				arr['R'-'A']--;
			}
			while(arr['O'-'A']!=0) { // 1
				list.add(1);
				arr['O'-'A']--;
				arr['N'-'A']--;
				arr['E'-'A']--;
			}
			while(arr['G'-'A']!=0) { // 8
				list.add(8);
				arr['E'-'A']--;
				arr['I'-'A']--;
				arr['G'-'A']--;
				arr['H'-'A']--;
				arr['T'-'A']--;
			}
			while(arr['X'-'A']!=0) { // 6
				list.add(6);
				arr['S'-'A']--;
				arr['I'-'A']--;
				arr['X'-'A']--;
			}
			while(arr['F'-'A']!=0) { // 5
				list.add(5);
				arr['F'-'A']--;
				arr['I'-'A']--;
				arr['V'-'A']--;
				arr['E'-'A']--;
			}
			while(arr['V'-'A']!=0) { // 7
				list.add(7);
				arr['S'-'A']--;
				arr['E'-'A']--;
				arr['V'-'A']--;
				arr['E'-'A']--;
				arr['N'-'A']--;
			}
			while(arr['I'-'A']!=0) { // 9
				list.add(9);
				arr['N'-'A']--;
				arr['I'-'A']--;
				arr['N'-'A']--;
				arr['E'-'A']--;
			}
			while(arr['R'-'A']!=0) { // 3
				list.add(3);
				arr['T'-'A']--;
				arr['H'-'A']--;
				arr['R'-'A']--;
				arr['E'-'A']--;
				arr['E'-'A']--;
			}
			Collections.sort(list);
			sb.append("Case #").append(test).append(": ");
			for(int i=0;i<list.size();i++) {
				sb.append(list.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
