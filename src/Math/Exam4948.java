package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam4948 {
    public static final int RANGE = 123456 * 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] prime = new int[RANGE + 1];
        for(int i = 2; i < RANGE + 1; ++i){ // 소수를 구하는 방법 = 루트 n 까지 나눠서 나머지가 0이 안나오면 소수
            int limit = (int)Math.sqrt((double)i);
            boolean p = true;
            for(int j = 2; j <= limit; ++j){
                if(i % j == 0){
                    p = false;
                    break;
                }
            }
            if(p) prime[i]++;
            prime[i] += prime[i - 1];
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            System.out.println(prime[2 * n] - prime[n]);
        }
    }
}
