package Programmers.YAPP.Week23;

import java.util.*;

public class 자물쇠와열쇠 {
    static class Solution {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        int N, M; // M은 항상 N 이하입니다.
        boolean answer = false;
        String keypt;
        String lockhole;
        Set<String> visited = new HashSet<>();
//        List<Node> pt = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        //Node 클래스가 아니라 스트링을 써라!

        public boolean solution(int[][] key, int[][] lock) {
            M = key.length;
            N = lock.length;
            for(int i = 0; i < N; ++i) { // 열쇠 홈 저장
                for(int j = 0; j < N; ++j){
                    if(lock[i][j] == 0) {
                        sb.append(i);
                        sb.append(j);
                    }
                }
            }
            lockhole = sb.toString();
            sb.delete(0, sb.length() + 1);
            for(int i = 0; i < M; ++i) { // 키의 요철 저장
                for(int j = 0; j < M; ++j){
                    if(key[i][j] == 1) {
                        sb.append(i);
                        sb.append(j);
                    }
                }
            }
            keypt = sb.toString();
            sb.delete(0, sb.length());

            for(int i = 0; i < 4; ++i) {
                find(keypt); // [0, 0], [1, 90], [2, 180], [3, 270]
                if(answer) break;
                else {
                    char[] cArr = keypt.toCharArray();
                    for(int j = 0; j < cArr.length; j += 2) { // 회전 시키기 한번 마다 시계 방향으로 한번씩 회전
                        sb.append(cArr[j + 1] - 48);
                        sb.append((M - 1) - (cArr[j] - 48));
                    }
                    keypt = sb.toString();
                    sb.delete(0, sb.length());
                }
            }
            return answer;
        }

        public void find(String visit){
            if(answer || visit.length() < lockhole.length()) return;
            if(visited.contains(visit)) return;
            visited.add(visit);
            for(int i = 0; i < 4; ++i){
                if(lockhole.equals(visit)) {
                    answer = true;
                    return;
                }
                char[] cArr = visit.toCharArray();
                for(int j = 0; j < cArr.length; j += 2){ // 홀수가 있다
                    int nr = cArr[j] + dr[i] - 48;
                    int nc = cArr[j + 1] + dc[i] - 48;
                    if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                        sb.append(nr);
                        sb.append(nc);
                    }
                }
                String v = sb.toString();
                sb.delete(0, sb.length() + 1);
                find(v);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] key1 = {{0, 1}, {1, 0}};
        int[][] key2 = {{1, 1}, {1, 0}};
        int[][] key3 = {{0, 1, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {0, 1, 0, 1}};
        int[][] key4 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] key5 = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] lock1 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}, {1, 1, 1, 1}};
        System.out.println(s.solution(key5, lock1));
    }
}
