package Baekjoon.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합 {
    static int N;
    static int M;
    static int[] combi;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combi = new int[M];
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i){
            num[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);
    }

    static void DFS(int depth, int start) {
        if (depth == M) {
            for (int t : combi) {
                System.out.print(t + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < N; i++) {
                combi[depth] = num[i];
                DFS(depth + 1, i + 1);
            }
        }
    }
}
