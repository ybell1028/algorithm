package Programmers.SkillCheck;
import java.util.Arrays;
public class level1_1 {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);
            int i;
            for(i = 0; i < d.length; ++i){
                if(d[i] > budget) {
                    break;
                }
                budget -= d[i];
            }
            answer = i;
            return answer;
        }
    }
}
