import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] dp = new int[park.length][park[0].length];
        HashSet<Integer> numList = new HashSet<>();
        
        for(int i = 0; i<park.length; i++){
            for(int j = 0; j<park[0].length; j++){
                if(park[i][j].equals("-1"))
                    dp[i][j] = 1;
                else
                    dp[i][j] = 0;
            }
        }
        
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                if(dp[i][j] == 0)continue;
                
                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                numList.add(dp[i][j]);
            }
        }
        int max = -1;
        for(int su : mats){
            if(numList.contains(su))
                max = Math.max(max,su);
        }
        return max;
    }
}