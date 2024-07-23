import java.util.*;
import java.awt.Point;

class Solution {
    char[][] map;
    boolean[][] visited;
    int mapX,mapY;
    int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        mapX = maps.length;
        mapY = maps[0].length();
        map = new char[mapX][];
        visited = new boolean[mapX][mapY];
        
        for(int i = 0; i<mapX; i++){
            map[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i<mapX; i++){
            for(int j = 0; j<mapY; j++){
                if(map[i][j] != 'X' && !visited[i][j])
                    list.add(bfs(i,j));
            }
        }
        if(list.size() == 0)
            list.add(-1);
        
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i = 0; i<answer.length; i++){
            answer[i]  =  list.get(i);
        }
        return answer;
    }
    
    public int bfs(int x,int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        int sum = 0;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            sum += map[p.x][p.y]-'0';
            
            for(int i  = 0; i<4; i++){
                int dx = p.x + move[i][0];
                int dy = p.y + move[i][1];
                
                if(dx < 0 || dy < 0 || dx >= mapX || dy >= mapY)
                    continue;
                if(visited[dx][dy] || map[dx][dy] == 'X')
                    continue;
                
                q.add(new Point(dx,dy));
                visited[dx][dy] = true;
            }
        }
        return sum;
    }
}