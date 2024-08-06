import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String answer = br.readLine();
        StringBuilder result = new StringBuilder(answer);

        for (int i = 1; i < n; i++) {
            String str = br.readLine();
            compare(result, answer, str);
            answer = result.toString(); // 업데이트된 answer로 갱신
        }

        System.out.println(answer);
    }

    public static void compare(StringBuilder result, String s1, String s2) {
        result.setLength(0); // StringBuilder 초기화
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                result.append(s1.charAt(i));
            } else {
                result.append('?');
            }
        }
    }
}
