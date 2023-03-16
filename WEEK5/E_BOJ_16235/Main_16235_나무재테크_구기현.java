package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B16235 {

    static class Tree implements Comparable<Tree>{
        int row;
        int col;
        int age;

        public Tree(int row, int col, int age) {
            this.row = row;
            this.col = col;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
    static int N, M, K;
    static int answer;
    static int[][] nourishment;
    static int[][] supply;
    static PriorityQueue<Tree> pq = new PriorityQueue<>();

    // adjacent 칸
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nourishment = new int[N + 1][N + 1];
        supply = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                nourishment[i][j] = 5;
                supply[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            pq.offer(new Tree(row, col, age));
        } // 입력 완료

        int year = 0;
        while (year < K) {
            year++;
            springSummer();
            fall();
            winter();
        }

        System.out.println(pq.size());

    }

    private static void winter() {
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                nourishment[i][j]+= supply[i][j];
            }
        }
    }

    private static void fall() {
        PriorityQueue<Tree> tmpPq = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            Tree curr = pq.poll();

            if (curr.age % 5 == 0) {
                for (int i = 0; i < 8; ++i) {
                    int nr = curr.row + dr[i];
                    int nc = curr.col + dc[i];

                    if (nr < 1 || nc < 1 || nr > N || nc > N) {
                        continue;
                    }

                    tmpPq.offer(new Tree(nr, nc, 1));
                }
            }
            tmpPq.offer(curr);
        }
        pq = tmpPq;
    }

    private static void springSummer() {
        PriorityQueue<Tree> tmpPq = new PriorityQueue<>();
        List<Tree> deadTrees = new ArrayList<>();

        while (!pq.isEmpty()) {
            Tree curr = pq.poll();
            if (nourishment[curr.row][curr.col] >= curr.age) {
                nourishment[curr.row][curr.col] -= curr.age;
                tmpPq.offer(new Tree(curr.row, curr.col, curr.age + 1));
            } else {
                deadTrees.add(curr);
            }
        }
        // 나무 갱신
        pq = tmpPq;
        // 죽은 나무 양분화
        for (Tree t : deadTrees) {
            nourishment[t.row][t.col] += t.age/2;
        }
    }
}