package Baekjoon.DP;

import java.util.Scanner;

public class Exam14495_피보나치비스무리한수열 {
    public static long dp[];
    public static final int MAX_RANGE = 117;

    public static long simFibonacci(int n){
        if(dp[n] == 0){
            dp[n] = simFibonacci(n - 1) + simFibonacci(n - 3);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[MAX_RANGE];
        for(int i = 1; i <= 3; ++i){
            dp[i] = 1;
        }
        System.out.println(simFibonacci(n));
    }
}
