import java.io.*;
import java.util.*;

public class Main_4179_불_신재혁 {
    static int N, M;
    static char[][] map;
    static int [][] fire;
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static Pos start;
    static Queue<Pos> Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        fire = new int[N][M];
        Q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            map[i] = str.toCharArray();
            for(int j = 0; j < M; j++){
                switch(map[i][j]){
                    case 'J':
                        start = new Pos(i,j);
                        break;
                    case 'F':
                        Q.offer(new Pos(i,j));
                        fire[i][j] = 1;
                        break;
                    case '#':
                        fire[i][j] = -1;
                }
            }
        }
        int ans;
        if(start.r == 0 || start.r == N-1 || start.c== 0 || start.c == M-1){
            ans = 1;
        }else{
            fireBFS();
            ans = go();
        }
        System.out.println(ans == -1? "IMPOSSIBLE" : ans);
    }
    static int go(){
        Q.offer(start);
        int depth = 0;
        boolean [][] visited = new boolean[N][M];
        visited[start.r][start.c] = true;
        while(!Q.isEmpty()){
            depth++;
            int size = Q.size();
            while(size > 0){
                Pos p = Q.poll();
                for(int i = 0; i < 4; i++){
                    int rr = p.r + dirs[i][0];
                    int cc = p.c + dirs[i][1];
                    if(isInBound(rr,cc) && (fire[rr][cc] == 0 || fire[rr][cc] > depth) && !visited[rr][cc]){
                        if(rr == 0 || rr == N-1 || cc == 0 || cc == M-1){
                            return depth+1;
                        }
                        visited[rr][cc] = true;
                        Q.offer(new Pos(rr,cc));
                    }
                }
                size--;
            }
        }
        return -1;
    }
    static void fireBFS(){
        int depth = 1;
        while(!Q.isEmpty()){
            int size = Q.size();
            while(size > 0){
                Pos p = Q.poll();
                for(int i = 0; i < 4; i++){
                    int rr = p.r + dirs[i][0];
                    int cc = p.c + dirs[i][1];
                    if(isInBound(rr,cc) && fire[rr][cc] == 0){
                        fire[rr][cc] = depth;
                        Q.offer(new Pos(rr,cc));
                    }
                }
                size--;
            }
            depth++;
        }
    }
    static boolean isInBound(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
    static class Pos{
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
