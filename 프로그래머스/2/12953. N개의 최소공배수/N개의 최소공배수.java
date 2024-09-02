import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int gcd = GCD(arr[0],arr[1]);
        int lcm = arr[0]*arr[1]/gcd;
        
        for(int i = 2; i<arr.length; i++){
            gcd = GCD(lcm,arr[i]);
            lcm = lcm*arr[i]/gcd;
        }
        return lcm;
    }
    
    public int GCD(int num1, int num2){
        if(num2%num1 == 0)
            return num1;
        return GCD(num2%num1,num1);
    }
}