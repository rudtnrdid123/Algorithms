import java.util.*;
import java.io.*;

class Main {
    public static int[] buildCost;
    public static ArrayList<Integer>[] list;
    public static int[] inDegree;
    public static int N,K,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            buildCost = new int[N+1];
            list = new ArrayList[N+1];
            inDegree = new int[N+1];
            
            for(int j = 1; j<=N; j++){
                buildCost[j] = Integer.parseInt(st.nextToken());
                list[j] =  new ArrayList<>();
            }

            for(int j = 0; j<K; j++){
                st = new StringTokenizer(br.readLine()); 
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list[from].add(to);
                inDegree[to]++;
            }
            W = Integer.parseInt(br.readLine());
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        int[] currentCost =  new int[N+1];
        for(int i = 1; i<=N; i++){
            if(inDegree[i] == 0){
                currentCost[i] = buildCost[i];
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : list[current]){
                currentCost[next] = Math.max(currentCost[next],currentCost[current]+buildCost[next]);
                inDegree[next]--;

                if(inDegree[next] == 0)
                    q.offer(next);
            }
        }
        
        return currentCost[W];
    }
}