package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Exam1520 {
    public static int M, N;
    public static int M2, N2;
    public static int end = 0;
    public static boolean endsign = false;
    public static int[][] map;
    public static MN[][] dp;

    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer mnSt = new StringTokenizer(br.readLine());

        M = Integer.parseInt(mnSt.nextToken()); // 세로
        N = Integer.parseInt(mnSt.nextToken()); // 가로
        M2 = M - 1;
        N2 = N - 1;

        map = new int[M][N];
        dp = new MN[M][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer heightSt = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(heightSt.nextToken());
            }
        }

//        int[][] visited = new int[M][N];
        dfs(map[0][0] + 1, 0, 0);

        bw.write(String.valueOf(end + "\n"));

        bw.flush();

        br.close();
        bw.close();
    }

    public static boolean dfs(int prev, int m1, int n1) {
        int cnt = 0;
        if (m1 < 0 || m1 >= M || n1 < 0 || n1 >= N) return false; // 현재
        if (dp[m1][n1] != null) { // 재활용
            prev = map[m1][n1];
            m1 = dp[m1][n1].getM();
            n1 = dp[m1][n1].getN();
            // 재활용하면 cnt가 그대로잖아 (오류 문제)
            // 아마 첫 사용은 m1 = 3, n1 = 3
        }
        if (map[m1][n1] >= prev) return false; // 항상 높이가 더 낮은 지점으로만 이동
        if (m1 == M - 1 && n1 == N - 1){
            // 여기서 탐색이 끝났으면 끝났다고 알려주는 sign이 있어야함
            end++;
            endsign = true;
            return true;
        }

        for (int k = 0; k < 4; k++) { // 상(0) 하(1) 좌(2) 우(3)
            int m2 = m1 + dirs[k][0]; // 미래
            int n2 = n1 + dirs[k][1]; // 미래
            if(dfs(map[m1][n1], m2, n2)) {
                cnt++;
            }
            if(endsign){
                endsign = false;
                break;
            }
        }
        if (cnt < 2) { // 갈 수 있는 길이 하나뿐이라면?
            dp[m1][n1] = new MN(M2, N2);
        }
        else {
            System.out.println(m1 + " " + n1);
        }
        return true;
    }

    public static class MN {
        int m;
        int n;

        MN(int m, int n) {
            this.m = m;
            this.n = n;
        }

        public int getM() {
            return m;
        }

        public int getN() {
            return n;
        }
    }
}