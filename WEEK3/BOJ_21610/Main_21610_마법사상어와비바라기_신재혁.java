import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기_신재혁 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] moves = new int[M][2];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                moves[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Cloud> clouds = new ArrayList<>();
        clouds.add(new Cloud(N-1,0));
        clouds.add(new Cloud(N-2,0));
        clouds.add(new Cloud(N-1,1));
        clouds.add(new Cloud(N-2,1));
        List<WaterMagic> waterMagics = new ArrayList<>();
        for(int k = 0; k < M; k++){
            for(Cloud c : clouds){
                c.move(moves[k]);
                waterMagics.add(c.rain());
            }
            for(WaterMagic w : waterMagics){
                w.fill();
            }
            waterMagics.clear();
            for(Cloud c : clouds){
                c.load();
            }
            List<Cloud> newClouds = new ArrayList<>();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] >= 2){
                        newClouds.add(new Cloud(i,j));
                        map[i][j] -= 2;
                    }
                }
            }
            for(Cloud c : clouds){
                map[c.r][c.c] = c.unload();
            }
            clouds = newClouds;
        }


        int sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
    static boolean inBound(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < N;
    }
    static class Cloud {
        static int[][] moveArray = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        int r;
        int c;
        int store;
        public Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public void move(int[] move){

            this.r = (this.r + moveArray[(move[0]-1)][0] * move[1]) % N;
            if(this.r < 0)
                this.r += N;
            this.c = (this.c + moveArray[(move[0]-1)][1] * move[1]) % N;
            if(this.c < 0)
                this.c += N;
        }
        public WaterMagic rain(){
            map[this.r][this.c]++;
            return new WaterMagic(this.r,this.c);
        }
        public void load(){
            store = map[this.r][this.c];
            map[this.r][this.c] = 0;
        }
        public int unload(){
            return store;
        }

        @Override
        public String toString() {
            return "Cloud{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    static class WaterMagic{
        int r;
        int c;
        static int[][] fillArray = {{-1,-1},{-1,1},{1,-1},{1,1}};

        public WaterMagic(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public void fill(){
            for(int i = 0; i < 4; i++){
                int rr = this.r+fillArray[i][0];
                int cc = this.c+fillArray[i][1];
                if(inBound(rr,cc) && map[rr][cc] > 0){
                    map[r][c]++;
                }
            }
        }
    }
}
