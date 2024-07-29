class Solution {
    public int[] solution(int n) {
        int[] answer;
        int[][] matrix = new int[n][n];
        
        if(n == 1){
            answer = new int[]{1};
            return answer;
        }
        int len = n*(n+1)/2;
        answer = new int[len];
        int num = 1;
        int x = -1;
        int y = 0;

        for(int i = 0; i<n; i++){
            if(num > len)
                break;
            for(int j = i; j<n; j++){
                if(i % 3 == 0)
                    x++;
                else if(i % 3 ==1)
                    y++;
                else{
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }
        
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] != 0)
                    answer[cnt++] = matrix[i][j];
            }
            if(cnt == len-1)
                break;
        }
        return answer;
    }
}