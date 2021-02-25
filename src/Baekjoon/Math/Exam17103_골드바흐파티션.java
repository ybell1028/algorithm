package Baekjoon.Math;

import java.io.*;

public class Exam17103_골드바흐파티션 {

    public static int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isNotPrime = new boolean[MAX];

        for(int i = 2; i <= Math.sqrt(MAX); i++){
            for(int j = 2; i * j < MAX; j++){ // 소수가 아닌 수를 모두 true로 바꾸는 작업
                if(isNotPrime[i * j] == true) continue;
                isNotPrime[i * j] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j = 2; j <= N / 2; j++) { //  두 소수의 순서만 다른 것은 같은 파티션이다. 고로 j <= N/2
                if (isNotPrime[j]) continue;
                else {
                    if (!isNotPrime[N - j]) cnt++;
                    else continue;
                }
            }
            bw.write(String.valueOf(cnt + "\n"));
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
