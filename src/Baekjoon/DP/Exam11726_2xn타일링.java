package Baekjoon.DP;

import java.io.*;

public class Exam11726_2xn타일링 {
    public static int n;
    public static int d[];

    public static int topDown (int n) {
        if (n == 0 || n == 1) return 1;
        if (d[n] > 0) return d[n];

        d[n] = topDown(n-2) + topDown(n-1);
        d[n] %= 10007; // 여기서 10007 나머지계산을 하지 않으면, 이전의 d[n] 도 값이 전부 틀려져버리기 때문에 d[n]을 구할 때 마다 10007의 나머지계산을 진행 후에 저장

        return d[n];
    }

    //BOTTOM-UP
//    public static int bottomUp (int n) {
//        d[0] = 1;
//        if (n > 0) d[1] = 1;
//        for (int i=2; i<=n; i++) {
//            d[i] = d[i-2] + d[i-1];
//            d[i] %= 10007; // 이 부분도 마찬가지
//        }
//        System.out.println(d[n]);
//        return d[n];
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        d = new int[n + 1];

        bw.write(String.valueOf(topDown(n)));
        bw.flush();
    }
}
