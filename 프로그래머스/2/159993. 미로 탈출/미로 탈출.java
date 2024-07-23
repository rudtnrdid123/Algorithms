import java.util.*;
import java.awt.Point;
class Solution {
    char[][] miro;
    int[][] dp;
    int[][] map = {{1,0},{0,1},{-1,0},{0,-1}};
    int mapsLength, mapIndexLength;
    
    public int solution(String[] maps) {
        mapsLength = maps.length;
        mapIndexLength = maps[0].length();
        miro = new char[mapsLength][mapIndexLength];
        dp = new  int[mapsLength][mapIndexLength];
        int startRow = 0; 
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;
        
        for(int i =  0; i<mapsLength;i++){
            for(int j = 0; j<mapIndexLength; j++){
                miro[i][j] = maps[i].charAt(j);
                dp[i][j] = -1;
                if(miro[i][j] == 'S'){
                    startRow = i; 
                    startCol = j;
                }
                if(miro[i][j] == 'E'){
                    endRow = i;
                    endCol = j;
                }    
            }
        }
        int[] lebber = new int[2]; 
        lebber = LebberBfs(startRow, startCol);
        if(dp[lebber[0]][lebber[1]] == -1)
            return -1;        
        
        
        int lebberDp = dp[lebber[0]][lebber[1]];
        dp = new int[mapsLength][mapIndexLength];
        dp[lebber[0]][lebber[1]] = lebberDp;
        endBfs(lebber[0],lebber[1]);
     
        if(dp[endRow][endCol] == 0)
            return -1;
        return dp[endRow][endCol] +1;
    }
    
    public int[] LebberBfs(int x, int  y){
        Queue<Point> q =  new LinkedList<>();
        q.add(new Point(x,y));
        int[] lebber = new  int[2];
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for(int i = 0; i<4; i++){
                int dx = p.x+map[i][0];
                int dy = p.y+map[i][1];
                
                if(dx <  0 || dy < 0 ||  dx>= mapsLength || dy >= mapIndexLength)
                    continue;
                
                if(miro[dx][dy] == 'X' || dp[dx][dy] !=-1)
                    continue;
                
                if(miro[dx][dy] == 'L'){
                    dp[dx][dy] = dp[p.x][p.y]+1;
                    lebber[0] = dx; lebber[1] = dy;
                    break;
                }
                
                dp[dx][dy] = dp[p.x][p.y]+1;
                q.add(new Point(dx,dy));
            }
        }
        return lebber;
    }
    
        public void endBfs(int x, int  y){
        Queue<Point> q =  new LinkedList<>();
        q.add(new Point(x,y));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i<4; i++){
                int dx = p.x+map[i][0];
                int dy = p.y+map[i][1];
                
                if(dx <  0 || dy < 0 ||  dx>= mapsLength || dy >= mapIndexLength)
                    continue;
                
                if(miro[dx][dy] == 'X' || dp[dx][dy] !=0)
                    continue;
                
                if(miro[dx][dy] == 'E'){
                    dp[dx][dy] = dp[p.x][p.y]+1;
                    break;
                }
                
                dp[dx][dy] = dp[p.x][p.y]+1;
                q.add(new Point(dx,dy));
            }
        }
    }
}