package Programmers.WeeklyChallenge;

public class 최소직사각형 {
    class Solution {
        int maxBig = Integer.MIN_VALUE;
        int maxSmall = Integer.MIN_VALUE;

        public int solution(int[][] sizes) {
            for(int i = 0; i < sizes.length; ++i) {
                if(sizes[i][0] > sizes[i][1]) {
                    maxBig = Math.max(sizes[i][0], maxBig);
                    maxSmall = Math.max(sizes[i][1], maxSmall);
                } else {
                    maxBig = Math.max(sizes[i][1], maxBig);
                    maxSmall = Math.max(sizes[i][0], maxSmall);
                }
            }

            return maxBig * maxSmall;
        }
    }
}
