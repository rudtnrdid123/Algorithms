import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<t; i++){
            StringTokenizer st  = new  StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int data = 1;

            for(int j = 1; j<=b; j++){
                data *= a;
                data%=10;
            }
            if(data == 0)
                sb.append(10).append("\n");
            else
                sb.append(data).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}