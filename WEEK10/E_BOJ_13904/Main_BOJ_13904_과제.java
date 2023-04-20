import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_13904_과제 {

	static int N, sum, lastDay;
	static List<Homework> list;

	static class Homework {
		int limit, point;

		public Homework(int limit, int point) {
			super();
			this.limit = limit;
			this.point = point;
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sum = 0;
		lastDay = Integer.MIN_VALUE;
		list = new ArrayList<Homework>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int limit = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			lastDay = Math.max(lastDay, limit);
			list.add(new Homework(limit, point));
		}
		
		Collections.sort(list,(o1,o2) -> o1.point-o2.point);
		
		loop :
		while(lastDay != 0) {			
			for(int i = list.size()-1; i >= 0; i--) {
				//System.out.println("last >>" + lastDay);
				if(list.get(i).limit >= lastDay) {
					//System.out.println("----");
					sum += list.get(i).point;
					//System.out.println(sum);
					list.remove(i);
					lastDay--;
					continue loop;
				}
			}
			lastDay--;
		}
		
		System.out.println(sum);

	}

}