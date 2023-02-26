import java.util.Scanner;

public class Main{
	static int arr[];
	static int sahic[];
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] agrs){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		sahic = new int[4];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<4;i++) {
			sahic[i] = sc.nextInt();
		}
		back(1,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void back(int def, int sum) {
		// TODO Auto-generated method stub
		if(def ==N) {
			//비교 
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			if(sahic[i]>0) {
				sahic[i]--;
				if(i==0) {
					back(def+1,sum+arr[def]);
				}
				else if(i==1) {
					back(def+1,sum-arr[def]);
				}else if(i==2) {
					back(def+1,sum*arr[def]);
				}else {
					back(def+1,sum/arr[def]);
				}
				sahic[i]++;
			}
		}
	}
}