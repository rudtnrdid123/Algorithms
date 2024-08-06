import java.util.*;
import java.io.*;

class Main {
    public static String answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        answer = br.readLine();
        for(int i = 0; i<n-1; i++){
            String str = br.readLine();
            compare(answer,str);
        }
        sb.append(answer);
        System.out.println(sb.toString());
    }

    public static void compare(String s1, String s2){
        String[] arr1 = s1.split("");
        String[] arr2 = s2.split("");
        answer = "";
        
        for(int i = 0; i<arr1.length; i++){
            if(arr1[i].equals(arr2[i]))
                answer += arr1[i];
            else
                answer += "?";
        }
    }
}