
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H, answer;
    static int[][] map;
    static boolean flag;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken()); // 가로
        // 0 : 아래로  1 : 오른쪽으로   2 : 왼쪽으로
        map = new int[H+1][N+1];

        int a, b;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[a][b+1] = 2;
        }

        for (int i = 0; i <= 3; ++i) {
            if (flag == true) continue;
            dfs(1, 0, i);
        }

        if (flag == true) System.out.println(answer);
        else System.out.println(-1);


    }

    static void dfs(int height, int lineCnt, int totalLine) {

        // 이미 답 나왔을 경우 종료 (답은 최소값)
        if (flag == true) return ;

        // 0~3개일 때 체크
        if (lineCnt == totalLine) {
            if (check()) {
                flag = true;
                answer = totalLine;
            }
            return ;
        }

        // 높이(각 가로선)
        for (int i = height; i <= H; ++i) {
            // 각 세로선 사이
            for (int j = 1; j < N; ++j) {
                // 연속된 가로선이 없을 경우만
                if (map[i][j] == 0 && map[i][j+1] == 0) {
                    // 가로선 놓기
                    map[i][j] = 1;
                    map[i][j+1] = 2;

                    // 가로선 놓고 재귀
                    dfs(i, lineCnt+1, totalLine);

                    // 가로선 제거
                    map[i][j] = map[i][j+1] = 0;
                }
            }
        }


    }

    static boolean check() {
        for (int i = 1; i <= N; ++i) {
            int startCol = i; // 열
            // 사다리 태우기
            for (int j = 1; j <= H; ++j) {
                if (map[j][startCol] == 1) startCol += 1;
                else if (map[j][startCol] == 2) startCol -= 1;
            }
            if (i != startCol) return false;
        }
        return true;
    }

}

