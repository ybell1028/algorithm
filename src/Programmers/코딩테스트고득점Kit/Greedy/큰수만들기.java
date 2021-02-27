package Programmers.코딩테스트고득점Kit.Greedy;

import java.util.Collections;
import java.util.PriorityQueue;

// 참고 : https://ukyonge.tistory.com/197
// 1000000까지 숫자 + 1000000개의 숫자를 뺄 수 있으므로  완전탐색으로 접근하면 시간초과가 발생한다. 그리디로 접근해야한다.
// 만약 리턴해야하는 값이 4자리의 수라면, 입력값에서 맨뒤의 3자리를 제외한 문자열 부분에서 가장 큰 수를 찾는다.
// 그리고나서 큰 수를 찾은 자리 이후 부터 마지막 2자리를 제외한 곳에서 큰값을 찾는다. 이 과정을 반복하면 된다.
public class 큰수만들기 {
    static class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            for(int i = 0; i < number.length() - k; ++i){
                int max = 0;
                for(int j = idx; j <= i + k; ++j){
                    if(max < number.charAt(j) - '0'){
                        max = number.charAt(j) - '0';
                        idx = j + 1;
                    }
                }
                sb.append(max);
            }
            return sb.toString();
        }
    }

    // 스택을 사용한 방법
//    import java.util.Stack;
//    class Solution {
//        public String solution(String number, int k) {
//            char[] result = new char[number.length() - k];
//            Stack<Character> stack = new Stack<>();
//
//            for (int i=0; i<number.length(); i++) {
//                char c = number.charAt(i);
//                while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
//                    stack.pop();
//                }
//                stack.push(c);
//            }
//            for (int i=0; i<result.length; i++) {
//                result[i] = stack.get(i);
//            }
//            return new String(result);
//        }
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String number = "4177252841";
        int k = 4;
        System.out.println(s.solution(number, k));
    }
}
