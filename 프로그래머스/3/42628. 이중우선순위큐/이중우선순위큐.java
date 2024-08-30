import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str : operations){
            StringTokenizer st  = new StringTokenizer(str);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(command.equals("I")){
                minQ.offer(num);
                maxQ.offer(num);
            }
            else{
                if(minQ.isEmpty())continue;
                if(num < 0){
                    int min = minQ.poll();
                    maxQ.remove(min);
                }
                else{
                    int max = maxQ.poll();
                    minQ.remove(max);
                }
            }
        }
        if(!minQ.isEmpty()){
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
    
        return answer;
    }
}