import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int now = 1;
        
        while(now <= n){
            if(idx >= stations.length || now < stations[idx] - w){
                answer++;
                now += 2*w + 1;
            }else{
                now = stations[idx] + w + 1;
                idx ++;
            }
        }
        
        return answer;
    }
}