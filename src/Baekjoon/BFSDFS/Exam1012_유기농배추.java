package Baekjoon.BFSDFS;

import java.io.*;
import java.util.StringTokenizer;

public class Exam1012_유기농배추 {
    public static int T, M, N, K;
    /* T - 테스트 케이스
    M - 배추밭 가로길이
    N - 배추밭 세로길이
    K - 배추가 심어져 있는 위치의 개수
    */

    /*
    1 0 0 0 0 0 0 0
    1 1 0 0 0 0 0 0
    0 0 0 0 1 0 0 0
    0 0 0 0 1 0 0 0
    0 0 1 1 0 1 0 0
    0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0
    0 0 0 0 1 1 1 0
    0 0 0 0 1 1 1 0
    0 0 0 0 1 1 1 0
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = 0;
        T = Integer.parseInt(br.readLine());

        while (t < T) {
            StringTokenizer stMNK = new StringTokenizer(br.readLine());

            M = Integer.parseInt(stMNK.nextToken());
            N = Integer.parseInt(stMNK.nextToken());
            K = Integer.parseInt(stMNK.nextToken());

            int[][] farm = new int[M][N];

            for (int i = 0; i < K; i++) {
                StringTokenizer stmn = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(stmn.nextToken());
                int n = Integer.parseInt(stmn.nextToken());
                farm[m][n] = 1;
            }

            bw.write(String.valueOf(solve(farm) + "\n"));

            t++;
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 상하좌우

    public static int solve(int[][] farm) {
        int m = farm.length;
        int n = farm[0].length;
        int cnt = 0;

        int[][] cab = new int[m][n]; // 양배추의 위치

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[][] visited = new int[m][n];
                if(dfs(farm, visited, cab, i, j)) cnt++;
            }
        }

        return cnt;
    }

    public static boolean dfs(int[][] farm, int[][] visited, int[][] cab, int m, int n) {
        if (m < 0 || m >= M || n < 0 || n >= N) return false;
        if (visited[m][n] == 1) return false;
        visited[m][n] = 1;

        if (cab[m][n] == 1) return false;
        cab[m][n] = 1;

        if (farm[m][n] == 0) return false; // 시작점에 양배추가 없다면 false 반환

        for(int dir[] : dirs){
            int m1 = dir[0] + m;
            int n1 = dir[1] + n;

            dfs(farm, visited, cab, m1, n1);
        }

        return true;
    }
}
