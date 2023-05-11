package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15685 {

    static boolean[][] map = new boolean[101][101];
    // 우 상 좌 하
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int x, y, d, g;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()); // 시작 방향
            g = Integer.parseInt(st.nextToken()); // 세대
            dragonCurve(x, y, d, g);
        }

        int answer = 0;
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 100; ++j) {
                if (map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> dirList = new ArrayList<>();
        dirList.add(d);

        for (int i = 0; i < g; ++i) {
            for (int j = dirList.size()-1; j >=0 ; --j) {
                dirList.add((dirList.get(j)+1)%4);
            }
        }

        map[y][x] = true;
        for (int dir : dirList) {
            y += dy[dir];
            x += dx[dir];
            map[y][x] = true;
        }
    }


}