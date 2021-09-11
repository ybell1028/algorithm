package Programmers.Line2021Newbie;

public class Exam1 {
    static class Solution {
        public int solution(int[] student, int k) {
            int answer = 0;
            int len = student.length;
            for(int i = 0; i < len - 1; ++i){
                for(int j = i + 1; j <= len; ++j){ // 0 ~ 6, 1 ~ 6
                    int cnt = 0;
                    if(j - i > k){
                        for(int l = i; l < j; ++l){
                            if(student[l] == 1) cnt++;
                        }
                        if(cnt == k) answer++;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] student1 = {0, 1, 0, 0};
        int[] student2 = {0, 1, 0, 0, 1, 1, 0};
        System.out.println(s.solution(student1, 1));
    }
}
