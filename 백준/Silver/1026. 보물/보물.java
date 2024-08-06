import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = putArr(a,st);
        st = new StringTokenizer(br.readLine());
        b = putArr(b,st);

        Arrays.sort(a);
        Arrays.sort(b,(o1,o2) -> (o2 - o1));
        
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += a[i]*b[i];
        }
        System.out.println(sum);
    }

    public static Integer[] putArr(Integer[] arr,StringTokenizer st){
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return arr;
    }
}