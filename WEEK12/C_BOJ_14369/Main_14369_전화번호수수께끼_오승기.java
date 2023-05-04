import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14369_전화번호수수께끼_오승기 {
	
	static int[] alphabet;
	static int[] numberCnt;
	static String[] number= {"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
	static StringBuilder sb;
	static int TC;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(TC = 1; TC <= N; TC++) {
			alphabet = new int[26];
			numberCnt = new int[10];
			String str = br.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				alphabet[c-'A']++;
			}
			
			matching();
			flag = false;
			
		}
		
		System.out.println(sb.toString());
		
		

	}

	private static void matching() {
		// TODO Auto-generated method stub
		
		loop:
		for(int i = 0; i < 10; i++) {
			String temp = number[i];
			for(int j = 0; j < temp.length(); j++) {
				if( alphabet[(temp.charAt(j)-'A')] == 0 ) {
					continue loop;
				}
			}
			
			for(int j = 0; j < temp.length(); j++) {
				alphabet[(temp.charAt(j)-'A')]--;
			}
			numberCnt[i]++;
			
			if(useAll()) {
				print();
				flag = true;
//				System.out.println(sb.toString());
				return;
			}
			
			if(!flag) {
				matching();

				numberCnt[i]--;
				
				for(int j = 0; j < temp.length(); j++) {
					alphabet[(temp.charAt(j)-'A')]++;
				}
			}
			
		}
		
	}

	private static void print() {
		// TODO Auto-generated method stub
		sb.append("Case #"+TC+": ");
		
		for(int i = 0; i < 10; i++) {
			while(numberCnt[i] > 0) {
				sb.append(i);
				numberCnt[i]--;
			}
		}
		sb.append("\n");
	}

	private static boolean useAll() {
		// TODO Auto-generated method stub
		for(int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] != 0) {
				return false;
			}
		}
		
		return true;
	}

}