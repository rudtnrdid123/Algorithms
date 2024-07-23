import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new  PriorityQueue<>();
        
        for(int i =  0; i<enemy.length;i++){
            if(k>0){
                pq.add(enemy[i]);
                k-=1;
            }
            else{
                int num = enemy[i];
                if(enemy[i] >  pq.peek()){
                    num = pq.poll();
                    pq.add(enemy[i]);
                }
                if(n >= num)n-=num;
                else
                    break;
            }
            answer++;
        }
        
        return answer;
    }
}