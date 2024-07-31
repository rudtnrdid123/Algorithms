class Solution {
    public int answer = 0,sum = 0; //답, 합
    public int len,targetNum; //numbers길이, 타겟
    public int[] num;
    public int solution(int[] numbers, int target) {
        len =  numbers.length;
        targetNum = target;
        num = numbers;
        
        function(0,sum); // depth = 0, 합은 0
        return answer;
    }
    
    public void function(int depth, int sum){
        if(depth == len){
            if(sum == targetNum){
                answer++;
            }
            return;
        }
            sum += num[depth];
            function(depth + 1, sum);
            sum -= num[depth]*2;
            function(depth + 1, sum);
    }
}