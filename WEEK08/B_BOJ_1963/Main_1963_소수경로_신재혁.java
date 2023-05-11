import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1963_소수경로_신재혁 {
        static boolean [] isPrime;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int TC = Integer.parseInt(br.readLine());
            genPrimeList();
            for(int tc = 0; tc < TC; tc++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                sb.append(primeBfs(start,end)).append('\n');
            }

            System.out.println(sb);
        }
        public static int primeBfs(int start, int end){
            Queue<Integer> Q = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            Q.offer(start);
            visited[start] = true;
            int depth = 0;
            int[] digits = {1,10,100,1000};
            while(!Q.isEmpty()){
                int size = Q.size();
                while(size > 0){
                    int p = Q.poll();
                    if(p == end)
                        return depth;
                    int num = p;
                    for(int i = 0; i < 4; i++){
                        int digit = (p / digits[i]) % 10;
                        num = p - digit * digits[i];
                        for(int j = 0; j < 10; j++){
                            int num2 = num + digits[i] * j;
                            if(num2 >= 1000&& !visited[num2] && isPrime[num2]){
                                visited[num2] = true;
                                Q.offer(num2);
                            }
                        }
                    }
                    size--;
                }
                depth++;
            }
            return -1;
        }

        public static void genPrimeList(){
            isPrime = new boolean[10000];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for(int i = 2; i <= 100; i++){
                if(isPrime[i]){
                    for(int j = i * 2; j < 10000; j+= i){
                        isPrime[j] = false;
                    }
                }
            }
        }
    }
