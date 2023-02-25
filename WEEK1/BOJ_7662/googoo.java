import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine()); // tc수

        for(int t=0; t<tc; ++t) {
            int k = Integer.parseInt(br.readLine()); // 연산 수

            PriorityQueue<Long> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Long> minQ = new PriorityQueue<>();
            HashMap<Long, Integer> map = new HashMap<>();

            for(int i=0; i<k; ++i) {
                st = new StringTokenizer(br.readLine());
                String operator = st.nextToken();
                long operand = Long.parseLong(st.nextToken());

                if(operator.equals("I")) { // 삽입
                    maxQ.offer(operand);
                    minQ.offer(operand);
                    map.put(operand, map.getOrDefault(operand, 0)+1);

                }

                if(operator.equals("D")) { // 삭제

                    if(!map.isEmpty()) { // 비었을 때 스킵
                        if(operand == 1 ) { // 최대값 삭제
                            while(!map.containsKey(maxQ.peek())) {
                                maxQ.poll();
                            }

                            long tmp = maxQ.poll();
                            if(map.get(tmp) == 1) map.remove(tmp);
                            else map.put(tmp, map.get(tmp)-1);
                        }

                        if(operand == -1) { // 최소값 삭제
                            while(!map.containsKey(minQ.peek())) {
                                minQ.poll();
                            }
                            long tmp = minQ.poll();

                            if(map.get(tmp) == 1) map.remove(tmp);
                            else map.put(tmp, map.get(tmp)-1);
                        }
                    }

                }
//				System.out.println(operator + " " + operand);
//				System.out.println("max : "+ maxQ);
//				System.out.println("min : "+ minQ);
//				System.out.println("map : " + map);
//				System.out.println("-----------------");
            }

            if(map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(maxQ.peek() + " " + minQ.peek());

        }
    }

}

