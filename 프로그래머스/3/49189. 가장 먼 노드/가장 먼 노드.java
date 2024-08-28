import java.util.*;
class Solution {
    public ArrayList<Integer>[] graph;
    public int answer = 0;
    
    public int solution(int n, int[][] edge) {

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] node : edge) {
            int start = node[0];
            int end = node[1];
            graph[start].add(end);
            graph[end].add(start);
        }

        find(1, n);
        return answer;
    }

    public void find(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        int max = 0;

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    q.offer(next);
                    
                    max = Math.max(max,distance[next]);
                }
            }
        }
        
        for(int i : distance){
            if(i == max)
                answer++;
        }
    }
}