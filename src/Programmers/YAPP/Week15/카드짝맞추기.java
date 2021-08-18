package Programmers.YAPP.Week15;

import java.util.*;

public class 카드짝맞추기 {
    private static final int LEN = 4;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Vertex {
        public int row;
        public int col;
        public int press;

        Vertex(int row, int col) {
            this.row = row;
            this.col = col;
        }

        Vertex(int row, int col, int press) {
            this.row = row;
            this.col = col;
            this.press = press;
        }
    }

    static class Solution {
        ArrayList<int[]> orders;

        public int solution(int[][] board, int r, int c) {
            int answer = Integer.MAX_VALUE;
            int n = 0; // 카드 짝 갯수
            for (int i = 0; i < LEN; ++i) {
                for (int j = 0; j < LEN; ++j) {
                    if (board[i][j] != 0) n++;
                }
            }

            n /= 2;
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = i + 1;
            }

            orders = new ArrayList<>();
            permutation(n, n, new int[n], temp, 0, 0);

            for (int[] order : orders) { // order = 순열 배열
                int total = 0;
                Vertex point = new Vertex(r, c); //최초 커서위치 (r,c)
                int[][] cBoard = deepCopy(board);

                for (int card : order) { // 순열 요소 한가지 씩
                    int cnt = 0;
                    //목표 카드 찾기
                    cnt += bfs(cBoard, card, point) + 1; // enter키 입력
                    //목표 카드 선택
                    cBoard[point.row][point.col] = 0;
                    //카드 짝 찾기
                    cnt += bfs(cBoard, card, point) + 1; // enter키 입력
                    //짝 찾기 성공
                    cBoard[point.row][point.col] = 0;

                    total += cnt;
                }
                answer = Math.min(total, answer);
            }
            return answer;
        }

        private int bfs(int[][] board, int target, Vertex point) {
            Queue<Vertex> queue = new LinkedList<>();
            boolean[][] visited = new boolean[LEN][LEN];

            queue.add(new Vertex(point.row, point.col, 0));
            visited[point.row][point.col] = true;

            while (!queue.isEmpty()) {
                Vertex p = queue.poll();
                if (board[p.row][p.col] == target) {
                    point.row = p.row;
                    point.col = p.col;
                    return p.press;
                }
                //4방 탐색
                for (int d = 0; d < LEN; d++) {
                    int nr = p.row + dr[d];
                    int nc = p.col + dc[d];
                    if (nr >= 0 && nr < LEN && nc >= 0 && nc < LEN && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new Vertex(nr, nc, p.press + 1));
                    }
                }

                //ctrl + 4방 탐색
                for (int d = 0; d < 4; d++) {
                    Vertex result = findCard(board, p.row, p.col, d);
                    if ((result.row != p.row || result.col != p.col) && !visited[result.row][result.col]) {
                        visited[result.row][result.col] = true;
                        queue.add(new Vertex(result.row, result.col, p.press + 1));
                    }
                }
            }
            return 0;
        }

        private Vertex findCard(int[][] board, int row, int col, int d) {
            row += dr[d];
            col += dc[d];
            while (row >= 0 && row < LEN && col >= 0 && col < LEN) {
                if (board[row][col] != 0) {
                    return new Vertex(row, col);
                }
                row += dr[d];
                col += dc[d];
            }
            return new Vertex(row - dr[d], col - dc[d]);
        }

        public int[][] deepCopy(int[][] board) {
            int[][] result = new int[LEN][LEN];
            for (int i = 0; i < LEN; ++i) {
                for (int j = 0; j < LEN; ++j) {
                    result[i][j] = board[i][j];
                }
            }
            return result;
        }

        private void permutation(int n, int r, int[] perms, int[] input, int depth, int flag) {
            if (depth == r) {
                int[] temp = new int[n];
                //arraycopy(Object src , int srcPos, object dest, int destPos, length)
                //Object src : 배열원본
                //srcPos : 소스 배열을 어디부터 복사시킬 것인지
                //dest : 위치시킬 배열
                //destPos : 위치시킬 배열의 시작 데이터 위치
                //length : 복사되는 배열 요소의 수
                System.arraycopy(perms, 0, temp, 0, n);
                orders.add(temp); // orders.ArrayList에 순서 순열 저장

                String[] str = new String[10];
                String str1 = Arrays.toString(str);
                return;
            }
            for (int i = 0; i < n; i++) {
                if ((flag & (1 << i)) == 0) {
                    perms[depth] = input[i];
                    permutation(n, r, perms, input, depth + 1, flag | (1 << i));
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {
                {1, 0, 0, 3},
                {2, 0, 0, 0},
                {0, 0, 0, 2},
                {3, 0, 1, 0}
        };
        System.out.println(sol.solution(board, 1, 0));
    }
}