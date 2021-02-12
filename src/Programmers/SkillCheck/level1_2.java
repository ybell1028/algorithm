package Programmers.SkillCheck;

import java.util.List;

public class level1_2 {
    class Solution {
        public int[] solution(long n) {
            StringBuilder sb = new StringBuilder(Long.toString(n));
            sb.reverse();
            int[] answer = new int[sb.length()];
            for(int i = 0; i < sb.length(); ++i){
                answer[i] = Integer.parseInt(sb.substring(i, i+1));
            }
            return answer;
        }
    }
}
