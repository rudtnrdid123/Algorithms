class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        
        for(int i = n-1; i>=0;){
            if(deliveries[i] ==0 && pickups[i]==0){
                i--;
                continue;
            }
            calcul(cap,deliveries,i);
            calcul(cap,pickups,i);
            
            answer+=(i+1)*2;
        }
        
        return answer+1;
    }
    public void calcul(int cap, int[] arr,int index){
        while(index>=0){
            if(cap>=arr[index]){
                cap-=arr[index];
                arr[index--] = 0;
            }else{
                arr[index] -= cap;
                break;
            }
        }
    }
}