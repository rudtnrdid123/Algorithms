import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int x = 0; x<=d; x+=k){
            long zegobX = (long)x*x;
            long maxY = (long)d*d - zegobX;
            
            if(maxY < 0)continue;
            answer += (long)(Math.sqrt(maxY)/k)+1;
        }
        return answer;
    }
}