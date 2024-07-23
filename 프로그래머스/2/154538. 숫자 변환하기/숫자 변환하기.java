import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        Set<Integer> visited =  new HashSet<>();
        
        q.add(x);
        steps.add(0);
        visited.add(x);
        
        while(!q.isEmpty()){
            int current = q.poll();
            int step = steps.poll();
            
            if(current == y)
                return step;
            
            if(current+n <=y && !visited.contains(current+n)){
                q.add(current+n);
                steps.add(step+1);
                visited.add(current+n);
            }
            
            if(current*2 <=y && !visited.contains(current*2)){
                q.add(current*2);
                steps.add(step+1);
                visited.add(current*2);
            }
            
            if(current*3 <=y && !visited.contains(current*3)){
                q.add(current*3);
                steps.add(step+1);
                visited.add(current*3);
            }
        }
        
        return -1;
    }
}