package Programmers.코딩테스트고득점Kit.Greedy;

import java.util.Deque;
import java.util.LinkedList;

//너무 오래걸렸어..
public class 조이스틱 {
    static class Solution {
        public int solution(String name) {
            int nlen = name.length();
            int answer = 0;
            char[] cName = name.toCharArray();

            int[] updown = new int[nlen];
            Deque<Integer> lrD = new LinkedList<>();

            for(int i = 0; i < nlen; ++i){
                if('Z' - cName[i] + 1 < cName[i] - 'A'){
                    updown[i] = 'Z' - cName[i] + 1;
                } else updown[i] = cName[i] - 'A';

                if(updown[i] != 0){
                    lrD.add(i);
                }
            }

            for(int ud : updown){
                answer += ud;
            }

            int start = 0;

            if(!lrD.isEmpty() && lrD.getFirst() == 0) lrD.removeFirst();

            while(!lrD.isEmpty()){
                int front = lrD.getFirst();
                int back = lrD.getLast();

                int fdis = 0;
                if(start > front){
                    fdis = nlen - start + front;
                } else fdis = front - start;

                int bdis = 0;
                if(start > back) bdis = start - back;
                else bdis = nlen - back + start;


                if(fdis > bdis){
                    answer += bdis;
                    start = lrD.removeLast();
                } else {
                    answer += fdis;
                    start = lrD.removeFirst();
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String st1 = "JEROEN";
        String st2 = "JAN";
        String st3 = "AAAN";
        String st4 = "ZZAZZ";
        Solution s = new Solution();
        System.out.println(s.solution(st1));
        System.out.println(s.solution(st2));
        System.out.println(s.solution(st3));
        System.out.println(s.solution(st4));
    }
}
