import java.io.*;
import java.util.StringTokenizer;

public class Exam1149 {
    public static int N;
    public static final int COLORS = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int memo[][] = new int[1001][COLORS]; // 집을 칠하는 비용은 1,000보다 작거나 같은 자연수.

        N = Integer.parseInt(br.readLine());

        int cost[][] = new int[N][COLORS];

        for(int i = 0; i < N; i++){
            StringTokenizer costSt = new StringTokenizer(br.readLine());
            for(int j = 0; j < COLORS; j++){ // R(0), G(1), B(2)
                cost[i][j] = Integer.parseInt(costSt.nextToken());
            }
        }

        memo[0][0] = cost[0][0];
        memo[0][1] = cost[0][1];
        memo[0][2] = cost[0][2];

        for(int i = 1; i < N; i++){
            memo[i][0] = min(memo[i-1][1], memo[i-1][2]) + cost[i][0];
            memo[i][1] = min(memo[i-1][0], memo[i-1][2]) + cost[i][1];
            memo[i][2] = min(memo[i-1][0], memo[i-1][1]) + cost[i][2];
        }

        int minimum = Integer.MAX_VALUE;

        for(int i = 0; i < COLORS; i++){
            if(memo[N-1][i] < minimum) minimum = memo[N-1][i];
        }

        bw.write(String.valueOf(minimum + "\n"));

        br.close();
        bw.close();
    }

    public static int min(int a, int b){ return a < b ? a : b; }

}
