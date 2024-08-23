import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int[] arr = new int[length];
        
        for(int i = 0; i<length; i++){
            arr[i] = name.charAt(i) - 'A';
            if(arr[i] > 13)
                    answer += 26 - arr[i];
                else
                    answer += arr[i];
        }
        
        int minMove = length - 1;
        for(int i = 0; i<length; i++){
            int next = i+1;
            while(next<length && arr[next] == 0){
                next++;
            }

            int leftMove =  i*2 + length - next;
            minMove = Math.min(minMove,leftMove);
            int rightMove = (length - next) *2 + i;
            minMove = Math.min(minMove,rightMove);
        }
        answer+= minMove;
        
        System.out.println(Arrays.toString(arr));
        return answer;
    }
}