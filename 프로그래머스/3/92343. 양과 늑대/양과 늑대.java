import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> list;
    public int maxSheep = 0;
    public boolean[] visited;
    public int[] infos;

    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        infos = info;
        list = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        dfs(0, 0, 0, new ArrayList<>(Arrays.asList(0)));
        return maxSheep;
    }

    public void dfs(int node, int wolf, int sheep, ArrayList<Integer> nextPos) {
        visited[node] = true;

        if(infos[node] == 0)sheep++;
        else wolf++;

        if (wolf >= sheep) {
            visited[node] = false;
            return;
        }

        maxSheep = Math.max(maxSheep, sheep);

        ArrayList<Integer> currentNextPos = new ArrayList<>(nextPos);
        for (int next : list.get(node)) {
            if (!visited[next]) {
                currentNextPos.add(next);
            }
        }
        for (int next : currentNextPos) {
            if (!visited[next]) {
                dfs(next, wolf, sheep, currentNextPos);
            }
        }
        visited[node] = false;
    }
}
