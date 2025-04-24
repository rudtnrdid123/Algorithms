import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<section.length; i++){
            q.offer(section[i]);
        }
        int num = q.poll();
        
        while(!q.isEmpty()){
            int next = q.peek();
            
            if(num+m > next){
                q.poll();
            }
            else{
                answer++;
                num = q.poll();
            }
        }
        
        return answer;
    }
}