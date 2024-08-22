import java.util.*;
class Solution {
    public int max = 0;
    public int solution(int k, int[][] dungeons) {     
        Arrays.sort(dungeons,(o1,o2)->(o1[0] == o2[0]? o1[1]-o2[1]:o2[0]-o1[0]));
        boolean[] visited = new  boolean[dungeons.length];
        dfs(k,dungeons,0,visited);
        return max;
    }
    
    public void dfs(int hp, int[][] arr, int count, boolean[] visited){
        max =  Math.max(count,max);
        for(int i = 0; i<arr.length; i++){
            if(hp >= arr[i][0] && !visited[i]){
                visited[i] = true;
                dfs(hp - arr[i][1], arr, count +1,visited);
                visited[i] =  false;
            }
        }
    }
}