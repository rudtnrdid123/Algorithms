import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(String[] str : clothes){
            String type = str[1];
            String name = str[0];
            
            if(!map.containsKey(type))
                map.put(type,new ArrayList<>());
            map.get(type).add(name);
        }
        
        int answer = 1;
        for(List<String> val : map.values()){
            answer *= (val.size()+1);
        }
         
        return answer-1;
    }
}