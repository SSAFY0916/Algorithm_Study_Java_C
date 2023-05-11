import java.util.*;
class Solution_택배배달과수거하기_변준호 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        long result = 0;
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        for(int i=0;i<n;i++){
            if(deliveries[i]>0){
                for(int k=0;k<deliveries[i];k++){
                    s1.add(i+1);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(pickups[i]>0){
                for(int k=0;k<pickups[i];k++){
                    s2.add(i+1);
                }
            }
        }
        while(!s1.isEmpty()&&!s2.isEmpty()){
            int a = s1.peek();
            int b = s2.peek();
            for(int i=0;i<cap;i++){
                if(!s1.isEmpty()){
                    s1.pop();
                }
                if(!s2.isEmpty()){
                    s2.pop();
                }
            }
            result = result+ Math.max(a,b)*2;
        }
         while(!s1.isEmpty()){
            int a = s1.peek();
            for(int i=0;i<cap;i++){
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }
            result = result+ a*2;
        }
        while(!s2.isEmpty()){
            int a = s2.peek();
            for(int i=0;i<cap;i++){
                if(!s2.isEmpty()){
                    s2.pop();
                }
            }
            result = result+ a*2;
        }
        
        return result;
    }
}
