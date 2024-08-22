import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int n = number.length();
        int remain = n - k;

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char current = number.charAt(i);

            while (!stack.isEmpty() && k>0 && stack.peek() < current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }
        for(int i = 0; i<remain; i++){
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
