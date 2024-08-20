import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long[] merged = new long[2*n];
        
        for(int i = 0; i<n; i++){
            merged[i] = queue1[i];
        }
        for(int i = 0; i<n; i++){
            merged[n+i] =  queue2[i];
        }
        int answer = queue(merged,n,queue1,queue2);
        
        return answer;
    }
    public int queue(long[] arr, int n,int[] q1, int[] q2){
        int result = 0;
        long q1Sum = Arrays.stream(q1).sum();
        long q2Sum = Arrays.stream(q2).sum();
        
        int l1 = 0;
        int r1 = n-1;
        int l2 = n;
        int r2 = 2*n-1;
        
        while(result < 4*n){
            if(q1Sum == q2Sum)
                break;
            
            else if(q1Sum < q2Sum){
                r1 = (r1+1)%arr.length;
                l2 = (l2+1)%arr.length;
                
                q1Sum+=arr[r1];
                q2Sum-=arr[r1];
                
                result++;
            }
            else{
                r2 = (r2+1)%arr.length;
                l1 = (l1+1)%arr.length;
                
                q2Sum+=arr[r2];
                q1Sum-=arr[r2];
                
                result++;
            }
        }
        if(q1Sum != q2Sum)
            result = -1;
        return result;
    }
}