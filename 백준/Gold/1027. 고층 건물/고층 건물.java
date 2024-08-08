import java.util.*;
import java.io.*;

class Main {
    public static int[] building;
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        building = new int[N];
        for(int i = 0; i<N; i++){
            building[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, Count(i));
        }
        System.out.println(max);
    }

    public static int Count(int idx){
        int cnt = 0;
        double temp = 0;

        for(int i = idx-1; i>=0; i--){
            double slope =  (double)(building[idx] - building[i]) / (idx - i);
            if(i == idx-1 || temp > slope){
                temp = slope;
                cnt++;
            }
        }

        for(int i = idx+1; i<N; i++){
            double slope = (double)(building[idx]-building[i]) / ( idx - i);
            if(i == idx+1 || temp < slope){
                temp = slope;
                cnt++;
            }
        }
        return cnt;
    }
}