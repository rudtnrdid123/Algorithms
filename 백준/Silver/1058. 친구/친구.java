import java.util.*;
import java.io.*;

class Main {
    public static int N;
    public static int[][] friends;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new int[N][N];
        
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            char[] arr = s.toCharArray();
            for(int j = 0; j<N; j++){
                if(arr[j] == 'Y')
                    friends[i][j] = 1;
            }
        }
        
        int max =  0;
        for(int i = 0; i<N; i++){
            max = Math.max(max,bfs(i));
        }
        System.out.println(max);
    }
    
    public static int bfs(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        int level = 0;

        while(!q.isEmpty() && level<2){
            int levelSize = q.size();
            for(int i = 0; i<levelSize; i++){
                int current = q.poll();
                for(int j = 0; j<N; j++){
                    if(friends[current][j] == 1 && !visited.contains(j)){
                        q.offer(j);
                        visited.add(j);
                    }
                }
            }
            level++;
        }
        return visited.size()-1;
    } 
}