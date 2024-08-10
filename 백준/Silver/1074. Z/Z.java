import java.io.*;
import java.util.*;

class Main {
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int line = 1 << N;
        Find(line, r, c);
        System.out.println(cnt);
    }

    public static void Find(int line, int r, int c) {
        if (line == 1) return;

        int halfLine = line / 2;
        int firstSu = halfLine * halfLine;

        if (r < halfLine && c < halfLine) {
            Find(halfLine, r, c);
        } else if (r < halfLine) {
            cnt += firstSu;
            Find(halfLine, r, c - halfLine);
        } else if (c < halfLine) {
            cnt += firstSu * 2;
            Find(halfLine, r - halfLine, c);
        } else {
            cnt += firstSu * 3;
            Find(halfLine, r - halfLine, c - halfLine);
        }
    }
}
