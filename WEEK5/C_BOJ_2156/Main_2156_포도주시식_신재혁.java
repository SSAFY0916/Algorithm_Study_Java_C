import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N];
        for(int i = 0; i < N ; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }
        int[] solutions = new int[N];
        solutions[0] = wines[0];
        if(N >= 2)
            solutions[1] = solutions[0] + wines[1];
        if(N >= 3)
            solutions[2] = Math.max(Math.max(wines[2] + wines[0], wines[1] + wines[2]),wines[0] + wines[1]);
        for(int i = 3; i < N; i++){
            solutions[i] = Math.max(Math.max(solutions[i-1],solutions[i-2] + wines[i]),solutions[i-3] + wines[i] + wines[i-1]);
        }
        System.out.print(solutions[N-1]);
    }
}