import java.util.*;
class Solution {
    public int[] answer;
    public Map<Integer,ArrayList<Integer>> graph;
    public Map<Integer,Integer> outgree;
    public Map<Integer,Integer> ingree;
    public int[] solution(int[][] edges) {
        answer = new int[4];
        graph = new HashMap<>();
        outgree = new HashMap<>();
        ingree = new HashMap<>();
        
        
        for(int[] node : edges){
            graph.putIfAbsent(node[0],new ArrayList<>());
            graph.get(node[0]).add(node[1]);
            outgree.put(node[0],outgree.getOrDefault(node[0],0)+1);
            ingree.put(node[1],ingree.getOrDefault(node[1],0)+1);
        }
        
        for(int center : outgree.keySet()){
            int outCnt = outgree.get(center);
            int inCnt = ingree.getOrDefault(center,0);
            
            if(outCnt >= 2 && inCnt == 0){
                answer[0] = center;
                for(int node : graph.get(center)){
                    dfs(node,node);
                }
                break;
            }
        }

        return answer;
    }
    
    public void dfs(int start, int firstNode){
        if(outgree.getOrDefault(start,0)> 1){
            answer[3]++;
            return;
        }
        List<Integer> nextNodes = graph.getOrDefault(start, new ArrayList<>());
        if (!nextNodes.isEmpty()) {
            int next = nextNodes.get(0);
            if(next == firstNode){
                answer[1]++;
                return;
            }
            dfs(next,firstNode); 
        }
        else{
            answer[2]++;
            return;
        }    
    }
}