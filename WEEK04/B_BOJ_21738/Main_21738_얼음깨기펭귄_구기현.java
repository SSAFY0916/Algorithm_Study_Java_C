package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 얼음깨기 보드게임을 모르는 나는 문제를 읽다가 화가 났었다.
 * 답 : 펭귄의 위치에서 지지대까지 연결된 얼음 수가 최소인 경우
 * ex) 1 - 펭귄 - 3 경로의 얼음 빼고 다깨면 펭귄 안떨어짐 그 중 경로가 최소인 경우
 *
 * 펭귄에서부터 bfs 돌리면서 각 지지대 얼음까지의 거리 구하고 정렬 -> 2개 뽑아서 얼음 개수에서 뺴기
 */
public class B21738 {

    static int N, S, P;
    static ArrayList<Integer>[] adjList;
    static int[] distance;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 얼음 개수
        S = Integer.parseInt(st.nextToken()); // 1~S번 까지 지지대 얼음
        P = Integer.parseInt(st.nextToken()); // 펭귄 위치

        // 무향 그래프
        adjList = new ArrayList[N+1]; // 인접 리스트
        for (int i = 1; i <= N; ++i) {
            adjList[i] = new ArrayList<>();
        }
        distance = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        } // 입력 완료

        bfs();

        // 지지대 얼음 배열 따로 뽑아서 정렬 후 정답 찾기
        int[] result = Arrays.copyOfRange(distance, 1, S+1);
        Arrays.sort(result);
        System.out.println(N - (result[0] + result[1]) - 1); // 1은 펭귄 위치
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(P);
        visited[P] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 0; i < adjList[curr].size(); ++i) {
                int next = adjList[curr].get(i);
                if (visited[next]) continue;

                distance[next] = distance[curr]+1;
                visited[next] = true;
                queue.offer(next);
            }

        }

    }


}