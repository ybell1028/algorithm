package Programmers.YAPP.Week22;

public class 프렌즈4블록 {
    class Solution {
        int M, N;
        int[][] dirs = {{1, 0} {0, 1}, {1, 1}};
        char[][] nBoard;
        public int solution(int m, int n, String[] board) {
            M = m;
            N = n;
            nBoard = new char[board.length][board[0].length()];
            for(int i = 0; i < board.length; ++i){
                nBoard[i] = board[i].toCharArray();
            }
            int answer = 0;
            return answer;
        }

        public boolean canDelete(int r, int c){
            if(r >= M - 1 || c >= N - 1) return false;
            else {
                for(int i = 0; i < dirs.length; ++i){
                    if(nBoard[r + dirs[i][0]][c + dirs[i][1]] == 0){
                        r++;
                        i--;
                        continue;
                    }
                    if(nBoard[r][c] != nBoard[r + dirs[i][0]][c + dirs[i][1]]) return false;
                }
                return true;
            }
        }

        public void delete(char[][] nBoard){

        }
    }
}
