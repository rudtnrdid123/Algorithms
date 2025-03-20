import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int[] numXY = new int[2];
        int su = 1;
        int x = n%w !=0 ? (n/w)+1: n/w;
        boolean left = true;
        int[][] arr = new int[x][w];
        
        for(int i = x-1; i>=0; i--){  
            if(left){
                 for(int j = 0; j<w; j++){
                     if(su == num){
                         numXY[0] = i;
                         numXY[1] = j;
                     }
                     if(su > n){
                        arr[i][j] = 0;
                    }else{
                        arr[i][j] = su;
                    }
                     su++;
                 }
                left = false;
            }   
            else{
                 for(int j = w-1; j>=0; j--){
                     if(su == num){
                         numXY[0] = i;
                         numXY[1] = j;
                     }
                     if(su > n){
                        arr[i][j] = 0;
                    }else{
                        arr[i][j] = su;
                    }
                     su++;
                 }
                left = true;
            }   
        }
            
        return arr[0][numXY[1]] == 0 ? numXY[0] : numXY[0] + 1;
    }
}