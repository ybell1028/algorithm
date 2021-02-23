package Programmers.Hash;

import java.util.*;

//1시 10분 시작 - 1시간 10분 경과 (실패)
public class 위장 {
    static class Solution {
        public int solution(String[][] clothes) { // 모범답안 - 곱의 법칙 활용
//            테스트 케이스로 본다면
//            heargear 가 2 개, sunglasses가 1 개인데, heargear를 쓰는 날이 있을테지만 안쓰는 날도 있을 것이다.
//            sunglasses도 마찬가지.
//            그러므로 안쓰는 경우를 하나 추가하고, 둘 다 안쓴다는 경우 1 을 빼면 된다.
            int answer = 1;
            Map<String, Integer> hashMap = new HashMap<>();

            for (String[] cloth : clothes) {
                hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
            }

            for (int value : hashMap.values()) {
                // 옷 가지수 + 안입는 경우
                answer *= (value + 1);
            }

            // 옷을 하나도 안입는 경우는 없으니까 빼줌
            answer--;

            return answer;
        }
        
        //내가 푼 버전 - 시간 초과
//        public int solution(String[][] clothes) {
//            HashMap<String, LinkedList<String>> hm = new HashMap<>();
//            int len = clothes.length;
//            int answer = 0;
//            // clothes.length - 옷 가짓수
//            for (int i = 0; i < len; ++i) {
//                //clothes[i][1] - 카테고리
//                //clothes[i][0] - 옷
//                hm.computeIfAbsent(clothes[i][1], s -> new LinkedList<>()).add(clothes[i][0]);
//            }
//            int idx = 0;
//            String[] keys = new String[hm.size()];
//            for(String key : hm.keySet()) {
//                keys[idx++] = key;
//            }
//
//            for(int i = 1; i < (1 << keys.length); ++i){ // 가능한 조합수
//                int var = 1;
//                for(int j = 0; j < hm.size(); ++j){
//                    if((i & (1 << j)) > 0) {
//                        var *= hm.get(keys[j]).size();
//                    }
//                }
//                answer += var;
//            }
//
//            return answer;
//        }

        public static void main(String[] args) {
            Solution s = new Solution();
            String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
            String[][] clothes2 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
            System.out.println(s.solution(clothes2));
        }
    }
}
