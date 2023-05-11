package Algorithm_Study_Java2.WEEK6.C_BOJ_6068;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_6068_시간관리하기_신재혁 {
	public static StringBuilder sb;
	public static Task[] tasks;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		tasks = new Task[N];
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(tasks);
		int minTime = Integer.MAX_VALUE;
		int timeSum = 0;
		for(Task t : tasks){
			timeSum += t.time;
			minTime = Math.min(minTime, t.endUntil-timeSum);
			if(minTime < 0){
				minTime = -1;
				break;
			}
//            System.out.println(minTime);
		}

		System.out.println(minTime);
	}
	static class Task implements Comparable<Task> {
		int time;
		int endUntil;

		public Task(int time, int endUntil) {
			this.time = time;
			this.endUntil = endUntil;
		}

		@Override
		public int compareTo(Task o) {
			return Integer.compare(endUntil,o.endUntil);
		}

		@Override
		public String toString() {
			return "Task{" +
					"time=" + time +
					", endUntil=" + endUntil +
					'}';
		}
	}
}