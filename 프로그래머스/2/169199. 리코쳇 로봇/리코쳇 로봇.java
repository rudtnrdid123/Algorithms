import java.util.*;
import java.awt.Point;
class Solution {
    public int[][] map;
    public int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public int startX,startY,endX,endY;
    public int row,col;
    public int solution(String[] board) {

        row = board.length;
        col = board[0].length();
        map = new int[row][col];
        
        for(int i = 0; i<row; i++){
            for(int j =  0; j<col; j++){
                char cur = board[i].charAt(j);
                if(cur == 'R'){
                    startX = i;
                    startY = j;
                }
                if(cur == 'G'){
                    endX = i;
                    endY = j;
                }
                if(cur == 'D'){
                    map[i][j] = -1;
                }
                else{
                    map[i][j] = 10001;
                }
                    
            }
        }
        bfs();      
        if(map[endX][endY] == 10001)return -1;
        else
            return map[endX][endY];
    }
    
    public void bfs(){
        map[startX][startY] = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX,startY));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i<move.length; i++){
                int dx = p.x + move[i][0];
                int dy = p.y + move[i][1];
                
                while(isTrue(dx,dy) && map[dx][dy] !=-1){
                    dx += move[i][0];
                    dy += move[i][1];
                }
                dx -= move[i][0];
                dy -= move[i][1];
                
                if(dx == p.x && dy == p.y) continue;
                if(map[dx][dy] <= map[p.x][p.y] + 1) continue;
                map[dx][dy] = map[p.x][p.y] + 1;
                q.offer(new Point(dx,dy));
            }
        }
    }
    
    public boolean isTrue(int dx, int dy){
        if(dx<0 || dy<0 || dx>=row || dy>=col)
            return false;
        else
            return true;
    } 
}