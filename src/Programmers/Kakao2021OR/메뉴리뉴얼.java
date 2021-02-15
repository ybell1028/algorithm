package Programmers.Kakao2021OR;

import java.util.LinkedList;
import java.util.Queue;

public class 메뉴리뉴얼 {
    static class Solution {
        public String[] solution(String[] orders, int[] course) {
            int[] menu = new int[26];

            int max = 0;

            for(int i = 0; i < orders.length; ++i){
                for(int j = 0; j < orders[i].length(); ++j){
                    menu[orders[i].charAt(j) - 65]++;
                }
            }

            for(int i = 0; i < menu.length; ++i){
                max = Math.max(max, menu[i]); // 가장 많은 사람들이 고른 메뉴
            }
            //요리 5개를 주문한 손님이 1명 있지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로
            //요리 5개로 구성된 코스요리는 새로 추가하지 않습니다.

            Queue<String>[] qArr = new LinkedList[max + 1];
            LinkedList<String> result = new LinkedList<>();
            for(int i = 0; i <= max; ++i){
                qArr[i] = new LinkedList<>();
            }

            int temp = max;

            while(max >= 2){
                for(int i = 0; i < menu.length; ++i){
                    if(menu[i] >= max){
                        qArr[max].add(Character.toString((char)(i + 65)));
                    }
                }
                max--;
            }

            for(int i = 0; i < course.length; ++i){ // 만드려고 하는 코스 수만큼
                int var = course[i]; // 요리 가짓수
                max = temp;
                while(max >= 2){
                    if(qArr[max].size() >= var){
                        StringBuilder sb = new StringBuilder();
                        while(!qArr[max].isEmpty()){
                            sb.append(qArr[max].poll());
                            if(sb.length() == var){
                                result.add(sb.toString());
                            }
                        }
                    }
                    max--;
                }
            }

            String[] answer = new String[result.size()];
            for(int i = 0; i < result.size(); ++i){
                answer[i] = result.poll();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        System.out.println(s.solution(orders, course));
    }
}
