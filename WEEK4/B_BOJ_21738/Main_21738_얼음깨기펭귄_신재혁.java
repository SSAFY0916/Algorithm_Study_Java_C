import java.io.*;
import java.util.*;

public class Main_21738_얼음깨기펭귄_신재혁 {
    static int N, S, P;
    static ArrayList<Integer>[] adjList;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        System.out.println(bfs(P));
    }
    public static int bfs(int start){
        Queue<Integer> Q = new ArrayDeque<>();
//        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int supportCount = 0;
        int depth = 0;
        int[] supportDepth = new int[2];
        visited = new boolean[N+1];
        Q.offer(start);
        out:
        while(!Q.isEmpty()){
            depth++;
            int size = Q.size();
            for(int i = 0; i < size; i++){
                int from = Q.poll();
//                System.out.println("visited:"+from);
                visited[from] = true;
                if(from <= S){
                    supportDepth[supportCount] = depth;
                    supportCount++;
//                    System.out.println("support:"+from);
                    if(supportCount == 2){
                        break out;
                    }
                    continue;
                }
                for(int j = 0; j < adjList[from].size(); j++){
                    if(!visited[adjList[from].get(j)]){
//                        System.out.println("pushed:"+adjList[from].get(j));
                        visited[adjList[from].get(j)] = true;
                        Q.offer(adjList[from].get(j));
                    }
                }
            }
//            while(!PQ.isEmpty()) {
//                Q.offer(PQ.poll());
//            }

        }
        return N - (supportDepth[0] + supportDepth[1] - 1);
    }
}
