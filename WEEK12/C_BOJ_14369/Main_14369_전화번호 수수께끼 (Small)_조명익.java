import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            result.append("Case #").append(testCase).append(": ");

            List<Integer> list = new ArrayList<>();

            StringBuilder s = new StringBuilder(br.readLine());

            // 1. zero 필터
            int idx;
            while ((idx = find(s, 'Z')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'E');
                delete(s, 'R');
                delete(s, 'O');
                list.add(0);
            }

            // 2. two 필터
            while ((idx = find(s, 'W')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'T');
                delete(s, 'O');
                list.add(2);
            }

            // 3. four 필터
            while ((idx = find(s, 'U')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'F');
                delete(s, 'O');
                delete(s, 'R');
                list.add(4);
            }

            // 4. six 필터
            while ((idx = find(s, 'X')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'S');
                delete(s, 'I');
                list.add(6);
            }

            // 5. eight 필터
            while ((idx = find(s, 'G')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'E');
                delete(s, 'I');
                delete(s, 'H');
                delete(s, 'T');
                list.add(8);
            }

            // 6. five 필터
            while ((idx = find(s, 'F')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'I');
                delete(s, 'V');
                delete(s, 'E');
                list.add(5);
            }

            // 7. seven 필터
            while ((idx = find(s, 'V')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'S');
                delete(s, 'E');
                delete(s, 'E');
                delete(s, 'N');
                list.add(7);
            }

            // 8. one 필터
            while ((idx = find(s, 'O')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'N');
                delete(s, 'E');
                list.add(1);
            }

            // 9. three 필터
            while ((idx = find(s, 'T')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'H');
                delete(s, 'R');
                delete(s, 'E');
                delete(s, 'E');
                list.add(3);
            }

            // 10. nine 필터
            while ((idx = find(s, 'N')) != -1) {
                s.deleteCharAt(idx);
                delete(s, 'I');
                delete(s, 'N');
                delete(s, 'E');
                list.add(9);
            }

            Collections.sort(list);

            for (Integer c : list) {
                result.append(c);
            }

            result.append('\n');
        }

        System.out.println(result);
    }

    private static void delete(StringBuilder result, char c) {
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == c) {
                result.deleteCharAt(i);
                break;
            }
        }
    }

    private static int find(StringBuilder result, char c) {
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == c) {
                return i;
            }
        }

        return -1;
    }
}
