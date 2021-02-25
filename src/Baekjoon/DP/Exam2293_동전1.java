package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam2293_동전1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int dp[] = new int[k + 1];

        int[] coin = new int[n]; // 동전의 가치는 100,000보다 작거나 같은 자연수이다.

        for(int i = 0; i < n; ++i){
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for(int i = 0; i < n; ++i){
            for(int j = coin[i]; j <= k; ++j) { //dp
                dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
