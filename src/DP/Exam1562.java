package DP;

import java.io.*;
import java.util.ArrayList;

public class Exam1562 {
    public static final int MOD = 1000000000;
    public static int dp[][][];
    public static long number = 0;
    public static int N, ANS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        /* dp[i][j][k]
        dp[2][3][28] = 2자리 숫자 중, 마지막이 3으로 끝나면서,
        0000011100(= 28)에 마킹된 숫자들을 사용한 계단의 개수 => (23, 43) => 2개 */
        dp = new int[101][10][1 << 10];

        for(int i = 1; i < 10; i++){
            ANS += dfs(1, i, 1 << i);
            ANS %= MOD;
        }

        bw.write(String.valueOf(ANS) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static int dfs(int idx, int num, int bit){
        number++;
        //idx = 높이 num = 자릿수 bit = 수가 사용되었는지
        //해당 위치에서 이전에 구해 놓은 값이 있으면 바로 사용한다.
        if(dp[idx][num][bit] == 1) return dp[idx][num][bit];

        //높이가 n 일 때, 모든 숫자를 사용했으면 (1023) 1로 값을 넣어주고, 아니면 0을 넣는다.
        //이를 비트 마스킹이라고 한다.
        if(idx == N) return bit == (1 << 10) - 1 ? 1 : 0;

        int res = 0;

        //현재 높이에서 자리수를 확인하고 다음 단계로 넘어간다.
        if(num + 1 < 10) // 9까지만 허용
            res += dfs(idx + 1, num + 1, bit | 1 << (num + 1));
        if(num - 1 >= 0) // 0까지만 허용
            res += dfs(idx + 1, num - 1, bit | 1 << (num - 1));

        //현재 위치의 값을 구했으면, 메모리에 넣고 함수로 리턴해줘서 다른 재귀함수에서 사용할 수 있게 한다.
        return dp[idx][num][bit] = res %= MOD;
    }
}
