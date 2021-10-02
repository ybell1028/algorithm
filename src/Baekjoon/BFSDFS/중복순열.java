package Baekjoon.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중복순열 {
    static int N;
    static int M;
    static int[] permu;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        permu = new int[M];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i){
            num[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
    }

    static void DFS(int depth) {
        if (depth == M) {
            for (int a : permu) {
                System.out.print(a + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                permu[depth] = num[i];
                DFS(depth + 1);
            }
        }
    }
}
