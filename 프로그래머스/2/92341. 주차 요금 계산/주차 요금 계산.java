import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[][] arr = new int[records.length][3];
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            arr[i][0] = convert(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            
            map.putIfAbsent(arr[i][1],new ArrayList<>());
            map.get(arr[i][1]).add(arr[i][0]);
        }
        
        ArrayList<Integer> soltedKeys = new ArrayList<>(map.keySet());
        Collections.sort(soltedKeys);
        
        int[] answer = new int[map.size()];
        int cnt = 0;
        for(int key : soltedKeys){
           List<Integer> l = map.get(key);
            for(int j = 0; j<l.size(); j++){
                if(j%2 ==1)
                    answer[cnt] += l.get(j);
                else
                    answer[cnt] -= l.get(j);
                if(j == l.size()-1 && l.size()%2 == 1)
                    answer[cnt]+=1439;
            }
            cnt++;
        }
        
        for(int i = 0; i<answer.length;i++){
            if(answer[i] <= fees[0]){
                answer[i] = fees[1];
                continue;
            }
            int fee = answer[i] - fees[0];
            if(fee%fees[2]!= 0)
                fee = (fee/fees[2])+1;
            else
                fee/=fees[2];
            answer[i] = fees[1] + fee * fees[3];
        }
        
        return answer;
    }
    
    public int convert(String start){
        String[] str = start.split(":");
        return Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
    }
}