class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int right = 100000;
        int left = 1;
        
        while(left<=right){
            long sum = times[0];
            boolean isTrue = true;
            int cnt = left + (right - left)/2;
            for(int i = 1; i<diffs.length; i++){
                if(cnt >= diffs[i])
                    sum += times[i];
                else{
                    long addtionalSu = (times[i] + times[i-1]) * (diffs[i] - cnt) + times[i];
                    sum += addtionalSu;
                }
                
                if(sum > limit){
                    isTrue = false;
                    break;
                }
            }
            
            if(isTrue && sum <= limit){
                answer = cnt;
                right = cnt - 1;
            }
            else
                left = cnt + 1;
        }
        return answer;
    }
}