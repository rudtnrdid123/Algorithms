import java.util.*;
import java.io.*;

class Main {
    public static BufferedReader br;
    public static int N,M;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];

        FillArray(arr1);
        FillArray(arr2);

        int count = 0;
        for(int i = 0; i<N-2; i++){
            for(int j = 0; j<M-2;j++){
                if(arr1[i][j] != arr2[i][j]){
                    reverse(arr1,i,j);
                    count++;
                }      
            }
        }

        boolean changeYN = Arrays.deepEquals(arr1,arr2);
        if(!changeYN)
            count = -1;
        System.out.println(count);
    }

    public static void FillArray(int[][] arr) throws IOException {
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            for(int j = 0; j<M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
    }

    public static void reverse(int[][] arr, int row, int col){
        for(int i = row; i<row+3; i++){
            for(int j = col; j<col+3; j++){
                arr[i][j] = 1 - arr[i][j];
            }
        }
    }
}