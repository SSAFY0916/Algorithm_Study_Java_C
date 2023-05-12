import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) + 1, x = Integer.parseInt(st.nextToken()) + 1;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] positions = new int[n + 1][3];
        int[][] visited = new int[x][y];

        for (int robotNumber = 1; robotNumber <= n; robotNumber++) {
            st = new StringTokenizer(br.readLine());
            positions[robotNumber][1] = Integer.parseInt(st.nextToken());
            positions[robotNumber][0] = Integer.parseInt(st.nextToken());
            positions[robotNumber][2] = getDirection(st.nextToken());
            visited[positions[robotNumber][0]][positions[robotNumber][1]] = robotNumber;
        }

        final int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNumber = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int repeat = Integer.parseInt(st.nextToken());

            int sx = positions[robotNumber][0];
            int sy = positions[robotNumber][1];
            int sd = positions[robotNumber][2];

            if ("F".equals(command)) {
                visited[sx][sy] = 0;

                while (repeat-- > 0) {
                    sx += dx[sd];
                    sy += dy[sd];

                    if (sx < 1 || sx > x - 1 || sy < 1 || sy > y - 1) {
                        System.out.println("Robot " + robotNumber + " crashes into the wall");
                        return;
                    } else if (visited[sx][sy] > 0) {
                        System.out.println("Robot " + robotNumber + " crashes into robot " + visited[sx][sy]);
                        return;
                    }
                }

                visited[sx][sy] = robotNumber;
                positions[robotNumber][0] = sx;
                positions[robotNumber][1] = sy;
            } else {
                repeat %= 4;
                while (repeat-- > 0) {
                    sd = rotate(sd, command);
                }
                positions[robotNumber][2] = sd;
            }
        }

        System.out.println("OK");
    }

    private static int getDirection(String dire) {
        if ("N".equals(dire)) {
            return 0;
        } else if ("E".equals(dire)) {
            return 1;
        } else if ("S".equals(dire)) {
            return 2;
        } else {
            return 3;
        }
    }

    private static int rotate(int presentDirection, String dire) {
        if ("L".equals(dire)) {
            presentDirection--;
        } else {
            presentDirection++;
        }

        if (presentDirection > 3) {
            presentDirection = 0;
        } else if (presentDirection < 0) {
            presentDirection = 3;
        }

        return presentDirection;
    }
}
