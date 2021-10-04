package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;

public class Exam2003_수들의합2 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        int p1 = 0;
        int p2 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        while (p1 <= N - 1) {
            sum += num[p2];
            if (sum == M) cnt++;
            while (sum >= M) {
                sum -= num[p1++];
                if (sum == M) cnt++;
            }
            if(p1 > p2) p2 = p1;
            else if (p2 == N - 1) {
                while (sum >= M) {
                    sum -= num[p1++];
                    if (sum == M) cnt++;
                }
                break;
            }
            else p2++;
        }

        System.out.println(cnt);
    }
}
