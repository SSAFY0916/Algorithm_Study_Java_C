import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int testCase = 0; testCase < t; testCase++) {
            String s = br.readLine();
            int idx = checkPalindrome(s);
            if (idx == -1) {
                result.append(0);
            } else {
                String s1 = s.substring(0, idx) + s.substring(idx + 1);
                if (checkPalindrome(s1) == -1) {
                    result.append(1);
                } else {
                    String s2 = s.substring(0, s.length() - 1 - idx) + s.substring(s.length() - idx);
                    if (checkPalindrome(s2) == -1) {
                        result.append(1);
                    } else {
                        result.append(2);
                    }
                }
            }

            result.append('\n');
        }

        System.out.println(result);
    }

    private static int checkPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return i; // 팰린드롬이 아닌 경우 아닌 위치 인덱스 반환
            }
        }

        return -1; // 팰린드롬인 경우
    }
}
