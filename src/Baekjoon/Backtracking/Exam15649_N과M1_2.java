package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam15649_N과M1_2 {
    static int N, M;
    static int[] serial = new int[9];
    static boolean[] check = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0);
    }

    private static void dfs(int cnt){
        if(cnt == M){
            for(int i = 0;i < M; i++){
                System.out.print(serial[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!check[i]){
                check[i] = true;
                serial[cnt] = i;
                dfs(cnt + 1);
                check[i] = false;
            }
        }
    }
}
