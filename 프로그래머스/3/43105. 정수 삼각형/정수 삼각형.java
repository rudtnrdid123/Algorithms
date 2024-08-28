class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int row = triangle.length;
        int[][] dp = new int[row][triangle[row-1].length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i<row; i++){
            int col =  triangle[i].length;
            for(int j = 0; j<col; j++){
                if(j == 0)
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j>0 && j<col-1){
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
                }    
                else
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
            }
        }
        int max = 0;
        for(int i = 0; i<triangle[row-1].length; i++){
            max = Math.max(max,dp[row-1][i]);
        }
        
        return max;
    }
}