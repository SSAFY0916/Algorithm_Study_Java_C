import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] works = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            works[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(works, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            }
            
            return o1[0] - o2[0];
        });

        int time = Integer.MAX_VALUE;
        for (int[] work : works) {
            if (time > work[1]) {
                time = work[1] - work[0];
            } else {
                time -= work[0];
            }
        }

        System.out.println(time < 0 ? -1 : time);
    }
}
