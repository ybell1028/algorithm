package Programmers.YAPP.Week15;

import java.util.*;
import java.util.stream.Collectors;

public class 뉴스클러스터링 {
    static class Solution {
        public int solution(String str1, String str2) {
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            Map<String, Integer> mapA = new HashMap<>();
            Map<String, Integer> mapB = new HashMap<>();

            seperate(mapA, str1);
            seperate(mapB, str2);

            Set<String> union = new HashSet<>();
            union.addAll(mapA.keySet());
            union.addAll(mapB.keySet());

            Set<String> intersect = new HashSet<>();
            intersect.addAll(mapA.keySet());
            intersect.retainAll(mapB.keySet());

            int inter = 0;
            int uni = 0;

            for(String element : intersect){
                inter += Math.min(mapA.getOrDefault(element, 0), mapB.getOrDefault(element, 0));
            }
            for(String element : union){
                uni += Math.max(mapA.getOrDefault(element, 0), mapB.getOrDefault(element, 0));
            }

            double answer;
            if(inter == 0 && uni == 0) answer = 65536;
            else answer = (double)inter / uni * 65536;

            return (int) answer;
        }

        private void seperate(Map<String, Integer> map, String str) {
            for (int i = 0; i < str.length() - 1; ++i) {
                String key = str.substring(i, i + 2);
                if(!key.matches("^[a-z]*$")) continue;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("E=M*C^2", "e=m*c^2"));
    }
}