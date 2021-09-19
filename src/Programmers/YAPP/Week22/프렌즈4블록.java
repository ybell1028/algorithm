package Programmers.YAPP.Week22;

import java.util.*;
import java.util.stream.Collectors;

public class 프렌즈4블록 {
    static class Block {
        public int row;
        public int col;
        public String content;

        Block(int row, int col, String content) {
            this.row = row;
            this.col = col;
            this.content = content;
        }
    }

    static class Solution {
        int M, N;
        String[][] nBoard;
        Stack<Block> stack;

        public int solution(int m, int n, String[] board) {
            M = m;
            N = n;
            int answer = 0;
            stack = new Stack<>();
            nBoard = new String[m][n];
            for (int i = 0; i < m; ++i) {
                nBoard[i] = board[i].split("");
            }
            while (true) {
                for (int i = 0; i < m - 1; ++i) {
                    for (int j = 0; j < n - 1; ++j) {
                        if (!nBoard[i][j].equals("0")) canDelete(i, j, nBoard[i][j]);
                    }
                }
                if (stack.size() == 0) break;
                else {
                    while (!stack.isEmpty()) {
                        Block b = stack.pop();
                        for (int i = b.col; i <= b.col + 1; ++i) {
                            int cnt = 0;
                            for (int j = b.row; j < m; ++j) {
                                if (cnt == 2) break;
                                else {
                                    if (nBoard[j][i].equals(b.content)) {
                                        cnt++;
                                        nBoard[j][i] = "0";
                                    }
                                }
                            }
                            answer += cnt;
                        }
                    }
                }
            }
            return answer;
        }

        public void canDelete(int row, int col, String target) {
            // 첫번째
            int total = 0;
            int limit1 = row + 1;
            //하 -> 우 -> 상으로 움직임
            for (int i = col; i <= col + 1; ++i) {
                if(i == col){ // 우선 첫번째 루프는 처음부터 해당 타겟이 있다는게 확실하다
                    for (int j = row; j <= limit1; ++j) {
                            if (limit1 < M - 1 && nBoard[j][i].equals("0")) {
                                limit1++;
                            } else if (nBoard[j][i].equals(target)) {
                                total++;
                            } else break; // 다른 알파벳 나오면 나가리
                    }
                } else {
                    if(total < 2) return;
                    int limit2 = limit1 >= M - 1 ? M - 1 : limit1 + 1;
                    int limit3 = limit2 - 1;
                    if(nBoard[limit2][i].equals(target)) total++;
                    else break;
                    for (int j = limit2 - 1; j >= limit3 && total < 4; --j) {
                        if (nBoard[j][i].equals(target)) {
                            total++;
                        } else if(limit3 > 0 && nBoard[j][i].equals("0")) limit3--;
                        else break; // 다른 알파벳 나오면 나가리
                    }
                }
            }
            if (total == 4) stack.add(new Block(row, col, nBoard[row][col]));  // 다 넣을 필요 없고 작은 [row][col]
        }
    }

    public static void main(String[] args) {
        String[] board0 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] board1 = {"TTT", "TTT", "TTT"};
        String[] board2 = {"GGPP", "GGPP", "AAGG", "GGAA"};
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        Solution s = new Solution();
        System.out.println(s.solution(6, 6, board));
    }
}