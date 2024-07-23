import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] roomList = new int[book_time.length][2];
        
        for(int i = 0; i<book_time.length;i++){
            roomList[i][0] = convertToTime(book_time[i][0]);
            roomList[i][1] = convertToTime(book_time[i][1]);
        }
        
        Arrays.sort(roomList,(o1,o2) ->(o1[0] - o2[0]));
        System.out.println(Arrays.deepToString(roomList));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(roomList[0][1]);
        
        for(int i = 1; i<book_time.length;i++){
            
            boolean isAdd = false;
            for(int j = 0; j<list.size(); j++){
                if(list.get(j)+10<= roomList[i][0]){
                    list.set(j,roomList[i][1]);
                    isAdd = true;
                    break;
                }
            }    
            if(!isAdd)
                list.add(roomList[i][1]);
        }
        return list.size();     
    }
    
    public int convertToTime(String start){
        String[] startTime  = start.split(":");
        int startHour =  Integer.parseInt(startTime[0]);
        int startMinute =  Integer.parseInt(startTime[1]);
        
        return startHour*60 + startMinute;
    }
}