import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] adjMatrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        adjMatrix = new int[N][N];
        for(int i = 0; i < N; i++){
            //st = new StringTokenizer(br.readLine());
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                adjMatrix[i][j] = str.charAt(j) == 'Y' ? 1 : 0;
            }
        }
        //        for(int i = 0; i < N; i++){
        //            System.out.println(Arrays.toString(adjMatrix[i]));
        //        }

        int maxCount = 0;
        for(int i = 0; i < N; i++){
            Queue<Integer> Q = new ArrayDeque<>();
            boolean[] visited = new boolean[N];
            Q.offer(i);
            int depth = 0;
            int count = -1;
            while(!Q.isEmpty()){
                int size = Q.size();
                for(int j = 0; j < size; j++){
                    int currentVertex = Q.poll();
                    visited[currentVertex] = true;
                    count++;
                    for(int k = 0; k < N; k++){
                        if(!visited[k] && adjMatrix[currentVertex][k] == 1){
                            visited[k] = true;
                            Q.offer(k);
                        }
                    }
                }
                if(depth == 2){
                    break;
                }
                depth++;
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(maxCount);
    }
}