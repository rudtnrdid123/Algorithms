import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int cnt = 0;
        Arrays.sort(B);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i : A)
            pq.offer(i);
        
        for(int i : B)
            dq.offer(i);
        
        while(!pq.isEmpty()){
            int target = pq.poll();
            if(target < dq.peekLast()){
                dq.pollLast();
                cnt++;
            }
            else
                dq.poll(); 
        }
        
        return cnt;
    }
}