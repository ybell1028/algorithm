package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam2869_달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A, B, V;

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        int result;
        int pd = A - B; // 미끄러지는 경우
        int remain = V - A; // 출발해서 미끄러지지 않는 경우
        if(remain <= 0){
            result = 1;
        }
        else if(A > V - pd){
            result = 2;
        } else {
            result = remain / pd + 1;
        }

        System.out.println(result);
    }
}
