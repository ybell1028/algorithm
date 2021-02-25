package Baekjoon.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Exam13305_주유소 {
    public static int MAX_RANGE = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시의 수

        long[] dis = new long[MAX_RANGE];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; ++i){
            dis[i] = Long.parseLong(st.nextToken());
        }

        long minFee = 1000000001;
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i){
            long gasFee = Long.parseLong(st.nextToken());
            if(gasFee < minFee) minFee = gasFee;
            sum += dis[i] * minFee;
        }

        System.out.println(sum);

        br.close();
    }
}
