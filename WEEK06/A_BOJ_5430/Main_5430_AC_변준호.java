import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_5430_AC_변준호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test=0;test<N;test++) {
			int flag = 1; // 1 -> 앞에서 빼기 0 -> 뒤에서 빼기
			boolean zero = true;
			String cmd = br.readLine();
			int num = Integer.parseInt(br.readLine());
			String array = br.readLine();
			array = array.substring(1, array.length()-1);
			String[] arr = array.split(",");
			Deque<Integer> dq = new LinkedList<>();
			//dq에 저장 
			for(int i=0;i<num;i++) {
				dq.add(Integer.parseInt(arr[i]));
			}
			//연산 시작 
			for(int i=0;i<cmd.length();i++) {
				if(cmd.charAt(i)=='R') {
					flag = (flag+1)%2;
				}
				else {
					if(dq.size()==0) {
						sb.append("error");
						zero = false;
						break;
					}
					if(flag==1) {
						dq.removeFirst();
					}else {
						dq.removeLast();
					}
				}
			}
			int size = dq.size();
			if(zero) {
				sb.append("[");
				if(flag==1) {
					for(int i=0;i<size-1;i++) {
						sb.append(dq.removeFirst()).append(",");
					}
					if(dq.size()>0) {
						sb.append(dq.removeFirst()).append("]");
					}
					else {
						sb.append("]");
					}
				}else {
					for(int i=0;i<size-1;i++) {
						sb.append(dq.removeLast()).append(",");
					}
					if(dq.size()>0) {
						sb.append(dq.removeLast()).append("]");
					}
					else {
						sb.append("]");
					}
				}
				
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
