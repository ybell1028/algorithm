package Programmers.WeeklyChallenge;

import java.util.*;

public class 복서정렬하기_6주차 {
    class Solution {
        class Boxer implements Comparable {
            public int num; // 번호
            public int wei; // 몸무게
            public double rate; // 승률
            public int heavy; // 자신보다 몸무게가 무거운 복서를 이긴 횟수

            Boxer(int num, int wei, double rate, int heavy) {
                this.num = num;
                this.wei = wei;
                this.rate = rate;
                this.heavy = heavy;
            }

            @Override
            public int compareTo (Object obj) {
                Boxer boxer = (Boxer)obj;

                //-1 쪽을 먼저 올림
                if(rate != boxer.rate) {
                    if(rate < boxer.rate) return 1;
                    else return -1;
                }
                else if(heavy != boxer.heavy) return boxer.heavy - heavy;
                else if (wei != boxer.wei) return boxer.wei - wei;
                else return num - boxer.num;
            }
        }

        PriorityQueue<Boxer> pq = new PriorityQueue<>();

        public int[] solution(int[] weights, String[] head2head) {
            int len = weights.length;
            for(int i = 0; i < len; ++i) {
                double rate = 0.0;
                int heavyCnt = 0;
                int winCnt = 0;
                double round = 0;
                if(head2head[i].contains("W") || head2head[i].contains("L")) {
                    String[] head = head2head[i].split("");
                    for(int j = 0; j < head.length; ++j){
                        if(head[j].equals("W") || head[j].equals("L")) round++;
                        if(i != j && head[j].equals("W")) {
                            if(weights[i] < weights[j]) heavyCnt++;
                            winCnt++;
                        }
                    }
                    rate = winCnt / round;
                }
                pq.add(new Boxer(i + 1, weights[i], rate, heavyCnt));
            }

            int[] result = new int[pq.size()];
            for(int i = 0; i < result.length; ++i){
                Boxer boxer = pq.poll();
                result[i] = boxer.num;
            }

            return result;
        }
    }
}
