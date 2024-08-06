import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++){
            StringTokenizer st = new  StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
   
            int answer = compare(x1,y1,r1,x2,y2,r2);
            System.out.println(answer);
        }
        br.close();
    }

    public static int compare(int x1, int y1, int r1, int x2, int y2, int r2){
        if(x1 == x2 && y1 == y2 && r1 ==  r2)
            return -1;

        int distance = (int)Math.pow((x1-x2),2)+(int)Math.pow((y1-y2),2);
        int inscribe = (int)Math.pow((r1-r2),2);
        int outscribe = (int)Math.pow((r1+r2),2);
        
        if(inscribe < distance && distance < outscribe)
            return 2;

        else if(distance == outscribe || distance == inscribe)
            return 1;

        else
            return 0;
    }
}