import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()),
            k = Integer.parseInt(st.nextToken());

        int[][] nourishment = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(nourishment[i], 5);
        }

        int[][] addNourishment = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                addNourishment[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Integer>[][] trees = new PriorityQueue[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                trees[i][j] = new PriorityQueue<>();
            }
        }

        for (int treeNumber = 1; treeNumber <= m; treeNumber++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()),
                age = Integer.parseInt(st.nextToken());

            trees[x][y].add(age);
        }

        while (k-- > 0) {
            springAndSummer(trees, n, nourishment);
            fall(trees, n);
            winter(nourishment, addNourishment, n);
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result += trees[i][j].size();
            }
        }

        System.out.println(result);
    }

    private static void springAndSummer(PriorityQueue<Integer>[][] trees, int n, int[][] nourishment) {
        List<Integer> live = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int tempNourishment = 0;
                while (!trees[i][j].isEmpty()) {
                    int age = trees[i][j].poll();
                    if (age <= nourishment[i][j]) {
                        nourishment[i][j] -= age;
                        age++;
                        live.add(age);
                    } else {
                        tempNourishment += age / 2;
                    }
                }

                nourishment[i][j] += tempNourishment;

                for (int k = live.size() - 1; k > -1; k--) {
                    trees[i][j].add(live.get(k));
                    live.remove(k);
                }
            }
        }
    }

    private static void fall(PriorityQueue<Integer>[][] trees, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Integer age : trees[i][j]) {
                    if (age % 5 == 0) {

                        int nx, ny;
                        for (int k = 0; k < 8; k++) {
                            nx = i + dx[k];
                            ny = j + dy[k];

                            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                                continue;
                            }

                            trees[nx][ny].add(1);
                        }
                    }
                }
            }
        }
    }

    private static void winter(int[][] nourishment, int[][] addNourishment, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nourishment[i][j] += addNourishment[i][j];
            }
        }
    }
}
