package Programmers.Kakao2021Intern;

import java.util.ArrayList;
import java.util.List;

public class Exam2 {
    static class Solution {
        //응시자가 앉아 있는 곳 P
        //빈 테이블 0
        //파티션 X
        public static final int ROW = 5, COL = 5;
        public int[] solution(String[][] places) {
            int[] answer = new int[COL];
            int idx = 0;
            for(String[] temp : places){
                //temp = {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
                observe = true;
                List<Candi> candiList = new ArrayList<>();
                String[][] p = new String[temp.length][temp[0].length()];
                for(int i = 0; i < temp.length; ++i){
                    p[i] = temp[i].split("");
                    for(int j = 0; j < p[i].length; ++j){
                        if(p[i][j].equals("P")) candiList.add(new Candi(i, j));
                    }
                }
                //맨해튼 거리 체크
                for(int i = 0; i < candiList.size() - 1; ++i){
                    Candi A = candiList.get(i);
                    for(int j = i + 1; j < candiList.size(); ++j){
                        Candi B = candiList.get(j);
                        if(!manhattan(A ,B)){
                            boolean[][] visited = new boolean[ROW][COL];
                            visited[A.row][A.col] = true;
                            DFS(p, visited, B, A.row, A.col);
                            DFS(p, visited, A, B.row, B.col);
                            if(!observe) break;
                        }
                    }
                    if(!observe) break;
                }
                if(observe) answer[idx++] = 1;
                else answer[idx++] = 0;
            }
            for(int i = 0; i < answer.length; ++i){
                System.out.println(answer[i]);
            }
            return answer;
        }

        class Candi {
            public int row;
            public int col;

            public Candi(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        //맨해튼 거리가 2 이하로 앉지 말아 주세요.
        public boolean manhattan(Candi a, Candi b){
            if(Math.abs(a.row - b.row) + Math.abs(a.col - b.col) <= 2) return false;
            return true;
        }


        public static boolean observe;
        public static int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public static void DFS(String[][] p, boolean[][] visited, Candi dest, int r, int c){
            if(!observe) return;
            for(int dir[] : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= ROW || nc < 0 || nc >= COL) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if((nr == dest.row && nc == dest.col)) {
                    observe = false;
                    return;
                }
                if (p[nr][nc].equals("X") || p[nr][nc].equals("P")) continue;
                DFS(p, visited, dest, nr, nc);
            }
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            String[][] p = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POXPX", "XXPXP", "PXXXO", "OXXXO", "O0POP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"POOOP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
            System.out.println(s.solution(p));
        }
    }
}
