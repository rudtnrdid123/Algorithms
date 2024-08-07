import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        int count = 0;
        for(int i = 1; i<=N; i++){
            dq.add(i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());
            int index = dq.indexOf(target);

            if(index <= dq.size()/2){
                for(int j =0; j<index; j++){ 
                    dq.addLast(dq.removeFirst());
                    count++;
                }
            }
            else{
                for(int j = 0; j<dq.size()-index; j++){ 
                    dq.addFirst(dq.removeLast());
                    count++;
                }
            }
          dq.remove();      
        }
        System.out.println(count);
    }
}