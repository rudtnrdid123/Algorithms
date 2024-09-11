class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoLen = convertTime(video_len);
        int posTime = convertTime(pos);
        int opStart = convertTime(op_start);
        int opEnd = convertTime(op_end);
        
        for(int i = 0; i<commands.length; i++){
            if(opStart <= posTime && posTime <= opEnd){
                posTime = opEnd;
            }
            if(commands[i].equals("next")){
                if(videoLen - posTime < 10){
                    posTime = videoLen;
                }else
                    posTime += 10; 
            }
            else{
                if(posTime < 10){
                    posTime = 0;
                }else
                    posTime -= 10;
            }
            if(opStart <= posTime && posTime <= opEnd){
                posTime = opEnd;
            }
        }
        System.out.println(posTime);
        return convertString(posTime);
    }
    
    public int convertTime(String time){
        String[] s = time.split(":");
        int minute = Integer.parseInt(s[0]);
        int second = Integer.parseInt(s[1]);
        
        return minute * 60 + second;
    }
    
    public String convertString(int time){
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[2];
        
        arr[0] = Integer.toString(time/60);
        arr[1]= Integer.toString(time%60);
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i].length() == 1)
                arr[i] = "0" + arr[i];
        }

        sb.append(arr[0]).append(":").append(arr[1]);
        
        return sb.toString();
    }
}