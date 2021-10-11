package Programmers.YAPP.Week24;

import java.util.*;

public class 기둥과보설치 {
    static class Solution {
        class Frame implements Comparable {
            public int x;
            public int y;
            public int a; // 기둥인지 보인지

            Frame(int[] frame) {
                this.x = frame[0];
                this.y = frame[1];
                this.a = frame[2];
            }

            @Override
            public int compareTo(Object obj) {
                Frame frame = (Frame) obj;
                if (this.x != frame.x) return this.x - frame.x;
                else if (this.y != frame.y) return this.y - frame.y;
                else return this.a - frame.a;
            }

            private int[] getData(){
                return new int[] {x, y, a};
            }
        }

        int N;
        int[][] BF;
        int[][] map;
        PriorityQueue<Frame> pq = new PriorityQueue<>();

        public int[][] solution(int n, int[][] build_frame) {
            N = n + 2;
            BF = build_frame;
            map = new int[N][N];
            Set<String> set = new HashSet<>();

            for (int i = 0; i < map.length; ++i) {
                Arrays.fill(map[i], -1);
            }

            for (int i = 0; i < build_frame.length; ++i) {
                StringBuilder sb = new StringBuilder();
                int x = BF[i][0];
                int y = BF[i][1];
                int a = BF[i][2];
                int b = BF[i][3];
                int temp = map[y][x];

                for(int j = 0; j <= 2; ++j) sb.append(BF[i][j]);
                String info = sb.toString();
                sb.delete(0, sb.length());
                // 먼저 넣고
                if(b == 1) {
                    map[y][x] = a;
                    set.add(info);
                }
                else {
                    map[y][x] = -1;
                    set.remove(info);
                }

                for(String val : set){
                    int[] arr = toIntArray(val.split(""));
                    Frame frame = new Frame(arr);
                    boolean ok = frame.a == 0 ? checkGidung(frame) : checkBo(frame);
                    if(!ok) {
                        map[y][x] = temp;
                        if (b == 1) set.remove(info);
                        else set.add(info);
                        break;
                    }
                }
            }

            int len = set.size();
            int[][] answer = new int[len][3];

            for(String info : set){
                int[] arr = toIntArray(info.split(""));
                pq.add(new Frame(arr));
            }

            for (int i = 0; i < len; ++i) {
                answer[i] = pq.poll().getData();
            }
            return answer;
        }


        public boolean checkGidung(Frame frame) {
            int x = frame.x;
            int y = frame.y;
            int a = frame.a;
            if (y == 0) return true;
            else if (checkLimit(true, x - 1, a) && map[y][x - 1] == 1) return true;// 보의 한쪽 위에 있을때
            else if (checkLimit(false, y - 1, a) && map[y - 1][x] == 0) return true; // 설치하려는 위치 아래 기둥이 있을 때
            return false;
        }

        public boolean checkBo(Frame frame) {
            int x = frame.x;
            int y = frame.y;
            int a = frame.a;
            if (checkLimit(false, y - 1, a)) {
                if (map[y - 1][x] == 0) return true;
                else if (checkLimit(true, x + 1, a) &&
                        map[y - 1][x + 1] == 0) return true;
            }
            if (checkLimit(true, x - 1, a) &&
                    checkLimit(true, x + 1, a)
            ) {
                return map[y][x - 1] == 1 && map[y][x + 1] == 1;
            }
            return false;
        }

        public boolean checkLimit(boolean isX, int val, int a) {
            if ((isX && a == 1) ||
                    (!isX && a == 0)) {
                if (val >= 0 && val < N - 1) return true;
            } else {
                if (val >= 0 && val < N) return true;
            }
            return false;
        }

        public int[] toIntArray(String[] arr){
            return Arrays.asList(arr).stream().mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] build = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] build2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        int[][] build3 = {{0,0,0,1}, {4,0,0,1}, {3,1,1,1}, {1,1,1,1}, {4,0,0,0}};
        s.solution(5, build3);
    }
}
