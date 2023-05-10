import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        long[] hashedWeightByUniverse = new long[m];

        int[] origin = new int[n];
        int[] plants = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                origin[j] = plants[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(plants);

            Map<Integer, Integer> map = new HashMap<>();

            int rank = 0;
            for (int plant : plants) {
                if (!map.containsKey(plant)) {
                    map.put(plant, rank++);
                }
            }

            int mul = 1_000_001;
            for (int o : origin) {
                hashedWeightByUniverse[i] += map.get(o) * mul;
                mul++;
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (hashedWeightByUniverse[i] == hashedWeightByUniverse[j]) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
