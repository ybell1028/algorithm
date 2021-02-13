package Programmers.SkillCheck;

public class level2_124나라의숫자 {
    class Solution {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            while(n >= 1){
                int mod = n % 3;
                n /= 3;
                if(mod == 0){
                    sb.append("4");
                    if(n <= 1) break;
                    n--;
                } else {
                    sb.append(Integer.toString(mod));
                }
            }

            return sb.reverse().toString();
        }
    }
}
