package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2485 {
    public static int gcd(int a, int b){
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 가로수의 수

        int[] tree = new int[n];
        int[] gap = new int[n];

        //꼭 가로수가 심어져야하는곳은 가로수 사이 거리가 가장 작은곳
        // 모든 가로수가 같은 간격이 되도록 새로 심어야하는 가로수의 최소수는
        // 간격이 최대공약수여야한다.
        for(int i = 0; i < n; ++i){
            tree[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < n; ++i){
            gap[i] = tree[i] - tree[i - 1];
        }

        int minGap = 100000000;

        for(int i = 2; i < n; ++i){
            int now = gcd(gap[i], gap[i - 1]);
            if(now < minGap) minGap = now;
        }

        int cnt = 0;

        for(int i = 1; i < n; ++i){
            if(gap[i] > minGap) {
                cnt = cnt + (gap[i] / minGap - 1);
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
