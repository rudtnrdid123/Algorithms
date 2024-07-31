import java.util.*;
class Solution {
    public int[][] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];
        
        for(int i = 0; i< wires.length; i++){
            int start = wires[i][0], end = wires[i][1];            
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        
        for(int i = 0; i<wires.length; i++){
            int start = wires[i][0], end = wires[i][1];
            graph[start][end] = 0;
            graph[end][start] = 0;
            answer = Math.min(answer,bfs(n,start));
            
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        return answer;
    }
    
    public int bfs(int n, int start){
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        int cnt  = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 1; i<=n; i++){
                if(graph[node][i] == 1 && !visited[i]){
                    visited[i] = true;
                    cnt++;
                    q.offer(i);
                } 
            }
        }
        return (int)Math.abs(cnt-(n-cnt));
    }
}