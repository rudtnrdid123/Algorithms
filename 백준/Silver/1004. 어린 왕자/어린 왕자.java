import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb  = new StringBuilder();
        
        for(int i = 0; i<t; i++){
            StringTokenizer st  = new StringTokenizer(br.readLine());
            int x1  = Integer.parseInt(st.nextToken());
            int y1  = Integer.parseInt(st.nextToken());
            int x2  = Integer.parseInt(st.nextToken());
            int y2  = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            int cnt =  0;
            
            for(int j = 0; j<n; j++){
                boolean start = false;
                boolean end = false;
                st = new StringTokenizer(br.readLine());
                int rx = Integer.parseInt(st.nextToken());
                int ry = Integer.parseInt(st.nextToken());
                int rr = Integer.parseInt(st.nextToken());

                if(Math.pow((x1-rx),2) + Math.pow((y1-ry),2) <= Math.pow(rr,2)){
                    cnt++;
                    start = true;
                }
                if(Math.pow((x2-rx),2) + Math.pow((y2-ry),2) <= Math.pow(rr,2)){
                    cnt++;
                    end = true;
                }

                if(start && end)
                    cnt-=2;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}