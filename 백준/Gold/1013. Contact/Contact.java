import java.io.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String pattern = "(100+1+|01)+";
        StringBuilder sb = new  StringBuilder();
        
        for(int  i = 0; i<t; i++){
            String str = br.readLine();
            if(str.matches(pattern))sb.append("YES");
            else
                sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}