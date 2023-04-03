import java.io.*;
import java.util.*;

public class Main_1188_음식평론가_신재혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sausages = Integer.parseInt(st.nextToken());
        int people = Integer.parseInt(st.nextToken());
        int longSausage = sausages * people;
        int countCollisions = 0;
        Set<Integer> S = new TreeSet<>();
        for(int i = people; i < longSausage; i+=people){
            S.add(i);
        }
        for(int i = sausages; i < longSausage; i+=sausages){
            if(S.contains(i)){
                countCollisions++;
            }else{
                S.add(i);
            }
        }
        System.out.println((people-1)-countCollisions);
    }
}
