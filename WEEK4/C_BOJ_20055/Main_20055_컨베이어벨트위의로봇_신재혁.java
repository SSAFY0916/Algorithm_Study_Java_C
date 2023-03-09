import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇_신재혁 {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Integer> upperQ = new ArrayDeque<>();
        Queue<Integer> bottomQ = new ArrayDeque<>();
        BeltSpace[] belt = new BeltSpace[N*2];
        st = new StringTokenizer(br.readLine());
        int zeroCount = 0;
        for(int i = 0; i < N * 2; i++){
            int number = Integer.parseInt(st.nextToken());
            if(number == 0)
                zeroCount++;
            belt[i] = new BeltSpace(number);
        }
        int start = 0;
        int end = N-1;
        final int size = N * 2;
        int answer = 0;
        while(zeroCount < K){
            answer ++;
            // move belt
            start = start - 1 == -1 ? size-1 : start - 1;
            end = end - 1 == -1 ? size-1 : end - 1;
            // take robot
            if(belt[end].hasRobot){
                belt[end].hasRobot = false;
            }
            // move robot
            for(int i = 0; i < N; i++){
                int pos = end-i;
                if(pos < 0)
                    pos += size;
                if(belt[pos].hasRobot){
                    BeltSpace foward = belt[(pos+1)%size];
                    if(!foward.hasRobot && foward.durability > 0){
                        foward.durability--;
                        if(foward.durability == 0) {
                            zeroCount++;
                        }
                        foward.hasRobot = true;
                        belt[pos].hasRobot = false;
                    }
                }
            }
            // take robot
            if(belt[end].hasRobot){
                belt[end].hasRobot = false;
            }
            // place robot
            if(!belt[start].hasRobot && belt[start].durability > 0){
                belt[start].durability--;
                if(belt[start].durability == 0) {
                    zeroCount++;
                }
                belt[start].hasRobot = true;
            }
        }
        System.out.println(answer);
    }
    static class BeltSpace{
        int durability;
        boolean hasRobot;

        public BeltSpace(int durability) {
            this.durability = durability;
            this.hasRobot = false;
        }
    }
}