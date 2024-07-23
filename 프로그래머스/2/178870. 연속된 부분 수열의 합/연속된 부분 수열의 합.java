import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        long[] sum = new long[sequence.length+1];
        sum[0] = 0;
        
        for(int i  = 0; i<sequence.length; i++){
            sum[i+1] = sum[i] + sequence[i];
            
            if(sequence[i] == k){
            answer[0] = i;
            answer[1] = i;
            return answer;
            }    
        }
        
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        
        while(left <= right){
            if(right > sequence.length)
                break;
            
            if(sum[right] - sum[left] == k && minLength > right - left){
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right-1;
                }
            
            else if(sum[right] - sum[left] < k)
                right++;
            else
                left++;
        }
        return answer;
    }
}