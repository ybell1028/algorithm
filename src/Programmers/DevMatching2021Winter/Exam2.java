package Programmers.DevMatching2021Winter;

import java.util.*;

public class Exam2 {
    static class Solution {
        String[] DAYS = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        public int solution(int leave, String day, int[] holidays) {
            int n = -1;
            for(int i = 0; i < DAYS.length; ++i){
                if(DAYS[i].equals(day)) {
                    n = i;
                    break;
                }
            }
            boolean[] hol = new boolean[31];
            for(int i = 1; i < 31; ++i){
                if(DAYS[n].equals("SAT") || DAYS[n].equals("SUN")) {
                    hol[i] = true;
                }
                if(n % 6 == 0) n = 0;
                else n++;
            }

            for(int val : holidays){
                hol[val] = true;
            }

            int answer = Integer.MIN_VALUE;

            int p0 = 1;
            int p1 = 2;

            int rest = 0; // 쉴 수 있는 날
            if(hol[p0]) rest++;
            if(hol[p1]) rest++;


            boolean flag = false;
            while (p0 < p1) {
                if (!flag && (p1 - p0 + 1 - rest) <= leave) {
                    answer = Math.max(answer, p1 - p0 + 1);
                    if (p1 < 30) {
                        p1++;
                        if (hol[p1]) rest++;
                    }
                    flag = true;
                }
                else if (p0 < 30) {
                    if (hol[p0]) rest--;
                    p0++;
                    flag = false;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] holidays0 = {6, 21, 23, 27, 28};
        s.solution(4, "FRI", holidays0);
    }
}
