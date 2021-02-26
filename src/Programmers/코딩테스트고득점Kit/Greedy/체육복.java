package Programmers.코딩테스트고득점Kit.Greedy;

import java.util.Arrays;

//54분 소요.. 너무 오래걸린다!!
public class 체육복 {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int[] enable = new int[n + 1];
            Arrays.fill(enable, 1);
            //lost와 reserve 인덱스는 0부터
            //enable 인덱스는 1부터
            for(int i = 0; i < lost.length; ++i){
                enable[lost[i]]--;
            }
            for(int i = 0; i < reserve.length; ++i){
                enable[reserve[i]]++;
            }

            //case1. 자기 앞의 사람에게 빌리는 경우
            //case2 자기 뒤의 사람에게 빌리는 경우
            for(int i = 1; i < n + 1; ++i){
                if(enable[i] > 1){
                    if(i - 1 >= 1 && enable[i - 1] < 1) {
                        enable[i]--;
                        enable[i - 1]++;
                    }
                    else if(i + 1 <= n  && enable[i + 1] < 1){
                        enable[i]--;
                        enable[i + 1]++;
                    }
                }
            }
            int answer = 0;
            for(int i = 1; i < enable.length; ++i){
                if(enable[i] > 0) answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int[] lost = {1};
        int[] reserve = {2};
        Solution s = new Solution();
        System.out.println(s.solution(n, lost, reserve));
    }
}
