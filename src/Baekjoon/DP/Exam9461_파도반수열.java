package Baekjoon.DP;

import java.io.*;

//5시 4분 시작 5시 31분 종료
public class Exam9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        long dp[] = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = dp[2] + dp[3];
        dp[5] = dp[4];
        for(int i = 6; i < dp.length; ++i){
            dp[i] = dp[i - 5] + dp [i - 1];
        }

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[N] + "\n"));
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
