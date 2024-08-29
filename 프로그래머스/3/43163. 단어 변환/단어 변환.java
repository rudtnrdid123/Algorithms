import java.util.*;
class Solution {
    public HashSet<String> set;
    public int answer = 0;
    public int solution(String begin, String target, String[] words) {
        set = new HashSet<>(Arrays.asList(words)); 
        if(!set.contains(target))
            return 0;
        
        bfs(begin,target);
        return answer;
    }
    
    public void bfs(String start, String end){
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        set.remove(start);
        
        while(!q.isEmpty()){
            for(int i = 0; i<q.size(); i++){
                String cur = q.poll();
                
                if(cur.equals(end))
                    return;

                for(String word : set.toArray(new String[set.size()])){
                    if(convert(cur,word)){
                        q.offer(word);
                        set.remove(word);
                    }
                }
            }
            answer++;
        }
    }
    public boolean convert(String word1, String word2){
        int cnt = 0;
        for(int i = 0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i))
                cnt++;
        }
        return cnt == 1;
    }
}