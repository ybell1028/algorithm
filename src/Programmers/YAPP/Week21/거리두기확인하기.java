package Programmers.YAPP.Week21;

import java.util.*;

public class 거리두기확인하기 {
    static class Solution {
        static final int NUM = 5;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int sRow;
        int sCol;
        boolean[][] visited;
        String[][] room;
        boolean violate; // 재귀 탈출 조건

        public int[] solution(String[][] places) {
            int[] answer = new int[NUM];
            int idx = 0;

            for(String[] pl : places){
                visited = new boolean[NUM][NUM];
                room = new String[NUM][NUM];
                // places를 파싱하여 2차원 배열 room에 저장
                for(int i = 0; i < pl.length; ++i){
                    room[i] = pl[i].split("");
                }
                violate = false;
                // 반복문 조건에 탈출 조건을 더해줌으로써 쓸데없는 연산을 피할 수 있다
                for(int i = 0; i < NUM && !violate; ++i){
                    for(int j = 0; j < NUM && !violate; ++j){
                        // 응시자를 발견했다면 DFS 시작
                        if(room[i][j].equals("P")) {
                            sRow = i;
                            sCol = j;
                            dfs(i, j, 0);
                        }
                    }
                }
                answer[idx++] = violate ? 0 : 1;
            }

            return answer;
        }

        public void dfs(int r, int c, int step){ // 거리 2 이내에 사이에 파티션 없이 사람이 있다면 return false;
            if(violate || step > 2) return;
            if(r < 0 || r >= NUM || c < 0 || c >= NUM) return;
            if(visited[r][c] || room[r][c].equals("X")) return;
            visited[r][c] = true;
            if((r != sRow || c != sCol) && room[r][c].equals("P")) {
                violate = true;
                return;
            }
            for(int i = 0; i < dr.length; ++i){
                int nr = r + dr[i];
                int nc = c + dc[i];
                dfs(nr, nc, step + 1);
            }
        }
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Solution s = new Solution();
        s.solution(places);
    }
}
