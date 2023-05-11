import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14719_빗물_오승기 {
	
	static int H,W,result = 0;
	static int[] hArr;
	static List<Integer> idxList;
	static boolean flag = true; // false -> 하강 / true -> 상승

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken()); // 세로
		W = Integer.parseInt(st.nextToken()); // 가로
		
		hArr = new int[W];
		idxList = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			hArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lastIdx = 0;
		for(int i = 0; i < W-1; i++) { // 계곡 구간 구하기
			if(flag) { // 상승구간
				if(hArr[i] <= hArr[i+1]) {
					lastIdx = i+1;
					continue;
				} else { // 하강으로 바뀌는 순간
					idxList.add(i);
					lastIdx = -1;
					flag = !flag;
				}
			} else { // 하강구간
				if(hArr[i] >= hArr[i+1]) {
					lastIdx = -1;
					continue;
				} else { // 상승으로 바뀌는 순간
					//idxList.add(i+1);
					lastIdx = i+1;
					flag = !flag;
				}
			}
		}
		if(lastIdx != -1) {
			idxList.add(lastIdx);
		}
		
		System.out.println(idxList.toString());
		
		if(idxList.size() < 2) { // 불가능 한 경우
			System.out.println(result);
			System.exit(0);
		}
		
		
		for(int i = 0; i < idxList.size();) {
			if(i+1 >= idxList.size()) {
				break;
			}
			
			int j = i+1;
			int start = idxList.get(i); 
			int end = idxList.get(j);
			while(true) {
				if (j+1 >= idxList.size()) {
					end = idxList.get(j);
					i = j;
					break;
				} else if(hArr[start] <= hArr[end]) {
					i = j;
					break;
				} else {
					end = idxList.get(++j);
				}
			}
			
			System.out.println("start >> " + start);
			System.out.println("end >> " + end);
			
			// 계곡 내에서 최대로 쌓일 수 있는 높이 구하기
			int maxH = hArr[start] >= hArr[end] ? 
					hArr[end]:hArr[start];
			
			System.out.println("maxH >> " + maxH);
			
			for(int a = start; a < end; a++) {
				if(hArr[a] < maxH) {
					result += maxH - hArr[a];
				}
			}
		}
		
		System.out.println(result);

		
	}

}

/*
 * 
 * 반례
 * 3 6
	5 4 1 3 1 2
*/
