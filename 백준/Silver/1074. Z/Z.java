import java.io.*;
import java.util.*;

class Main {
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int line = (int)Math.pow(2,N);
        Find(line,r,c);
        System.out.println(cnt);
    }

    public static void Find(int line, int r, int c){
        int halfLine = line/2;
        int firstSu = (int)Math.pow(line,2)/4;

        if(line == 1)
            return;
        
        if(r < halfLine && c < halfLine){
            cnt += 0;
            Find(line/2, r, c);
        }
        else if(r < halfLine && c >= halfLine){
            cnt += firstSu;
            Find(line/2, r, c-line/2);
        }
        else if(r >= halfLine && c < halfLine){
            cnt += firstSu*2;
            Find(line/2, r-line/2, c);
        }
        else{
            cnt += firstSu*3;
            Find(line/2, r-line/2, c-line/2);
        }
    }
}