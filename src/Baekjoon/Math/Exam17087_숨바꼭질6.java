package Baekjoon.Math;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam17087_숨바꼭질6 {
    public static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken()); // 동생 수
        int S = Integer.parseInt(st1.nextToken()); // 현재 수빈이 위치

        Queue<Integer> A = new LinkedList<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int dis = Math.abs(S - Integer.parseInt(st2.nextToken()));
            A.add(dis);
        }

        int gd = A.poll();

        for (int i = 0; i < N - 1; i++) {
            gd = gcd(gd, A.poll());
        }

        bw.write(String.valueOf(gd));

        bw.flush();

        br.close();
        bw.close();
    }
}
