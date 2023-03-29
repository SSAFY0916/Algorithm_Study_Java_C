import java.io.*;
import java.util.*;


public class Main {
    static class XY implements Comparable<XY>{
        int x;
        int y;
        int cnt;
        int vector;

        public XY(int x, int y, int cnt, int vector){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.vector = vector;
        }

        @Override
        public int compareTo(XY o) {
            return this.cnt - o.cnt;
        }
    }
    static int next_x[] = {1,-1,0,0};
    static int next_y[] = {0,0,1,-1};
    static int map[][];
    static int n;
    static int m;
    static int visited[][];
    static void BFS(XY start){
        PriorityQueue<XY> queue = new PriorityQueue<>();
        queue.add(start);
        visited[start.x][start.y] = 0;
        while (!queue.isEmpty()){
            XY now = queue.poll();
            if (map[now.x][now.y] == 2){
                System.out.println(now.cnt);
                break;
            }

            for(int i = 0;i<4;i++){
                int nextx = now.x + next_x[i];
                int nexty = now.y + next_y[i];

                if(nextx<0 || nextx>=n || nexty<0 || nexty>=m) continue;
                if(map[nextx][nexty] == 1) continue;

                if(now.vector != -1 && now.vector != i){
                    if(visited[nextx][nexty] >= now.cnt + 1) {
                        visited[nextx][nexty] = now.cnt + 1;
                        queue.add(new XY(nextx, nexty, now.cnt + 1, i));
                    }
                }
                else{
                    if(visited[nextx][nexty] >= now.cnt) {
                        visited[nextx][nexty] = now.cnt;
                        queue.add(new XY(nextx, nexty, now.cnt, i));
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];
        XY start = null;
        for(int array[] : visited){
            Arrays.fill(array,Integer.MAX_VALUE);
        }
        boolean isCheck = false;
        for(int i = 0;i<n;i++){
            String s = br.readLine();
            for (int j = 0;j<m;j++){
                if(s.charAt(j) == 'C' && !isCheck){
                    isCheck = true;
                    start = new XY(i,j,0,-1);
                    map[i][j] = 0;
                }
                else if(s.charAt(j) == 'C' && isCheck){
                    map[i][j] = 2;
                }

                else if(s.charAt(j) == '*'){
                    map[i][j] = 1;
                }
                else{
                    map[i][j] = 0;
                }
            }
        }

        BFS(start);
    }
}