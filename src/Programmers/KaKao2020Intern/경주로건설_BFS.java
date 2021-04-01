package Programmers.KaKao2020Intern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설_BFS {
    static class Solution {
        private static int[] rDir = {-1, 1, 0, 0};
        private static int[] cDir = {0, 0, -1, 1};
        private static int N;
        private static int answer;
        private static int map[][];

        public int solution(int[][] board) {
            N = board.length;
            answer = Integer.MAX_VALUE;
            map = board;
            answer = BFS(new Site(0, 0, 0, -1));
            return answer;
        }

        static class Site {
            public int row;
            public int col;
            public int cost;
            public int dir;

            public Site(int row, int col, int cost, int dir) {
                this.row = row;
                this.col = col;
                this.cost = cost;
                this.dir = dir;
            }
        }

        static int BFS(Site site) {
            Queue<Site> queue = new LinkedList<>();
            int costBoard[][] = new int[N][N];
            for(int cost[] : costBoard){
                Arrays.fill(cost, Integer.MAX_VALUE);
            }
            queue.add(site);
            while (!queue.isEmpty()) {
                site = queue.poll();
                int row = site.row;
                int col = site.col;
                int dir = site.dir;
                int cost = site.cost;

                if (row == N - 1 && col == N - 1) {
                    answer = Math.min(cost, answer);
                    continue;
                }
                for(int i = 0; i < 4; ++i){
                    int nRow = row + rDir[i];
                    int nCol = col + cDir[i];
                    if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N || map[nRow][nCol] == 1) continue;
                    int nCost = 0;
                    if(dir == -1 || dir == i){
                        nCost = cost + 100;
                    } else if(dir != i){
                        nCost = cost + 600;
                    }

                    if(costBoard[nRow][nCol] >= nCost){
                        costBoard[nRow][nCol] = nCost;
                        queue.add(new Site(nRow, nCol, nCost, i));
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] board1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board2 = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int[][] board3 = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int[][] board4 = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};
        Solution s = new Solution();

        System.out.println(s.solution(board1));
    }
}
