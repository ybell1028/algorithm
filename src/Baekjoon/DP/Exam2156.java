package DP;

import java.io.*;

public class Exam2156 {
    public static int N;
    public static int MAX = 0;
    public static int[] wine;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        wine = new int[N + 1];
        dp = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < 3 && i < N + 1; i++){
            if(i == 1) dp[i] = wine[i];
            else dp[i] = wine[i - 1] + wine[i];
        }

        for (int i = 3; i < N + 1; i++) {
            dp[i] = max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]);
            dp[i] = max(dp[i - 1], dp[i]);
        }

        for(int i = N; i >= 0; --i){
            MAX = max(MAX, dp[i]);
        }

        bw.write(String.valueOf(MAX + "\n"));
        bw.flush();

        br.close();
        bw.close();
    }

    public static int max(int a, int b) { return a > b ? a : b; }
}
