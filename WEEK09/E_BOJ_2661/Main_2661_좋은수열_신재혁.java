import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2661_좋은수열_신재혁 {
    static int N;
    static int[] ans;
    static int[] finalPos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        makeArr(new int[N], 0, new int[3]);
        for(int i = 0; i < N; i++)
            sb.append(ans[i]);
        System.out.println(sb);
    }
    static void makeArr(int[] arr, int count, int lastPos[]){
        if(count == N){
            if(ans == null) {
//                System.out.println("yay");
                ans = new int[N];
                for(int i = 0; i < N; i++){
                    ans[i] = arr[i];
                }
            }
            if(finalPos == null){
                finalPos = new int[3];
                for(int i = 0; i < 3; i++){
                    finalPos[i] = lastPos[i];
                }
            }
            return;
        }
        for(int i = 1; i <= 3; i++){
            if(ans != null) return;

            int lastPosPre = lastPos[i-1];
            lastPos[i-1] = count;

            arr[count] = i;
            boolean reject = false;
            for(int j = 1; j <= (count+1)/2; j++)
                if(matches(arr,count-j,count))
                    reject = true;
            if(reject)
                continue;
            makeArr(arr, count+1, lastPos);
            lastPos[i-1] = lastPosPre;
//            int endIndex = lastPos[i-1]; // 마지막으로 j가 있었던 자리
////            System.out.println(arr[count]+" "+count+" "+endIndex);
////            System.out.println(Arrays.toString(arr));
//            boolean reject = true;
//            if(endIndex == count)
//                reject = false;
//            for(int offset = 0; reject && count-offset > endIndex; offset++){
//                if(endIndex-offset < 0)
//                    reject = false;
//                else if(arr[count-offset] != arr[endIndex-offset]){
//                    reject = false;
//                }
//            }
//            if(reject){
//                continue;
//            }
        }
    }
    static boolean matches(int[] arr, int start, int end){
        if(start < 0)
            return false;
        for(int i = 0; i < end - start; i++)
            if(arr[start-i] != arr[end-i])
                return false;
        return true;
    }
}