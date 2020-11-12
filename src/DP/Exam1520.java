import java.io.*;
import java.util.StringTokenizer;

public class Exam1520 {
    public static int M, N;
    public static int[][] map;
    public static int[][][] dp;

    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer mnSt = new StringTokenizer(br.readLine());

        M = Integer.parseInt(mnSt.nextToken()); // 세로
        N = Integer.parseInt(mnSt.nextToken()); // 가로

        map = new int[M][N];
        dp = new MN[M][N][4];

        for(int i = 0; i < M; i++){
            StringTokenizer heightSt = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(heightSt.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < 4; k++){ // 상(0) 하(1) 좌(2) 우(3)
                    int i1 = i + dirs[k][0];
                    int j1 = j + dirs[k][1];
                    if(i1 < 0 || i1 > M || j1 < 0 || j1 > N) continue;
                    if(map[i1][j1] < map[i][j]) {
                        dp[i][j][k] = 1;
                    }
                }
            }
        }


    }

    public static class MN{
        int m;
        int n;

        MN(int m, int n){
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