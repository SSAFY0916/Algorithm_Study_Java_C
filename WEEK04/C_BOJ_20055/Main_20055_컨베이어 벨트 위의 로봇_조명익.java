import java.io.*;
import java.util.*;

class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int length = 2 * n;
        boolean[] robots = new boolean[n];
        int[] belt = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 1;
        while (true) {
            rotate(robots, belt);
            moveRobot(robots, belt);
            putRobot(robots, belt);
            if (count >= k) break;
            step++;
        }

        System.out.println(step);
    }

    private static void rotate(boolean[] robots, int[] belt) {
        int temp = belt[belt.length - 1];
        for (int i = belt.length - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = temp;

        for (int i = robots.length - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }
        robots[0] = false;
    }

    private static void moveRobot(boolean[] robots, int[] belt) {
        if (robots[robots.length - 1]) {
            robots[robots.length - 1] = false;
        }

        for (int i = robots.length - 2; i > -1; i--) {
            if (robots[i]) {
                if (!robots[i + 1] && belt[i + 1] > 0) {
                    robots[i] = false;
                    robots[i + 1] = true;
                    belt[i + 1]--;
                    if (belt[i + 1] == 0) {
                        count++;
                    }
                }
            }
        }
    }

    private static void putRobot(boolean[] robots, int[] belt) {
        if (!robots[0] && belt[0] > 0) {
            robots[0] = true;
            belt[0]--;
            if (belt[0] == 0) {
                count++;
            }
        }
    }
}
