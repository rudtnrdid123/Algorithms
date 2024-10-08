import java.util.*;
class Solution {
    int[] cost;
    List<Integer>[] graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n+1];
        
        for(int i = 0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] data : roads){
            graph[data[0]].add(data[1]);
            graph[data[1]].add(data[0]);
        }
        cost = new int[n+1];
        Arrays.fill(cost,-1);
        bfs(destination);
        
        for(int i = 0; i<sources.length; i++){
            answer[i] = cost[sources[i]];
        }
        
        return answer;
    }
    
    public void bfs(int start){
        Queue<Integer> q =  new LinkedList<>();
        q.add(start);
        cost[start] = 0;
        
        while(!q.isEmpty()){
            int current = q.poll();
            int len = graph[current].size();
            
            for(int i = 0; i<len; i++){
                int next = graph[current].get(i);
                if(cost[next] == -1){
                    cost[next] = cost[current] + 1;
                    q.add(next);
                }    
            }
        }
    }
}