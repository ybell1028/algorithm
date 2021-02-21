package Programmers.SkillCheck;
//소요시간 : 50분

public class 땅따먹기게임 {
        static class Solution {
            int solution(int[][] land) {
                int answer = 0;
                int len = land.length;
                int[][] dp = new int[len][4];

                for(int i = 0; i < land[0].length; ++i){
                    dp[0][i] = land[0][i];
                }

                int prevcol = -1;
                int maxcol = -1;
                for(int i = 1; i < len; ++i){
                    for(int j = 0; j < 4; j++){
                        int max = 0;
                        for(int k = 0; k < 4; k++){
                            if(j == k) continue;
                            if(max < dp[i - 1][k]){
                                max = dp[i - 1][k];
                            }
                        }
                        dp[i][j] = land[i][j] + max;
                    }
                }

                for(int i = 0; i < 4; ++i){
                    answer = Math.max(answer, dp[len - 1][i]);
                }
                return answer;
            }
        }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        s.solution(land);
    }
}
