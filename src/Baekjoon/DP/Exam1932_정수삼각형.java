package Baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Exam1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] tri = new int[N][N];
        int[][] memo = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer rowSt = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                tri[i][j] = Integer.parseInt(rowSt.nextToken());
            }
        }

        memo[0][0] = tri[0][0];

        for(int i = 1; i < N; i++){ // 2번째 행부터
            for(int j = 0; j <= i; j++){ // j = 1, j = 2
                if(j == 0){
                    memo[i][j] = memo[i - 1][j] + tri[i][j];
                } else if(j == i){
                    memo[i][j] = memo[i - 1][j - 1] + tri[i][j];
                } else {
                    memo[i][j] = max(memo[i - 1][j - 1], memo[i - 1][j]) + tri[i][j];
                }
            }
        }

        int triMax = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            triMax = max(memo[N-1][i], triMax);
        }

        bw.write(String.valueOf(triMax + "\n"));

        bw.flush();

        br.close();
        bw.close();
    }

    public static int max(int a, int b) { return a > b ? a : b;}
}
