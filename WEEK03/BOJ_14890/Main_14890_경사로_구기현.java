
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    /**
     * map : N*N
     * 각 칸 : 그곳의 높이
     * result : 지나갈 수 있는 길의 개수 (길 : 한 행/열 전부를 한쪽 끝에서 다른 쪽 끝까지 가는 것)
     * 지나갈 수 있는 길의 조건 : 길의 모든 높이가 모두 같아야 함 / 이 때 경사로를 놓아도 됨
     * 경사로 : 높이 1, 길이 L
     *
     * 행/열 체크
     * 오르막 내리막 체크
     * 높이차 1인지
     * 같은 위치 경사로 두번 놓일 수 없음
     *
     */

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            if (isPossible(i, 0, true)) cnt++; // 행
            if (isPossible(0, i, false)) cnt++; // 열
        }

        System.out.println(cnt);

    }

    // flag ? 행 : 열
    static boolean isPossible(int row, int col, boolean flag) {
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; ++i) {
            if (flag == true) height[i] = map[row][i]; // 행
            else height[i] = map[i][col]; // 열
        }

        for (int i = 0; i < N-1; ++i) {
            if (height[i] == height[i+1]) continue; // 높이 같을 때
                // 내리막길
            else if (height[i] == height[i+1] +1) {
                for (int j = i + 1; j <= i + L; ++j) {
                    if (j>=N || height[i+1] != height[j] || visited[j]) return false;
                    visited[j] = true; // 조건에 부합하면 경사로 처리
                }
            }
            // 오르막길
            else if (height[i] == height[i+1] -1) {
                for (int j = i; j > i - L; --j) {
                    if (j<0 || height[i] != height[j] || visited[j]) return false;
                    visited[j] = true; // 조건에 부합하면 경사로 처리
                }
            }
            else return false; // 높이 차가 1이 아닐 경우
        }

        return true;
    }

}

