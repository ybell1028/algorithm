package Programmers.WinterSummerCoding2019;

public class 멀쩡한사각형 {
    class Solution {
        long big = 0;
        long small = 0;
        public long solution(int w, int h) {
            compare(w, h);
            long answer = 0;
            long total = big * small;
            if(w == 1 || h == 1) answer = 0;
            else if(w == h) answer = total - w;
            else {
                long nat = 1;
                long temp = 0;
                long removed = 0;
                for(int i = 1; i <= big; ++i){
                    temp = small * i;
                    if(temp / (double)big > nat){
                        removed += 2;
                        nat++;
                    } else {
                        removed += 1;
                        if(temp % big == 0) nat++;
                    }
                }
                answer = total - removed;
            }
            return answer;
        }

        public void compare(int w, int h){
            if(w > h) {
                big = w;
                small = h;
            } else {
                big = h;
                small = w;
            }
        }
    }
}
