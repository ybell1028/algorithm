package DP;

import java.io.*;

public class Exam2156 {
    public static int N;
    public static int MAX = 0;
    public static int[] wine;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        wine = new int[N];
        dp = new int[N][3];

        for(int i = 0; i < N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                aljung(j, 1);
                aljung(j, 2);
            }
        }

        for(int i = N - 1; i >= 0; --i){
            MAX = max(MAX, dp[i][1]);
            MAX = max(MAX, dp[i][2]);
        }

        bw.write(String.valueOf(MAX + "\n"));
        bw.flush();

        br.close();
        bw.close();
    }

    public static void aljung(int m, int n) {
        if(m - n >= 0) {
            if(n == 1){
                dp[m][n] = max(dp[m][n], dp[m - 1][2] + wine[m]);
            } else if(n == 2){
                dp[m][n] = max(dp[m][n],dp[m - 2][1] + wine[m]);
            }
        } else {
            dp[m][n] = wine[m];
        }
    }

    public static int max(int a, int b) { return a > b ? a : b; }
}
