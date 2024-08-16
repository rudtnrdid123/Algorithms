import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] lines = new String[N];
        boolean[] canAdd = new boolean[N];

        for (int i = 0; i < N; i++) {
            lines[i] = br.readLine(); 
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int zeroCount = 0;
            for (int j = 0; j < M; j++) {
                if (lines[i].charAt(j) == '0') {
                    zeroCount++;
                }
            }
            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                canAdd[i] = true;
            }
        }

        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            if (canAdd[i]) {
                int sameCount = 1;
                for (int j = 0; j < N; j++) {
                    if (i != j && lines[i].equals(lines[j])) {
                        sameCount++;
                    }
                }
                maxCount = Math.max(maxCount, sameCount);
            }
        }

        System.out.println(maxCount);
    }
}
