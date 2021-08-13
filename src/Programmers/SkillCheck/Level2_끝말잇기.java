package Programmers.SkillCheck;

import java.util.*;

public class Level2_끝말잇기 {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] result = {0, 0};
            int len = words.length;
            boolean failed = false;
            HashMap<String, Integer> set = new HashMap<>();

            for(int i = 1; i < len; ++i){
                set.put(words[i - 1], 0);
                if(set.get(words[i]) != null) {
                    result[0] = i % n + 1;
                    result[1] = i / n + 1;
                    System.out.println(words[i]);
                    failed = true;
                    break;
                }
            }
            if(!failed){
                for(int i = 1; i < len; ++i){
                    if(!words[i - 1].substring(words[i - 1].length() - 1).equals(words[i].substring(0, 1))){
                        result[0] = i % n + 1;
                        result[1] = i / n + 1;
                        break;
                    }
                }
            }
            return result;
        }
    }
}
