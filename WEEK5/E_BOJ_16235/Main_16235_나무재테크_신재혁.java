import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16235_나무재테크_신재혁 {
    public static int N, M, K;
    public static int[][] map, nut;
    public static StringBuilder sb;
    public static int [][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        nut = new int[N][N];

        //List<Tree> trees = new ArrayList<>();
        PriorityQueue<Tree> trees = new PriorityQueue<>();
        Queue<Tree> Q = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            Arrays.fill(map[i],5);
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                nut[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            Tree t = new Tree(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
            trees.add(t);
        }
        int[][] nut2 = new int[N][N];
        while(K > 0){
            // 봄
            int size = trees.size();
            for(int i = 0; i < size; i++){
                Tree t = trees.poll();
                if(map[t.r][t.c] >= t.age){
                    map[t.r][t.c] -= t.age;
                    t.age += 1;
                    Q.offer(t);
                }else{
                    nut2[t.r][t.c] += t.age/2;
                }
            }
            // 여름
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] += nut2[i][j];
                    nut2[i][j] = 0;
                }
            }

            // 가을
            int ts = Q.size();
            for(int i = 0; i < ts; i++){
                Tree t = Q.poll();
                Q.offer(t);
                if(t.age % 5 == 0){
                    for(int j = 0; j < 8; j++){
                        int rr = t.r + dirs[j][0];
                        int cc = t.c + dirs[j][1];
                        if(isInBound(rr,cc)){
                            Q.offer(new Tree(rr,cc,1));
                        }
                    }
                }
            }
            while(!Q.isEmpty()){
                trees.offer(Q.poll());
            }
            // 겨울
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] += nut[i][j];
                }
            }
            K--;
        }
        System.out.println(trees.size());
    }
    public static boolean isInBound(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < N;
    }
    static class Tree implements Comparable<Tree>{
        int r;
        int c;
        int age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "r=" + r +
                    ", c=" + c +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }
}