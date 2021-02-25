package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam9095_123더하기 {
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            cnt = 0;
            int N = Integer.parseInt(br.readLine());
            plus(0, N);
            System.out.println(cnt);
        }
    }

    public static void plus(int sum, int goal){
        if(sum > goal) return;
        else if (sum == goal){
            cnt++;
            return;
        }
        else{
            for(int i = 1;i <= 3;i++){
                plus(sum + i, goal);
            }
        }
    }
}
