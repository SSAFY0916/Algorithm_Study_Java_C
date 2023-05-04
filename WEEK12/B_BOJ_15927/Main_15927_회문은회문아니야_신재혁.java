import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15927_회문은회문아니야_신재혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer();
        String str = br.readLine();
        System.out.println(tryPalindromes(str));
    }
    public static int tryPalindromes(String str){
        int len = str.length();
        if(len == 0)
            return -1;
        if(!isPalindrome(str))
            return len;
        if(!isPalindrome(str.substring(1)) || !isPalindrome(str.substring(0,len-1)))
            return len-1;
        return -1;
    }
    public static boolean isPalindrome(String str){
        int len = str.length();
        for(int i = 0; i < len / 2; i++){
            if(str.charAt(i) != str.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}
