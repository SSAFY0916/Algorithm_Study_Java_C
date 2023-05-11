import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2879_코딩은예쁘게_변준호 {
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		// 배열 하나로 관리 
		for(int i=0;i<N;i++) {
			arr[i] = arr[i] - Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for(int i=0;i<N;i++) {
			if(arr[i]==0) continue; // 0일때는 인덴트 맞춰져있는 상태
			if(arr[i]>0) { // 양수일 때 
				int tmp = arr[i];
				result = result+arr[i];
				arr[i] = 0;
				for(int k=i+1;k<N;k++) {
					if(arr[k]>=tmp) {
						arr[k] = arr[k] -tmp;
					}else if(arr[k]>0) {
						tmp = arr[k];
						arr[k] = 0;
					}else {
						break;
					}
				}
			}else {// 음수일 때 
				int tmp = arr[i];
				arr[i] = 0;
				result = result-tmp;
				for(int k=i+1;k<N;k++) {
					if(arr[k]<=tmp) {
						arr[k] = arr[k] - tmp;
					}else if(arr[k]<0) {
						tmp = arr[k];
						arr[k] = 0;
					}else {
						break;
					}
				}
			}
		}
		System.out.println(result);
		
	}
}
