package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B13904G {

	static class Infor implements Comparable<Infor>
	{
		int deadline;
		int score;
		
		public Infor(int deadline, int score) {
			super();
			this.deadline = deadline;
			this.score = score;
		}

		@Override
		public int compareTo(Infor o) {
			if(this.score == o.score) return this.deadline - o.deadline;
			else return o.score - this.score;
		}
	}
	
	static List<Infor> list = new ArrayList<>();
	static int ret[] = new int[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Infor(d, w));
		}
		Collections.sort(list);
		
		for(int i = 0; i < n; i++)
		{
			int d = list.get(i).deadline;
			int w = list.get(i).score;
			if(ret[d] == 0)
				ret[d] = w;
			else
			{
				int k = d;
				while(k > 0)
				{
					if(ret[k] == 0)
					{
						ret[k] = w;
						break;
					}
					else if(ret[k] < w)
					{
						ret[k] = w;
						break;
					}
					k--;
				}
			}
		}
		
		int sum = 0;
		for(int i = 1; i <= 1000; i++)
			sum += ret[i];
		System.out.println(sum);
	}
}
