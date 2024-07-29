import java.util.*;
class Solution {
    public int[] sales = {10,20,30,40};
    public PriorityQueue<int[]> pq;
    public int[] num;
    
    public int[] solution(int[][] users, int[] emoticons) {
        num = new int[emoticons.length];
        pq = new PriorityQueue<>(new Comparator<int[]>(){
            
            @Override
            public int compare(int[] o1,int[] o2){
               return o1[0] == o2[0] ? o2[1]-o1[1] : o2[0] - o1[0]; 
            }
        });
        
        backtracking(0,users, emoticons);
        return pq.poll();
    }
    
    public void backtracking(int a, int[][] users, int[] emoticons){
        
        if(a == emoticons.length){
            int people = 0;
            int money = 0;
            for(int i = 0; i<users.length; i++){
                int sum = 0;
                for(int j = 0; j<emoticons.length; j++){
                    if(num[j] >= users[i][0])
                        sum+=emoticons[j]*(100-num[j])/100;
                }
                if(sum >= users[i][1])people++;
                else
                    money += sum;
            }
            pq.offer(new int[]{people,money});
            return;
        }
        
        for(int i = 0; i<sales.length; i++){
            num[a] = sales[i];
            backtracking(a+1, users, emoticons);
        }
    }
}