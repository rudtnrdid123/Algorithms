import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(bill[0]);
        pq.offer(bill[1]);
        
        while(!pq.isEmpty()){
            int big = pq.poll();
            int small = pq.peek();
            
            if(small <= wallet[0] && big <= wallet[1])
                break;
            else{
                answer++;
                big /= 2;
                pq.offer(big);
            }
        }   
        return answer;
    }
}