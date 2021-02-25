package Programmers.코딩테스트고득점Kit.Hash;

import java.util.Arrays;

public class 완주하지못한선수 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            Arrays.sort(participant);
            Arrays.sort(completion);
            int nocom = 0;
            for(int i = 0; i < completion.length; ++i){
                if(!participant[i].equals(completion[i])){
                    nocom = i;
                    break;
                }
            }

            StringBuilder sb = new StringBuilder("sss");
            sb.length();
            if(nocom == 0) {
                nocom = completion.length;
            }
            String answer = participant[nocom];
            return answer;
        }
    }
}
