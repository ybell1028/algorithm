package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Exam1003 {
    public static int T;

    public static int memo[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        memo = new int[41][3];

        memo[0][0] = 1;
        memo[1][1] = 1;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; ++i){
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            bw.write(String.valueOf(memo[N][0] + " " + memo[N][1] + "\n"));
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static int fibonacci(int n){
        if(n <= 1) return n;

        if(memo[n][2] != 0) return memo[n][2];

        memo[n][2] = fibonacci(n - 1) + fibonacci(n - 2);
        memo[n][0] = memo[n - 1][0] + memo[n - 2][0];
        memo[n][1] = memo[n - 1][1] + memo[n - 2][1];

        return memo[n][2];
    }
}
