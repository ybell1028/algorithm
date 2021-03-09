package Baekjoon.Math;

import java.io.*;
import java.util.ArrayList;

//4시 12분 시작 4시 45분 종료
public class Exam9020_골드바흐의추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        boolean[] notPrime = new boolean[10001];
        ArrayList<Integer> goldbach;

        notPrime[1] = true;

        for(int i = 2; i <= 10000; ++i){
            for(int j = 2; j <= Math.sqrt(i); ++j){
                if(i % j == 0){
                    notPrime[i] = true;
                    break;
                }
            }
        }

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            if(!notPrime[n / 2]) {
                bw.write(String.valueOf(n / 2) + " " + String.valueOf(n / 2) + "\n");
            } else {
                goldbach = new ArrayList<>();
                for(int i = 2; i <= n; ++i){
                    if(!notPrime[i]) goldbach.add(i); // 소수면 goldbach에 넣는다.
                }
                int left = 0;
                int right = goldbach.size() - 1;

                int num1 = 0, num2 = 0;
                int sum;
                while(left < right){
                    sum = goldbach.get(left) + goldbach.get(right);
                    if(sum == n){
                        num1 = goldbach.get(left++);
                        num2 = goldbach.get(right--);
                    } else if(sum > n) {
                        right--;
                    } else {
                        left++;
                    }
                }
                bw.write(String.valueOf(num1) + " " + String.valueOf(num2) + "\n");
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
