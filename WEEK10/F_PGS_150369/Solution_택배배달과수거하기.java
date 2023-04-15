import java.util.Stack;

class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> d = new Stack<>();
        Stack<Integer> p = new Stack<>();
        for (int i = 0; i < deliveries.length; i++) {
            d.push(deliveries[i]);
            p.push(pickups[i]);
        }

        // 배달할 필요가 없는 집은 제거
        while (!d.isEmpty() && d.peek() == 0) {
            d.pop();
        }

        // 수거할 필요가 없는 집은 제거
        while (!p.isEmpty() && p.peek() == 0) {
            p.pop();
        }

        // 최적해 : 가장 멀리있는 집부터 배달한 후 오는 길에 가장 멀리있는 집부터 수거
        while (!(d.isEmpty() && p.isEmpty())) {
            answer += Math.max(d.size() * 2, p.size() * 2);
            load(cap, d);
            load(cap, p);
        }

        return answer;
    }

    private void load(int cap, Stack<Integer> d) {
        int boxCount = 0;
        while (!d.isEmpty() && boxCount <= cap) {
            if (d.peek() + boxCount <= cap) {
                boxCount += d.pop();
            } else {
                d.push(d.pop() - (cap - boxCount));
                break;
            }
        }
    }
}
