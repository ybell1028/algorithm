package Programmers.YAPP.Week16;

public class 카카오프렌즈컬러링북2 {
    static class Solution {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        boolean[][] visit;
        int M, N;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int size;
        public int[] solution(int m, int n, int[][] picture) {
            M = m;
            N = n;

            visit = new boolean[m][n];

            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    if(picture[i][j] != 0) {
                        size = 0;
                        if(dfs(picture, i, j, picture[i][j])) numberOfArea++;
                        maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public boolean dfs(int[][] picture, int r, int c, int target){
            // 이 문제의 포인트 1
            if(visit[r][c]) return false;
            if(picture[r][c] != target) return false;
            visit[r][c] = true;

            // 이 문제의 포인트 2
            size++;

            for(int i = 0 ; i < 4; ++i){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < M && nc >= 0 && nc < N) dfs(picture, nr, nc, target);
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[][] picture2 = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        s.solution(6, 4, picture2);
    }
}
