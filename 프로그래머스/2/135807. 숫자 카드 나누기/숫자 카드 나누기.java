import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0; 
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int startA = arrayA[0];
        int startB = arrayB[0];
        
        Set<Integer> setA = findDivisors(arrayA, startA);
        Set<Integer> setB = findDivisors(arrayB, startB);

        for(Integer val : setA){
            boolean isFalse = false;
            for(int j = 0; j<arrayB.length;j++){
                if(arrayB[j]%val ==0){
                    isFalse = true;
                    break;
                }
            }
            if(!isFalse)
                answer = Math.max(answer,val);
        }
        
        for(Integer val : setB){
            boolean isFalse = false;
            for(int j = 0; j<arrayA.length;j++){
                if(arrayA[j]%val ==0){
                    isFalse = true;
                    break;
                }   
            } 
            if(!isFalse)
                answer = Math.max(answer,val);
        }

        return answer;
    }
    
    public Set<Integer> findDivisors(int[] arr, int start){
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i<=start; i++){
            if(start%i ==0){
                boolean isAdd = true;
                for(int j = 1; j<arr.length;j++){
                    if(arr[j]%i != 0){
                        isAdd = false;
                        break;
                    }
                }
                if(isAdd)
                    set.add(i);
            }    
        }
        return set;
    }
}