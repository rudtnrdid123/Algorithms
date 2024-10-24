import java.util.Arrays;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n, k);
        String[] arr = str.split("0");
        System.out.println(Integer.toString(32767,2));
        for (String s : arr) {
            if (s.isEmpty() || s.equals("1")) {
                continue; 
            }
            
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
