import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(hansu(Integer.parseInt(br.readLine())));
    }
    public static int hansu(int N){
        int cnt = 99;
        if(N<100){
            return N;
        }
        else{
            for(int i = 100; i<=N; i++){
                int hun = i/100;
                int ten = (i/10)%10;
                int one = i%10;

                if((hun - ten) == (ten - one))
                    cnt++;
            }
        }
        return cnt;
    }
}