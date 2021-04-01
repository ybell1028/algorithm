package Baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수 N
        int M = Integer.parseInt(st.nextToken()); // 집으로 가져가려고 하는 나무의 길이 M

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            int key = Integer.parseInt(st.nextToken());
            tm.put(key, tm.getOrDefault(key, 0) + 1);
        }

        long start = 0;
        long end = tm.lastKey();
        long sum;
        long H;
        while (start <= end) {
            sum = 0;
            H = (start + end) / 2;
            for(Map.Entry entry : tm.entrySet()){
                if((Integer) entry.getKey() > H)
                    sum += (Integer) entry.getValue() * ((Integer) entry.getKey() - H);
            }
            if (sum >= M) {
                start = H + 1;
            } else {
                end = H - 1;
            }
        }

        System.out.println(end);

        br.close();
    }
}
