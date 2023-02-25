import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int f, s, g, u, d;

    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 총 층
        s = Integer.parseInt(st.nextToken()); // 출발 층
        g = Integer.parseInt(st.nextToken()); // 목적지
        u = Integer.parseInt(st.nextToken()); // up
        d = Integer.parseInt(st.nextToken()); // down

        visited = new int[f+1];

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(s);
        visited[s] = 1;
        while (!queue.isEmpty()) {
            if (visited[g] !=0) break;

            int curr = queue.poll();
            int next = curr + u;
            if (next >=1 && next <= f ) {
                if (visited[next] == 0) {
                    visited[next] = visited[curr]+1;
                    queue.offer(next);
                }
            }
            next = curr - d;
            if (next >=1 && next <= f ) {
                if (visited[next] == 0) {
                    visited[next] = visited[curr]+1;
                    queue.offer(next);

                }
            }

//            System.out.println(Arrays.toString(visited));
        }

        if(visited[g] != 0) System.out.println(visited[g]-1);
        else System.out.println("use the stairs");
    }
}