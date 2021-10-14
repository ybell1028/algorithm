package Programmers.Kakao2019WinterIntern;

public class 징검다리건너기 {
    class Solution {
        boolean end;
        public int solution(int[] stones, int k) {
            int left = 1;
            int right = 200_000_000;

            while(left < right) {
                int mid = (left + right) / 2;
                if(possible(stones, k, mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            int answer = left;

            return answer;
        }

        public boolean possible (int[] stones, int k, int num){
            int cnt = 0;
            for(int i = stones.length - 1; i >= 0; --i){
                if(num >= stones[i]) {
                    cnt++;
                    if(cnt == k) return false;
                }
                else cnt = 0;
            }
            return true;
        }
    }
}
