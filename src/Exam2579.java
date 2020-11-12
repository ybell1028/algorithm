import java.io.*;

public class Exam2579 {
    public static int[] stairs;
    public static int[][] dp;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = stairs[1];
        dp[1][2] = stairs[1];

        for (int i = 2; i <= N; i++) {
            dp[i][1] = dp[i - 1][2] + stairs[i];
            dp[i][2] = max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
        }

        bw.write(String.valueOf(max(dp[N][1], dp[N][2]) + "\n"));

        bw.flush();

        br.close();
        bw.close();
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}