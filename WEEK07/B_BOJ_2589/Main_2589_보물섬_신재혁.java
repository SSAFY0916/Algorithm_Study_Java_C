package Algorithm_Study_Java2.WEEK7.B_BOJ_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬_신재혁 {
    public static int N, M;
    public static int [][] dirs = {{-1,0},{1,0},{0-1},{0,1}};
    public static int maxDepth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char [N][M];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        maxDepth = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                maxDepth = Math.max(maxDepth, bfs(new Pos(i,j)));
            }
        }
    }
    public static int bfs(Pos start){
        Queue<Pos> Q = new ArrayDeque<>();
        Q.offer(start);
        boolean[][] visited = new boolean[N][M];
        int depth = 0;
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i = 0; i < size; i++){
                Pos p = Q.poll();
                int r = p.r;
                int c = p.c;
                for(int j = 0; j < 4; j++){
                    int rr = r + dirs[j][0];
                    int cc = c + dirs[j][1];
                    if(isInBound(rr,cc) && !visited[rr][cc]){
                        visited[rr][cc] = true;
                        Q.offer(new Pos(rr,cc));
                    }
                }
            }
            depth++;
        }
        return depth;
    }
    public static class Pos{
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static boolean isInBound (int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
