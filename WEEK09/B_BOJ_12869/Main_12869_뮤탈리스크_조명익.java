import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] units = new int[3];
        for (int i = 0; i < n; i++) {
            units[i] = read();
        }

        int result = 0;
        final int[] attacks = {9, 3, 1};

        boolean[][][] visited = new boolean[61][61][61];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{units[0], units[1], units[2], 0});
        visited[units[0]][units[1]][units[2]] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            if (pos[0] < 1 && pos[1] < 1 && pos[2] < 1) {
                result = pos[3];
                break;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j != i) {
                        for (int k = 0; k < 3; k++) {
                            if (k != i && k != j) {
                                int nx = pos[0] - attacks[i];
                                if (nx < 0) nx = 0;
                                int ny = pos[1] - attacks[j];
                                if (ny < 0) ny = 0;
                                int nz = pos[2] - attacks[k];
                                if (nz < 0) nz = 0;
                                if (!visited[nx][ny][nz]) {
                                    visited[nx][ny][nz] = true;
                                    queue.add(new int[]{nx, ny, nz, pos[3] + 1});
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() - 48;
        while ((c = System.in.read()) > 32) n = 10 * n + c - 48;
        return n;
    }
}
