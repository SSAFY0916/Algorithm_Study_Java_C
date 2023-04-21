import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        backTrack(0, n, stack, result);
    }

    private static void backTrack(int depth, int n, Stack<Integer> stack, StringBuilder result) {
        if (depth == n) {
            System.out.println(result);
            System.exit(0);
            return;
        }

        Loop:
        for (int number = 1; number < 4; number++) {
            // 1 자리 수 검증
            if (!stack.isEmpty() && stack.peek() == number) {
                continue;
            }

            stack.add(number);

            // 2 이상 자리 수 검증
            int last = stack.size() - 1;
            for (int k = 2; k <= stack.size() / 2; k++) {
                boolean flag = true;
                for (int j = 0; j < k; j++) {
                    if (stack.get(last - j) != stack.get(last - k - j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    stack.pop();
                    continue Loop;
                }
            }

            result.append(number);
            backTrack(depth + 1, n, stack, result);
            stack.pop();
            result.deleteCharAt(result.length() - 1);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) {
            n = 10 * n + c - 48;
        }
        return n;
    }
}
