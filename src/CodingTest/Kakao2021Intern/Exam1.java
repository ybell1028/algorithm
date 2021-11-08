package CodingTest.Kakao2021Intern;

public class Exam1 { // 숫자놀이
    class Solution {
        public int solution(String s) {
            String[] numberStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            int[] number = {0, 1, 2, 3, 4, 5 ,6 ,7, 8, 9};
            for(int i = 0; i < number.length; ++i){
                if(s.contains(numberStr[i]))
                    s = s.replace(numberStr[i], String.valueOf(number[i]));
            }
            return Integer.parseInt(s);
        }
    }
}
