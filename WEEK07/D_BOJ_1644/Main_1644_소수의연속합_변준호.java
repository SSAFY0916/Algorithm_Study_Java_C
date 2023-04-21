import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_1644_소수의연속합_변준호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a==1) {
			System.out.println(0);
			return;
		}
		//소수 구하기 
		boolean prime[] = new boolean[a+1];
		prime[0] = true;
		prime[1] = true;
		for(int i=2;i*i<=a;i++) {
			if(!prime[i]) {
				for(int k=i*i;k<=a;k+=i) {
					prime[k] = true;
				}
			}
		}
//		System.out.println(Arrays.toString(prime));
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=a;i++) {
			if(!prime[i]) list.add(i);
		}
		//연속된 소수의 합 
		int result = 0;
		int left = 0;
		int right = 0;
		int sum = list.get(left);
		while(left<list.size()||right<list.size()) {
			if(left==right) {
				sum = list.get(right);
			}
//			System.out.println(list.get(left)+" "+list.get(right)+" "+sum);

			if(sum<a) {
				right++;
				if(right==list.size()) {
					break;
				}
				sum = sum+list.get(right);
			}else if(sum>a) {
				sum = sum - list.get(left);
				if(left==list.size()) {
					break;
				}
				left++;
			}else if(sum==a) {
				result++;
				right++;
				if(right==list.size()) {
					break;
				}
				sum = sum + list.get(right);
			}
		}
		System.out.println(result);
	}
}