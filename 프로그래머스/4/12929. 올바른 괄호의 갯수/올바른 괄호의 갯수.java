class Solution {
    public int len,nn;
    public int answer = 0;
    public int bracket = 1;
    public int solution(int n) {
        len = n*2;
        nn = n;
        dfs(0,0);
        
        return answer;
    }
    
    public void dfs(int depth, int sum){
                 
        if(depth == len){
            if(sum == 0)
                answer++;
            return;
        }
        if(sum < 0 || sum > nn) return;
        
        dfs(depth + 1,sum+bracket);
        dfs(depth + 1,sum-bracket);
        
    }
}