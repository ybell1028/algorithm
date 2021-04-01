package Programmers.KaKao2020Intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 경주로건설 {
    static class Solution {
        private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        private static int R, C;
        private static int answer;
        private static boolean dirChange = false;

        public int solution(int[][] board) {
            R = board.length;
            C = board[0].length;
            boolean[][] visited = new boolean[R][C];
            answer = Integer.MAX_VALUE;
            DFS(board, visited, 0, 0, 0, new Dir(0, 0), false); // -300
            return answer;
        }

        static class Dir {
            int rdir;
            int cdir;

            Dir(int rdir, int cdir) {
                if(rdir == -1) this.rdir = 1;
                else this.rdir = rdir;

                if(cdir == -1) this.cdir = 1;
                else this.cdir = cdir;
            }

            int calcCost(boolean dirChange) {
                if(dirChange){
                    dirChange = false;
                    return 500;
                } else return 0;
            }
        }

        static void DFS(int[][] board, boolean[][] visited, int row1, int col1, int sum, Dir d, boolean dirChange) {
            visited[row1][col1] = true;
            if (board[row1][col1] == 1) return;
            sum += d.calcCost(dirChange);
            if (row1 == R - 1 && col1 == C - 1) {
                visited[row1][col1] = false;
                answer = Math.min(answer, sum);
                return;
            }
            for (int dir[] : dirs) {
                int row2 = row1 + dir[0];
                int col2 = col1 + dir[1];
                if (row2 < 0 || row2 >= R || col2 < 0 || col2 >= C) continue;
                if (!visited[row2][col2]) {
                    if((d.rdir == 1 && dir[0] == 0) || (d.cdir == 1 && dir[1] == 0)) // 방향이 달라짐
                        DFS(board, visited, row2, col2, sum + 100, new Dir(dir[0], dir[1]), true);
                    else
                        DFS(board, visited, row2, col2, sum + 100, new Dir(dir[0], dir[1]), false);
                }
            }
            visited[row1][col1] = false;
        }
    }

    public static void main(String[] args) {
        int[][] board1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board2 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int[][] board3 = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int[][] board4 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        Solution s = new Solution();

        System.out.println(s.solution(board4));
    }
}
