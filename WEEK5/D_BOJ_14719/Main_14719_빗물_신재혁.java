import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int H,W;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new int [H][W];
        for(int i = 0; i < W; i++){
            int h = Integer.parseInt(st.nextToken());
            for(int j = 0; j < h; j++){
                map[H-1-j][i] = 1;
            }
        }
        int count = 0;
        for(int i = H-1; i >= 0; i--){
            boolean fill = false;
            int maybeCount = 0;
            for(int j = 0; j < W; j++){
                if(map[i][j] == 1){
                    if(fill){
                        count += maybeCount;
                        maybeCount = 0;
                    }else{
                        fill = true;
                    }
                }else{
                    if(fill){
                        maybeCount++;
                    }
                }
            }
        }
        System.out.print(count);
    }
}