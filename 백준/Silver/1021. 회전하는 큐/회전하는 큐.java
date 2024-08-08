import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 1; i<=N; i++){
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            int target =  Integer.parseInt(st.nextToken());
            int idx = dq.indexOf(target);

            if(idx <= dq.size()/2){
                for(int j = 0; j<idx; j++){
                    dq.add(dq.remove());
                    cnt++;
                }
            }
            else{
                for(int j = 0; j<dq.size()-idx; j++){
                    dq.addFirst(dq.removeLast());
                    cnt++;
                }
            }
            dq.remove();
        }
        System.out.println(cnt);
    }
}