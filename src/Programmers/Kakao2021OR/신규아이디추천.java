package Programmers.Kakao2021OR;


import java.util.LinkedList;
import java.util.regex.Pattern;

public class 신규아이디추천 {
    static class Solution {
        public String solution(String new_id) {
            new_id = new_id.toLowerCase();
            LinkedList<Character> list = new LinkedList<>();

            for (int i = 0; i < new_id.length(); ++i) {
                list.add(new_id.charAt(i));
            }

            for (int i = 0; i < list.size(); ++i) { // 2
                char c = list.get(i);
                if (!((c >= 48 && c <= 57) // 숫자
                        || (c >= 65 && c <= 90)
                        || (c >= 97 && c <= 122)
                        || (c == 45) // -
                        || (c == 46) // .
                        || (c == 95))) { // _
                    list.remove(i);
                    --i;
                }
            }

            for (int i = 0; i < list.size(); ++i) { // 3
                if(list.get(i) == '.'){
                    int j = i + 1;
                    while(j < list.size() && list.get(j) == '.'){
                        list.remove(j);
                    }
                }
            }

            if(!list.isEmpty() && list.get(0) == '.'){ // 4
                list.remove(0);
            }
            if(!list.isEmpty() && list.get(list.size() - 1) == '.'){
                list.remove(list.size() - 1);
            }

            if(list.isEmpty()) list.add('a'); // 5

            while(list.size() >= 16){ // 6
                list.remove(list.size() - 1);
            }
            if(list.get(list.size() - 1) == '.'){
                list.remove(list.size() - 1);
            }

            char tail = list.get(list.size() - 1); // 7
            while(list.size() <= 2){
                list.add(tail);
            }

            StringBuilder sb = new StringBuilder();
            while(!list.isEmpty()){
                sb.append(list.poll());
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("=.="));
    }
}
