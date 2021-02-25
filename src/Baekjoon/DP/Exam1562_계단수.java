package Baekjoon.DP;

import java.io.*;

public class Exam1562_계단수 {
    public static final int MOD = 1000000000;
    public static int dp[][][];
    public static int N, ANS;
    public static int VISIT = 1 << 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* dp[i][j][k]
        dp[2][3][28] = 2자리 숫자 중, 마지막이 3으로 끝나면서,
        0000011100(= 28)에 마킹된 숫자들을 사용한 계단의 개수 => (23, 43) => 2개 */
        dp = new int[101][10][VISIT];

        N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(calc()) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static long calc(){
        long sum = 0;
        int i, j , k, bit;
        //i = 자릿수 j = 마지막에 끝나는 수 k = 마킹된 숫자들
        //자릿수가 n 일 때, 모든 숫자를 사용했으면 (1023) 1로 값을 넣어주고, 아니면 0을 넣는다.
        //이를 비트 마스킹이라고 한다.

        for(i = 1; i < 10; i++)
            //한 자릿수, 마지막 끝나는 수 = i,
            // 반복문을 돌면서 0000000010 (1) => 0000000100 (2) => 0000001000 (3) => ...을 체크
            dp[1][i][1 << i] = 1;

        //i = 자릿수 j = 마지막에 끝나는 수 k = 마킹된 숫자들
        for(i = 2; i <= N; i++){
            for(j = 0; j <= 9; j++){
                for(k = 0; k < VISIT; k++){
                    bit = k | (1 << j); // k는 1(실제 0), 2(싧제 1), 4(실제 2), 8...와 비트로 비교된다

                    // 현재 숫자의 길이 N
                    // 즉 N-1길이의 숫자 + 숫자 a (마킹상태 k)

                    //N-1 자리 숫자중, a-1로 끝나면서 k 상태인 계단수의 개수
                    int zero = 0 < j ? dp[i-1][j-1][k] : 0;
                    //N-1 자리 숫자중, a+1로 끝나면서 k 상태인 계단수의 개수
                    int nine = j < 9 ? dp[i-1][j+1][k] : 0;

                    dp[i][j][bit] = (dp[i][j][bit] + (zero + nine) % MOD) % MOD;
                }
            }
        }

        for (i = 0; i < 10; i++){
            sum = (sum + dp[N][i][VISIT - 1]) % MOD;
        }
        return sum;
    }
}
