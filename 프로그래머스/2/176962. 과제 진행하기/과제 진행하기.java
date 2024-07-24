import java.util.*;
class Solution {
    static class Task{
        public String name;
        public int startTime;
        public int leftTime;
        
        public Task(String name, int startTime, int leftTime){
            this.name = name;
            this.startTime = startTime;
            this.leftTime = leftTime;
        }  
    }

    public int convert(String start){
        String[] str = start.split(":");
        return Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        ArrayList<Task> list = new  ArrayList<>();
        
        for(int i = 0; i<plans.length; i++){
            int time = convert(plans[i][1]);
            list.add(new Task(plans[i][0],time,Integer.parseInt(plans[i][2])));
        }
        
        Collections.sort(list,(o1,o2) -> (o1.startTime - o2.startTime));
        
        Stack<Task> stack = new Stack<>();
        int time = 0;
        int cnt = 0;
        
        for(int i = 0; i<plans.length; i++){
            Task cur = list.get(i);
            int timeDiff = cur.startTime - time;
            
            while(!stack.isEmpty() && timeDiff>0){
                Task pre = stack.pop();
                if(pre.leftTime <= timeDiff){
                    timeDiff -= pre.leftTime;
                    answer[cnt++] = pre.name;
                }
                else{
                    pre.leftTime -= timeDiff;
                    timeDiff = 0;
                    stack.push(pre);
                }
            }
            stack.push(cur);
            time = cur.startTime;
        }
        while(!stack.isEmpty()){
            Task cur = stack.pop();
            answer[cnt++] = cur.name;
        }
        return answer;
    }
}