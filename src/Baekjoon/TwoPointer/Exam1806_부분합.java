package Baekjoon.TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class Exam1806_부분합 {
    static int N, S;
    static int MS = 100_000; // 가장 짧은 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p0 = 0;
        int p1 = 0;
        int sum = 0;
        while(true) {
            if(sum >= S) {
                sum -= arr[p0++];
                MS = Math.min(MS, p1 - p0 + 1);
            } else {
                if (p1 == N) break;
                sum += arr[p1++];
            }
        }
        if(MS == 100_000) MS = 0;
        System.out.println(MS);
    }
}
