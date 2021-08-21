package Programmers.YAPP.Week19;

import java.util.*;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class 리틀프렌즈사천성 {
    static class Solution {
        static int dir = -1; // -1은 시작 0은 수직 1은 좌우
        static int N, M;
        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};
        static boolean found = false;
        static boolean[][] visited;
        static String[][] newBoard;
        static Stack<String> route;
        static Map<String, List<Node>> endMap;
        static Map<String, List<String>> routeMap;
        StringBuilder sb;
        public String solution(int m, int n, String[] board) {
            endMap = new HashMap<>();
            routeMap = new HashMap<>();
            sb = new StringBuilder();
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
                route = new Stack<>();
                Node start = endList.remove(0);
                Node end = endList.remove(0);
                visited = new boolean[m][n];
                DFS(key, start, end, -1);
            }

            String[] input = endMap.keySet().toArray(new String[0]);
            int size = endMap.size();
            Arrays.sort(input);
            permutation(size, size, new String[size], input, 0, 0);

            if(sb.length() == 0) return "IMPOSSIBLE";
            return sb.toString();
        }

        class Node {
            public int row;
            public int col;

            Node(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        public void permutation(int n, int r, String[] perms, String[] input, int depth, int flag){
            if(depth == r){
                boolean con = true;
                for(String p : perms) sb.append(p);
                for(int i = 0; i < perms.length; ++i){
                    String str = sb.substring(0, i + 1);
                    List<String> routeList = routeMap.get(perms[i]);
                    if(routeList == null) con = false;
                    else if(routeList.size() > 0) {
                        for(String rt : routeList){
                            if(!str.contains(rt)) {
                                con = false;
                                break;
                            }
                        }
                    }
                    if(!con) {
                        sb.delete(0, sb.length());
                        return;
                    }
                }
                found = true;
                return;
            }
            for(int i = 0; i < n; ++i){
                if(found) break;
                if((flag & (1 << i)) == 0){
                    perms[depth] = input[i];
                    permutation(n, r, perms, input, depth + 1, flag | 1 << i);
                }
            }
        }

        public void DFS(String key, Node now, Node dest, int changed) {
            if(changed > 1) {
                //tempSet.remove(tempSet);
                return;
            }
            int r = now.row;
            int c = now.col;
            if(dest.row == r && dest.col == c) {
                List<String> result = route.stream().distinct().collect(toList());
                if(routeMap.get(key) == null || route.size() < routeMap.get(key).size()) routeMap.put(key, result);
                route = new Stack<>();
                return;
            }
            if(visited[r][c]) return;
            visited[r][c] = true;
            if(newBoard[r][c].equals("*")) return;
            if(!newBoard[r][c].equals(".") && !newBoard[r][c].equals(key)) {
                route.push(newBoard[r][c]);
                List<String> list = routeMap.get(key);
                if(list != null && route.size() > list.size()) {
                    route.pop();
                    return;
                }
            }
            for(int i = 0; i < dr.length; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < M && nc >= 0 && nc < N) {
                    int newDir;
                    if(dr[i] != 0) newDir = 0; // 수직이면 0
                    else newDir = 1; // 좌우면 1
                    if(dir == newDir) { // 꺾지 않았을때
                        DFS(key, new Node(nr, nc), dest, changed);
                    }
                    else {
                        int temp = dir;
                        dir = newDir;
                        DFS(key, new Node(nr, nc), dest, changed + 1);
                        dir = temp;
                    }
                }
            }
            visited[r][c] = false;
            if(!route.isEmpty()) route.pop();
        }
    }

    public static void main(String[] args) {
        String[] board1 = {"DBA", "C*A", "CDB"};
        String[] board2 = {".ZI.", "M.**", "MZU.", ".IU."};
        String[] board3 = {"NRYN", "ARYA"};
        String[] board4 = {"AB", "BA"};
        String[] board5 = {"A*", "*A"};
        String[] board6 = {"KOA", "T.T", "AOK"};
        String[] board7 = {"ZZEE", "JKCJ", "CKAA"};
        Solution s = new Solution();
        System.out.println(s.solution(3, 4, board7));
    }
}