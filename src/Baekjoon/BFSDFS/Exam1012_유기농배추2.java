package Baekjoon.BFSDFS;

import java.io.*;
import java.util.StringTokenizer;

public class Exam1012_유기농배추2 {
    public static int T, M, N, K;
    /* T - 테스트 케이스
    M - 배추밭 가로길이
    N - 배추밭 세로길이
    K - 배추가 심어져 있는 위치의 개수
    */
    public static int cnt = 0;
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

        // 이 문제의 Point 1. 백트래킹 없는 방문 배열 cab[][]
        // 아래의 2중 for문으로 지도 전체를 탐색하며 dfs를 실행함으로써 영역의 갯수를 세어준다.
        // dfs 재귀가 이어지면 해당 영역이 계속 이어지는 것이고 주변을 전부 탐색해도 벽에 가로막히거나 땅이 없는 등
        // 더이상 탐색을 진행할 수 없다는 뜻이므로 재귀가 종료된다 -> 하나의 영역이 존재한다.
        int[][] cab = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(farm, cab, i, j)) cnt++;
            }
        }

        return cnt;
    }

    public static boolean dfs(int[][] farm, int[][] cab, int m, int n) {
        if (m < 0 || m >= M || n < 0 || n >= N) return false;

        // 이 문제의 Point 2. 이미 방문 했다면 return
        // 이로 인해 solve의 이중 for문이 간결해진다.
        if (cab[m][n] == 1) return false;
        cab[m][n] = 1; // 방문 기록

        if (farm[m][n] == 0) return false;

        for(int dir[] : dirs){
            int m1 = dir[0] + m;
            int n1 = dir[1] + n;

            dfs(farm, cab, m1, n1);
        }
        return true;
    }
}