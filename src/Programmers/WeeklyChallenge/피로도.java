package Programmers.WeeklyChallenge;

public class 피로도 {
    class Solution {
        int D;
        int max = 0;
        boolean[] visit;

        public int solution(int k, int[][] dungeons) {
            //dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
            //최소 필요 피로도가 낮은 순으로 정렬?
            //던전의 개수 1이상 8이하 -> 그리디 알고리즘, 완전 탐색
            D = dungeons.length;
            visit = new boolean[D];

            dfs(dungeons, k, 0, 0);

            return max;
        }

        public void dfs(int[][] dungeons, int k, int depth, int cnt) {
            if(depth == D) {
                max = Math.max(max, cnt);
                return;
            } else {
                for(int i = 0; i < D; ++i) {
                    if(!visit[i]) {
                        visit[i] = true;
                        if(k >= dungeons[i][0])
                            dfs(dungeons, k - dungeons[i][1], depth + 1, cnt + 1);
                        else
                            dfs(dungeons, k, depth + 1, cnt);
                        visit[i] = false;
                    }
                }
            }
        }
    }
}
