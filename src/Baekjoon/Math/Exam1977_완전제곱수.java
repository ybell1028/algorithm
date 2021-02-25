package Baekjoon.Math;

// 소요시간 16분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Exam1977_완전제곱수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M, N;

        // M과 N은 10000이하의 자연수이며 M은 N보다 같거나 작다.

        M = Integer.parseInt(br.readLine()); // 이상
        N = Integer.parseInt(br.readLine()); // 이하
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int last = 0;
        for(int i = 100; i >= 1; --i){
            int sqr = i * i;
            if(sqr > N) continue;
            if(sqr < M) break;
            queue.add(sqr);
        }
        int size = queue.size();
        if(size == 0){
            System.out.println(-1);
        } else {
            for(int i = 0; i < size; i++){
                if(queue.size() == 1){
                    last = queue.poll();
                    sum += last;
                    break;
                }
                sum += queue.poll();
            }

            System.out.println(sum);
            System.out.println(last);
        }
    }
}
