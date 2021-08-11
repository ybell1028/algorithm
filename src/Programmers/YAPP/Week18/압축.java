package Programmers.YAPP.Week18;

import java.util.*;

public class 압축 {
    class Solution {
        public int[] solution(String msg) {
            List<Integer> list = new LinkedList<>();
            LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
            Stack<String> stack = new Stack<>();

            for(int i = 0; i < 26; ++i){
                char c = (char)(65 + i);
                lhm.put(String.valueOf(c), i + 1);
            }

            int len = msg.length();
            int start = 0;
            int idx = 26;
            int i = start + 1;
            while(i <= len) {
                String key = msg.substring(start, i);
                if(lhm.get(key) != null){
                    if(i == len){
                        list.add(lhm.get(key));
                        break;
                    }
                    stack.push(key);
                    i++;
                } else {
                    lhm.put(key, ++idx);
                    String word = stack.pop();
                    list.add(lhm.get(word));
                    start += word.length();
                    i = start + 1;
                }
            }

            int[] result = list.stream().mapToInt(in -> in).toArray();
            return result;
        }
    }
}