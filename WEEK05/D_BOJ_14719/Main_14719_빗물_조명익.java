import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
        int[] heights = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < w; i++) {
            for (int j = heights[i]; j > 0; j--) {
                for (int k = i + 1; k < w; k++) {
                    if (j <= heights[k]) {
                        sum += (k - i - 1);
                        break;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
