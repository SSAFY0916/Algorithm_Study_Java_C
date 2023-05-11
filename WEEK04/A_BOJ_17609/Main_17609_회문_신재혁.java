import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17609_회문_신재혁 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            sb.append(isPalindrome(str,false)).append('\n');
        }
        System.out.print(sb);
    }
    public static int isPalindrome(String str, boolean depth){
        char front;
        char back;
        int offset = 0;
        int len = str.length();
//        System.out.println("STR: "+str);
        for(int j = 0; j <= len/2; j++){
            front = str.charAt(j);
            back = str.charAt(len-1-j);
            if(front != back){
                if(!depth){
//                    System.out.println("front= "+front+" back= "+back);
                    if(isPalindrome(str.substring(j+1,len-j),true) == 0 || isPalindrome(str.substring(j,len-1-j),true) == 0){
//                        System.out.println("ACCEPT: 1");
                        return 1;
                    }else {
//                        System.out.println("REJECT: 2");
                        return 2;
                    }
                }else{
                    return 2;
                }
            }
        }
//        if(!depth)
//            System.out.println("ACCEPT: 0");
        return 0;
    }
}
