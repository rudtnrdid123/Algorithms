import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes,(o1,o2)->(o1[0]-o2[0]));
        int minValue = routes[0][1];
        
        for(int i = 1; i<routes.length; i++){
            if(minValue < routes[i][0]){
                minValue = routes[i][1];
                answer++;
            }
            else{
                if(minValue > routes[i][1]){
                    minValue = routes[i][1];
                }
            }
        }
        return answer;
    }
}