import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : works){
            maxHeap.offer(i);
        }
        
        for(int i = 0; i<n; i++){
            if(maxHeap.isEmpty())
                break;
            
            int cur = maxHeap.poll();
            if(cur > 0){
                cur--;
                maxHeap.offer(cur);
            }
        }

        while(!maxHeap.isEmpty()){
            int cur = maxHeap.poll();
            answer += (long)cur*cur;
        }
        return answer;
    }
}