public class Main {

    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = read();
        }

        int[] operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = read();
        }

        backTrack(numbers, operators, n - 1, 0, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void backTrack(int[] numbers, int[] operators, int last, int depth, int sum) {
        if (depth == last) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                int temp;
                if (i == 0) {
                    temp = sum + numbers[depth + 1];
                } else if (i == 1) {
                    temp = sum - numbers[depth + 1];
                } else if (i == 2) {
                    temp = sum * numbers[depth + 1];
                } else {
                    temp = sum / numbers[depth + 1];
                }

                backTrack(numbers, operators, last, depth + 1, temp);
                operators[i]++;
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) n = 10 * n + c - 48;
        return n;
    }
}
