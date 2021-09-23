package Programmers.YAPP.Week23;
//9시 40분 시작 10시 9분 종료

public class 모음사전 {
    class Solution {
        int N = 5;
        int cnt = 0;
        boolean found = false;
        String[] aeiou = {"A", "E", "I", "O", "U"};
        StringBuilder sb = new StringBuilder();
        public int solution(String word) {
            permutation(0, word);
            return cnt;
        }

        public void permutation(int depth, String word){
            if(depth == N){
                return;
            } else {
                for(int i = 0; i < N && !found; ++i){
                    sb.append(aeiou[i]);
                    cnt++;
                    if(sb.toString().equals(word)) {
                        found = true;
                        return;
                    }
                    permutation(depth + 1, word);
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
        }
    }
}
