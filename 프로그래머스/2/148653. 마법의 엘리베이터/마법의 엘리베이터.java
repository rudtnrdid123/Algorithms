import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(storey > 0){
            list.add(storey % 10);
            storey /= 10;
        }
        
        for(int i = 0; i<list.size(); i++){
            if(list.get(i)==0)
                continue;
            
            if(list.get(i)<5){
                answer+=list.get(i);
            }
            else if(list.get(i)>5){
                if(i <list.size()-1){
                    list.set(i+1,list.get(i+1)+1);
                }else
                    list.add(1);
                answer+=10-list.get(i);
            }
            else {
                if(i<list.size()-1){
                    if(list.get(i+1)>=5)
                        list.set(i+1,list.get(i+1)+1);
                }
                answer+=5;
            }
            System.out.println(answer);
        }
        
        return answer;
    }
}
