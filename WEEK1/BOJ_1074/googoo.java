import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, r, c, cnt;

    static void recursive(int size, int row, int col) {

        if (size == 1) {
            System.out.println(cnt);
            return ;
        }

        int ns = size/2;
        int nsSquare = ns*ns;

        if(ns + row > r && ns + col > c ) {
            recursive(ns, row, col);
        }
        if(ns + row > r && ns + col <= c ) {
            cnt += nsSquare;
            recursive(ns, row, col+ns);
        }
        if(ns + row <= r && ns + col > c ) {
            cnt += nsSquare*2;
            recursive(ns, row+ns, col);
        }
        if(ns + row <= r && ns + col <= c ) {
            cnt += nsSquare*3;
            recursive(ns, row+ns, col+ns);
        }




    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        recursive(size, 0, 0);

    }

}
