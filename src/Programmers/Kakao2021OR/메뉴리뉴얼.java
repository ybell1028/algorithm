package Programmers.Kakao2021OR;

import java.util.*;

public class 메뉴리뉴얼 {
    static class Solution {
        HashMap<String, Integer> hm;
        StringBuilder sb = new StringBuilder();
        LinkedList<String> popular = new LinkedList<>();
        int var;
        public String[] solution(String[] orders, int[] course) {
            //손님이 주문한 단품 요리 리스트인 orders로 course에 들어있는 구성 수를 가지는 경우의 수를 구하자.
            for(int i = 0; i < course.length; ++i){
                hm = new HashMap<>();
                var = course[i];
                for (int j = 0; j < orders.length; ++j) {
                    combi(orders[j], 0, orders[j].length(), 0);
                }
                searchPopular();
            }
            String[] answer = new String[popular.size() + 1];
            int idx = 0;
            while(!popular.isEmpty()){
                answer[idx] = popular.poll();
                System.out.println(answer[idx]);
                idx++;
            }
            return answer;
        }

        public void combi(String order, int insert, int olen, int vlen){
            if(olen < insert) {
                sb.delete(0, sb.length() - 1);
                return;
            }
            if(var <= vlen) {
                char[] cArr = sb.toString().toCharArray();
                Arrays.sort(cArr);
                StringBuilder sorted = new StringBuilder();
                for(int i = 0; i < cArr.length; ++i){
                    sorted.append(Character.toString(cArr[i]));
                }
                String key = sorted.toString();
                hm.put(key, hm.getOrDefault(key, 0) + 1);
                return;
            }
            for(int i = insert; i < olen; ++i){
                if(sb.length() == 0 && olen - i < var) break;
                sb.append(Character.toString(order.charAt(i)));
                combi(order, i + 1, olen, vlen + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public void searchPopular(){
            int max = 2;
            Iterator<Map.Entry<String, Integer>> entries = hm.entrySet().iterator();
            while(entries.hasNext()){
                Map.Entry<String, Integer> entry = entries.next();
                if(max <= entry.getValue())
                    max = entry.getValue();
            }
            entries = hm.entrySet().iterator();
            while(entries.hasNext()){
                Map.Entry<String, Integer> entry = entries.next();
                if(entry.getValue() == max){
                    popular.add(entry.getKey());
                }
            }

            for(int i = 0; i < popular.size() - 1; ++i){
                for(int j = i + 1; j < popular.size(); ++j){
                    if(popular.get(i).compareTo(popular.get(j)) > 0){
                        String temp = popular.get(i);
                        popular.set(i, popular.get(j));
                        popular.set(j, temp);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        System.out.println(s.solution(orders, course));
    }
}
