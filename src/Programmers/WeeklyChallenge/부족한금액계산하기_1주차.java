package Programmers.WeeklyChallenge;

public class 부족한금액계산하기_1주차 {
    class Solution {
        public long solution(int price, int money, int count) {
            long fee = 0;
            for(int i = 1; i <= count; ++i) {
                fee += price * i;
            }

            long answer = 0;

            if(money - fee < 0) answer = fee - money;

            return answer;
        }
    }
}
