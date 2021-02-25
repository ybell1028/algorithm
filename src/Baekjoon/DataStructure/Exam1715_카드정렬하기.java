package Baekjoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Exam1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        PriorityQueue<Integer> card = new PriorityQueue<>(); // 작은 값이 우선순위가 더 노ㅠ음
        for(int i = 0; i < N; ++i){
             card.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        int val = 0;
        while(!card.isEmpty()){
            if(cnt % 2 == 0) val = card.poll();
            else {
                val += card.poll();
                card.add(val);
                sum += val;
            }
            cnt++;
        }

        System.out.println(sum);
    }
}
