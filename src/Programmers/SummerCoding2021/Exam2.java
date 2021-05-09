package Programmers.SummerCoding2021;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Exam2 {
    static class Solution {
        public static final int LEN = 10001;
        static PriorityQueue<Guest>[] lift = new PriorityQueue[LEN];
        public int[] solution(int[] t, int[] r) {
            List<Guest> gList = new ArrayList<>();
            int[] answer = new int[t.length];
            for (int i = 0; i < LEN; ++i) {
                lift[i] = new PriorityQueue<>();
            }
            for (int i = 0; i < t.length; ++i) {
                gList.add(new Guest(i ,t[i], r[i]));
            }
            for (int i = 0; i < t.length; ++i) {
                lift[t[i]].add(gList.get(i)); // 언제 도착하는지
            }
            int i;
            int idx = 0;
            for(i = 0; i < LEN - 1 && idx < t.length; ++i){
                if(lift[i] != null && !lift[i].isEmpty()){
                    answer[idx++] = lift[i].poll().idx;
                    PriorityQueue<Guest> next = search(i);
                    while(!lift[i].isEmpty()){
                        next.add(lift[i].poll());
                    }
                }
            }

            for(int a : answer)
                System.out.println(a);
            return answer;
        }

        public PriorityQueue<Guest> search (int start){
            for(int i = start + 1; i < LEN; ++i){
                if(lift[i] != null) return lift[i];
            }
            return null;
        }

        public class Guest implements Comparable<Guest>{
            public int idx; //인덱스
            public int num; // 번호
            public int r; // 랭크

            public Guest(int idx, int num, int r) {
                this.idx = idx;
                this.num = num;
                this.r = r;
            }

            @Override
            public int compareTo(Guest o) {
                if (this.r - o.r == 0) return this.idx - o.idx;
                return this.r - o.r;
            }
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            int[] t = {7,6,8,6,1};
            int[] r = {0,1,2,1,3};
            s.solution(t, r);
         }
    }
}
