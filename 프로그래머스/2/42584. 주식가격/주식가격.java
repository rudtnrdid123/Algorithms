import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i<len; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int previous = stack.pop();
                answer[previous] = i - previous;
            }
            stack.push(i);
        }
        System.out.println(stack);
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            answer[cur] = len - cur - 1;
        }
       
        return answer;
    }
}