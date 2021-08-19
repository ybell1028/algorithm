package Programmers.YAPP.Week19;

import java.util.*;
import java.util.regex.Pattern;

public class 리틀프렌즈사천성 {
    static class Solution {
        static int N, M;
        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};
        static boolean[][] visited;
        static String[][] newBoard;
        static int minCost;
        public String solution(int m, int n, String[] board) {
            Map<String, List<Node>> endMap = new HashMap<>();
            Map<String, Set<String>> routeMap = new HashMap<>();
            M = m;
            N = n;
            newBoard = new String[m][n];
            for(int i = 0; i < m; ++i){
                newBoard[i] = board[i].split("");
                for(int j = 0; j < n; ++j){
                    if(Pattern.matches("[A-Z]", newBoard[i][j])) {
                        endMap.computeIfAbsent(newBoard[i][j], l -> new LinkedList<>()).add(new Node(i, j));
                    }
                }
            }
            for(String key : endMap.keySet()){
                List<Node> endList = endMap.get(key);
                Node start = endList.remove(0);
                Node end = endList.remove(0);
                BFS(newBoard, key, routeMap, start, end);

                for(String rk : routeMap.keySet()){
                    System.out.println("Key : " + rk);
                    for(String route : routeMap.get(rk)){
                        System.out.println("route : " + route);
                    }
                }
            }
            return "";
        }

        class Node {
            public int row;
            public int col;

            Node(int row, int col){
                this.row = row;
                this.col = col;
            }
        }


        public void BFS(String[][] board, String key, Map<String, Set<String>> routeMap, Node start, Node dest) {
            visited = new boolean[M][N];
            Queue<Node> queue = new LinkedList<>();
            queue.add(start);
            while(!queue.isEmpty()){
                Node now = queue.poll();
                int r = now.row;
                int c = now.col;
                if(visited[r][c]) continue;
                visited[r][c] = true;
                if(board[r][c].equals("*")) continue;
                if(now.row == dest.row && now.col == dest.col){
                    return;
                }
                if(!board[r][c].equals(".") && !board[r][c].equals(key))
                    routeMap.computeIfAbsent(key, s -> new HashSet<>()).add(board[r][c]);
                for(int i = 0; i < dr.length; ++i){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(nr >= 0 && nr < M && nc >= 0 && nc < N) {
                        queue.add(new Node(nr, nc));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] board = {"DBA", "C*A", "CDB"};
        Solution s = new Solution();
        s.solution(3, 3, board);
    }
}
