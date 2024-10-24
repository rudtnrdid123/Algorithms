import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int idLeng = id_list.length;
        int[] answer = new int[idLeng];
        String[] distinctReport = Arrays.stream(report).distinct().toArray(String[]::new);
        int dRLeng = distinctReport.length;
        
        HashMap<String,Integer> map  =  new HashMap<>();
        String[] s1 = new String[dRLeng];
        String[] s2 = new String[dRLeng];
        
        for(int i = 0; i<dRLeng;i++){
            StringTokenizer st  =  new StringTokenizer(distinctReport[i]);
            s1[i] = st.nextToken();
            s2[i] = st.nextToken();
            
            map.put(s2[i],map.getOrDefault(s2[i],0)+1);
        }
        
        for(int i = 0; i<dRLeng;){
            if(map.get(s2[i])>=k){
                for(int j = 0; j<idLeng; j++){
                    if(s1[i].equals(id_list[j])){
                        answer[j]++;
                        break;
                    }
                }
            }
            i++;
        }
    
        return answer;
    }
}