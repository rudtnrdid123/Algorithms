import java.util.*;
class Solution
{
    int zisu;
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        zisu = (int)(Math.log(n)/Math.log(2));
        if(a > b)
            answer = bracket(a,b);
        else 
            answer = bracket(b,a);
        
        return answer;
    }
    
    public int bracket(int big, int small){
        int cnt = 0;
        
        while(zisu >= 1){
            cnt++;
            big = (big+1)/2;
            small = (small+1)/2;
            
            if(big == small)
                break;
            zisu--;
        }
        return cnt;
    }
}