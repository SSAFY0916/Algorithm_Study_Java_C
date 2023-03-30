import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5430_AC_신재혁 {
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i < n ; i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            boolean doPoll = true;
            boolean err = false;
            for(int i = 0; !err && i < p.length(); i++){
                switch(p.charAt(i)){
                    case 'R':
                        doPoll = !doPoll;
                        break;
                    case 'D':
                        if(!deque.isEmpty()){
                            if(doPoll)
                                deque.pollFirst();
                            else
                                deque.pollLast();
                        }else{
                            err = true;
                        }
                        break;
                }
            }
            if(!err){
                sb.append('[');
                while(!deque.isEmpty()){
                    if(doPoll){
                        sb.append(deque.pollFirst());
                    }else{
                        sb.append(deque.pollLast());
                    }
                    if(!deque.isEmpty()) {
                        sb.append(',');
                    }
                }
                sb.append(']').append('\n');
//                if(doPoll) {
//
//                    sb.append(deque).append('\n');
//                }
//                else{
//                    List<Object> list = Arrays.asList(deque.toArray());
//                    Collections.reverse(list);
//                    sb.append(list).append('\n');
//                }
            }else{
                sb.append("error").append('\n');
            }
        }
        System.out.print(sb);

    }
}