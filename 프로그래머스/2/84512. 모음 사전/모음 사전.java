import java.util.*;
class Solution {
    public int cnt = 1;
    public String[] arr  =  {"A","E","I","O","U"};
    Map<String,Integer> map = new HashMap<>();
    public int solution(String word) {
        function("",0);
        return map.get(word);
    }
    
    public void function(String str, int len){
        if(len ==  5)
            return;
        for(int i = 0; i<5; i++){
            String next = str + arr[i];
            map.put(next,cnt);
            cnt++;
            function(next, len + 1);
        }
    }
}