package Programmers.코딩테스트고득점Kit.Greedy;

import java.util.Arrays;

//7시 20분 시작 7시 43분 정답
public class 구명보트 {
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int light = 0;
            int heavy = people.length - 1;
            //한번에 최대 두명밖에 탈수 없으니
            //가장 가벼운 사람과 가장 무거운 사람을 담자
            while(light <= heavy){
                if(people[light] + people[heavy] > limit){
                    heavy--;
                    answer++;
                } else {
                    light++;
                    heavy--;
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] people = {70};
        int limit = 100;
        System.out.println(s.solution(people, limit));
    }
}
