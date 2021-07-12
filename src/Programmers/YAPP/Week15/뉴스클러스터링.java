package Programmers.YAPP.Week15;

import java.util.*;
import java.util.stream.Collectors;

public class 뉴스클러스터링 {
    static class Solution {
        public int solution(String str1, String str2) {
            //대문자 소문자 차이 무시 -> 모두 소문자로 통일
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            Map<String, Integer> mapA = new HashMap<>();
            Map<String, Integer> mapB = new HashMap<>();

            //다중집합으로 분리하여 Map에 넣어준다
            seperate(mapA, str1);
            seperate(mapB, str2);
            //합칩합과 교집합을 나타네는 union과 intersect는 중복을 허용하지 않는 Set으로 만들어줍니다
            Set<String> union = new HashSet<>();
            //합집합에는 다중집합 A, B에 모든 원소를 넣어줍니다.
            //물론 union은 Set이기 때문에 중복삽입이 되지 않습니다.
            union.addAll(mapA.keySet());
            union.addAll(mapB.keySet());
            //교집합에는 A의 모든 원소를 넣어주고
            //retainAll으로 B에 속해 있는(둘다 가지고 있는)원소를 제외한 나머지를 모두 삭제해줍니다.
            Set<String> intersect = new HashSet<>();
            intersect.addAll(mapA.keySet());
            intersect.retainAll(mapB.keySet());

            int inter = 0; // 교집합 원소 수
            int uni = 0; // 합집합 원소 수

            for(String element : intersect){
                //교집합에는 집합 A, B 중 적게 들어있는 것을 더해주고
                inter += Math.min(mapA.getOrDefault(element, 0), mapB.getOrDefault(element, 0));
            }
            for(String element : union){
                //합집합에는 집합 A, B 중 많이 들어있는 것을 더해줍니다
                //만약 A, B에 교집합 또는 합집합에 들어있는 원소가 없다면 getOrDefault(element, 0)으로 0으로 취급됩니다.
                uni += Math.max(mapA.getOrDefault(element, 0), mapB.getOrDefault(element, 0));
            }

            double answer;
            if(inter == 0 && uni == 0) answer = 65536; // A, B 둘다 공집합이면 1 * 65536
            // 그게 아니라면 자카드 유사도에 65536을 곱해준 값을 반환해줍니다.
            else answer = (double)inter / uni * 65536;

            return (int) answer;
        }

        //문자열을 두 글자씩 끊어서 다중집합을 만드는 seperate 함수
        private void seperate(Map<String, Integer> map, String str) {
            for (int i = 0; i < str.length() - 1; ++i) {
                //두 글자식 잘라 다중집합의 원소 만들기
                String key = str.substring(i, i + 2);
                //정규식을 사용해 알파벳 외의 숫자가 들어간 원소는 제외합니다
                if(!key.matches("^[a-z]*$")) continue;
                //map에 자른 두 글자를 key로 문자열에 몇 개가 포함되는지 세어줍니다
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("E=M*C^2", "e=m*c^2"));
    }
}