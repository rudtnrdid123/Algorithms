class Solution {
    int solution(int[][] land) {
        int row = land.length;
        int col = 4;

        for(int i = 1; i<row; i++){
            for(int j = 0; j<col; j++){
                int max = 0;
                for(int k = 0; k<col; k++){
                    if(j!=k)
                        max = Math.max(max,land[i-1][k]);
                }
                 land[i][j] += max;
            }
        }
        
        int answer = 0;
        for(int i = 0; i<col; i++){
            answer = Math.max(answer,land[row-1][i]);
        }
        return answer;
    }
}