import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] extendedArr = new int[n*2];
        Set<Integer> count = new HashSet<>();
        
        System.arraycopy(elements,0,extendedArr,0,n);
        System.arraycopy(elements,0,extendedArr,n,n);
        
        for(int size = 1; size <= n; size++){
            int sum = 0;
            for(int j = 0; j<size; j++){
                sum += extendedArr[j];
            }
            count.add(sum);
            for(int start = 1; start<n; start++){
                sum = sum - extendedArr[start - 1] + extendedArr[start + size - 1];
                count.add(sum);
            }
        }
        return count.size();
    }
}