import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i< tangerine.length; i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Map.Entry<Integer,Integer>> entryMap = new ArrayList<>(map.entrySet());
        Collections.sort(entryMap, (o1,o2) -> o2.getValue() - o1.getValue());
        
        int sum = 0;
        for(Map.Entry<Integer,Integer> entry : entryMap){
            int value = entry.getValue();
            if(k <= value)
                return 1;
            
            sum += value;
            answer++;
            
            if(sum >= k)
                break;
        }
        
        return answer;
    }
}