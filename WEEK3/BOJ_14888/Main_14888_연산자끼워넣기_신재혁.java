import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기_신재혁 {
    static int maxValue = Integer.MIN_VALUE;
    static int N;
    static int [] numbers;
    static int [] selected;
    static int [] operators;
    static int[] operatorsLeft;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        selected = new int[N-1];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        operators = new int[4];
        operatorsLeft = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
        permute(0);
        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append('\n').append(minValue);
        System.out.println(sb);

    }
    public static void permute(int count){
        if(count == N-1){
            int value = numbers[0];

            for(int i = 0; i < selected.length; i++){
                switch(selected[i]){
                    case 0:
                        value += numbers[i+1];
                        break;
                    case 1:
                        value -= numbers[i+1];
                        break;
                    case 2:
                        value *= numbers[i+1];
                        break;
                    case 3:
                        value /= numbers[i+1];
                        break;
                }
            }
            minValue = Math.min(minValue,value);
            maxValue = Math.max(maxValue,value);
            return;
        }
        for(int j = 0; j < 4; j++){
            if(operators[j] == 0){
                continue;
            }
            operators[j] -= 1;
            selected[count] = j;
            permute(count+1);
            operators[j] += 1;
        }
    }
}
