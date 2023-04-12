import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12869_뮤탈리스크_신재혁 {
    static int[][] dmg = {{9,3,1},{9,1,3},{1,9,3},{3,9,1},{3,1,9},{1,3,9}};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int SCV = Integer.parseInt(br.readLine());
        int[] hp = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < SCV; i++){
            hp[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mutalisk(hp));
    }
    static int mutalisk(int[] arr){
        Queue<int[]> Q = new ArrayDeque<>();
        boolean [][][] visited = new boolean[61][61][61];
        Q.offer(arr);
        int count = 0;
        while(!Q.isEmpty()){
            int size = Q.size();
            while(size > 0){
                int[] m = Q.poll();
//                System.out.println(Arrays.toString(m));
                if(m[0] <= 0 && m[1] <= 0 && m[2] <= 0){
                    return count;
                }
                for(int i = 0; i < 6; i++){
                    int[] newHP = new int[3];
                    for(int j = 0; j < 3; j++){
                        newHP[j] = Math.max(m[j] - dmg[i][j],0);
                    }
                    if(!visited[newHP[0]][newHP[1]][newHP[2]]) {
                        visited[newHP[0]][newHP[1]][newHP[2]] = true;
                        Q.offer(newHP);
                    }
                }
                size--;
            }
            count++;
        }
        return count;
    }
}