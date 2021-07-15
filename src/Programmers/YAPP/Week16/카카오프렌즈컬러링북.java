package Programmers.YAPP.Week16;

import java.util.HashMap;
import java.util.Map;

public class 카카오프렌즈컬러링북 {
    static class Solution {
        boolean[][] visited;
        boolean[][] tVisited;
        int M, N;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int cnt;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        Map<Integer, Integer> element;
        public int[] solution(int m, int n, int[][] picture) {
            M = m;
            N = n;
            visited = new boolean[m][n];
            tVisited = new boolean[m][n];
            element = new HashMap<>();

            dfs(picture, 0, 0);

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public void dfs(int[][] picture, int r, int c){
            if(r < 0 || r >= M || c < 0 || c >= N) return;
            if(visited[r][c]) return;
            visited[r][c] = true;
            if(picture[r][c] != 0) {
                cnt = 0;
                int target = picture[r][c];
                for(int i = 0; i < 4; ++i){ // 이 루프 돌았는데도 아무것도 없으면 영역 하나
                    targetDfs(picture, target, r, c);
                }
                if(cnt > 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
            for(int i = 0; i < 4; ++i){ // 이 루프 돌았는데도 아무것도 없으면 영역 하나
                int nr = r + dr[i];
                int nc = c + dc[i];
                dfs(picture, nr, nc);
            }
        }

        public void targetDfs(int[][] picture, int target, int r, int c){
            if(r < 0 || r >= M || c < 0 || c >= N) return;
            if(tVisited[r][c]) return;
            if(picture[r][c] != target) return;
            tVisited[r][c] = true;
            cnt++;
            for(int i = 0; i < 4; ++i){
                int nr = r + dr[i];
                int nc = c + dc[i];
                targetDfs(picture, target, nr, nc);
            }
        }
    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[][] picture2 = {
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
        };
        int m = 13;
        int n = 16;
        Solution s = new Solution();
        System.out.println(s.solution(m, n, picture2));
    }

}
