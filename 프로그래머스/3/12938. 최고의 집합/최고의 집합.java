import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(n > s){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[n];
        int index = 0;
        
        if(n == s){   
            Arrays.fill(answer,1);
            return answer;
        }
        
        while(n >= 1){
            int num = s/n;
            s -= num;
            n -= 1;
            answer[index++] = num;
        }
        
        return answer;
    }
}