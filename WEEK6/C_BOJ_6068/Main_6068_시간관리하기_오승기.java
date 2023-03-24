import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_6068_시간관리하기_오승기 {
	
	static int N,Ti,Si;
	static List<Time> timeTable;
	
	static class Time implements Comparable<Time>{
		int taken; // 소요시간
		int limit; // 한계시간
		
		public Time(int taken, int limit) {
			super();
			this.taken = taken;
			this.limit = limit;
		}

		@Override
		public int compareTo(Time o) {
			// TODO Auto-generated method stub
			return o.limit - this.limit;
		}
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		timeTable = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int taken = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			Time time = new Time(taken, limit);
			timeTable.add(time);
		}
		
		Collections.sort(timeTable);
		
		int standard = timeTable.get(0).limit; // 기준으로 잡을 시간
		int curtime = standard;
		
		for(int i = 0; i < N; i++) {
			curtime -= timeTable.get(i).taken;
			if(curtime < 0) { // 불가능
				System.out.println(-1);
				System.exit(0);
			}
			
			if(i+1 < N && curtime > timeTable.get(i+1).limit) {
				curtime = timeTable.get(i+1).limit;
			//} else if(i+1 >= N && curtime > timeTable.get(i+1).limit)
			}
		}
		
		System.out.println(curtime);

	}

}
