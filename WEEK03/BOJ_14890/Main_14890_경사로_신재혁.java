import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14890_경사로_신재혁 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0, prev, U, D, k;
        boolean reject;
        for(int i = 0; i < N * 2; i++){
            if(i < N){
                k = i;
                prev = map[k][0];
                U = 1;
                D = 0;
                reject = false;
                for(int j = 1; j < N; j++){
                    int current = map[k][j];
                    if(current == prev){
                        if(D == 0)
                            U++;
                        else
                            D--;
                    }
                    else if(current == prev + 1){
                        if(D > 0){
                            reject = true;
                            break;
                        }
                        else if(U >= L){
                            U = 1;
                        }else{
                            reject = true;
                            break;
                        }
                    }
                    else if(current == prev - 1){
                        if(D == 0){
                            U = 0;
                            D = L-1;
                        }
                        else{
                            reject = true;
                            break;
                        }
                    }else{
                        reject = true;
                        break;
                    }
                    prev = current;
                }
                if(D == 0 && !reject){
                    count++;
                }
            }else{
                k = i - N;
                prev = map[0][k];
                U = 1;
                D = 0;
                reject = false;
                for(int j = 1; j < N; j++){
                    int current = map[j][k];
                    if(current == prev){
                        if(D == 0)
                            U++;
                        else
                            D--;
                    }
                    else if(current == prev + 1){
                        if(D > 0){
                            reject = true;
                            break;
                        }
                        else if(U >= L){
                            U = 1;
                        }else{
                            reject = true;
                            break;
                        }
                    }
                    else if(current == prev - 1){
                        if(D == 0){
                            U = 0;
                            D = L-1;
                        }
                        else{
                            reject = true;
                            break;
                        }
                    }else{
                        reject = true;
                        break;
                    }
                    prev = current;
                }
                if(D == 0 && !reject){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
