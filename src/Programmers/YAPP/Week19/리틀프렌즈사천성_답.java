package Programmers.YAPP.Week19;

import java.util.*;

public class 리틀프렌즈사천성_답 {
    static class Solution {
        String[][] newBoard;
        List<String> list;
        Map<String, int[][]> map;
        int M, N;
        public String solution(int m, int n, String[] board) {
            list = new LinkedList<>();
            map = new HashMap<>();
            newBoard = new String[m][n];
            M = m;
            N = n;

            for(int i = 0; i < m; ++i){
                newBoard[i] = board[i].split("");
                for(int j = 0; j < n; ++j){
                    String tile = newBoard[i][j];
                    if(!tile.equals(".") && !tile.equals("*")) {
                        if(!list.contains(tile)){
                            list.add(tile);
                            map.put(tile, new int[2][2]);
                            map.get(tile)[0][0] = i;
                            map.get(tile)[0][1] = j;
                        } else { // 경로는 총 2개이기 때문에
                            map.get(tile)[1][0] = i;
                            map.get(tile)[1][1] = j;
                        }
                    }
                }
            }

            Collections.sort(list);

            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while(!list.isEmpty()){
                if(canDelete(list.get(idx))){
                    String popped = list.remove(idx);
                    sb.append(popped);
                    delete(popped);
                    idx = 0;
                } else {
                    idx++;
                    if(idx == list.size()) return "IMPOSSIBLE";
                }
            }

            return sb.toString();
        }

        void delete(String s){
            newBoard[map.get(s)[0][0]][map.get(s)[0][1]] = ".";
            newBoard[map.get(s)[1][0]][map.get(s)[1][1]] = ".";
        }

        boolean canDelete(String s) {
            int r1 = map.get(s)[0][0];
            int c1 = map.get(s)[0][1];
            int r2 = map.get(s)[1][0];
            int c2 = map.get(s)[1][1];

            if(c1 < c2) {
                if(linearColCheck(c1, c2, r1, s) && linearRowCheck(r1, r2, c2, s)) return true;
                if(linearRowCheck(r1, r2, c1, s) && linearColCheck(c1, c2, r2, s)) return true;
            } else {
                if(linearRowCheck(r1, r2, c2, s) && linearColCheck(c2, c1, r1, s)) return true;
                if(linearColCheck(c2, c1, r2, s) && linearRowCheck(r1, r2, c1, s)) return true;
            }
            return false;
        }

        boolean linearRowCheck(int r1, int r2, int c, String s){
            for(int i = r1; i <= r2; ++i)
                if(!newBoard[i][c].equals(".") && !newBoard[i][c].equals(s)) return false;
            return true;
        }

        boolean linearColCheck(int c1, int c2, int r, String s){
            for(int i = c1; i <= c2; ++i)
                if(!newBoard[r][i].equals(".") && !newBoard[r][i].equals(s)) return false;
            return true;
        }
    }
}
