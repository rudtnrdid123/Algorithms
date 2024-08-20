import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i<=discount.length-10; i++){
            Map<String,Integer> map = new HashMap<>();
            boolean flag =  true;

            for(int j = i; j<i+10; j++){
                map.put(discount[j],map.getOrDefault(discount[j],0)+1);
            }
            
            for(int j = 0; j<want.length; j++){
                int val = map.getOrDefault(want[j],0);
                if(val!=number[j]){
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }       
        return answer;
    }
}