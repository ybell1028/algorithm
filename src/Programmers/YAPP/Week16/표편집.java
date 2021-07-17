package Programmers.YAPP.Week16;

import java.util.*;

public class 표편집 {
    static class Solution {
        int N;
        boolean[] exist;
        Stack<Integer> stack = new Stack<>();
        TreeSet<Integer> clear = new TreeSet<>();
        public String solution(int n, int k, String[] cmd) {
            N = n;
            String command;
            StringTokenizer st;
            exist = new boolean[n];
            Arrays.fill(exist, true);
            for(String c : cmd) {
                st = new StringTokenizer(c);
                command = st.nextToken();
                if(c.length() > 1){
                    int temp = k;
                    int num = Integer.parseInt(st.nextToken());
                    if(command.equals("U")) {
                        temp -= num;
                        if(clear.subSet(temp, k).size() == 0) k = temp; // 그냥 k와 temp 사이에 false가 존재하면 안된다.
                        else k = temp - countFalse(temp, k);
                    }
                    else {
                        temp += num;
                        if(clear.subSet(k + 1, temp + 1).size() == 0) k = temp;
                        else k = temp + countFalse(k, temp);
                    }
                } else {
                    if(command.equals("C")){
                        exist[k] = false;
                        stack.push(k);
                        clear.add(k);
                        k = searchTrueClear(k);
                    } else { // "Z"
                        if(stack.size() == N) k = stack.peek();
                        int restored = stack.pop();
                        clear.remove(restored);
                        exist[restored] = true;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; ++i){
                if(exist[i]) sb.append("O");
                else sb.append("X");
            }
            return sb.toString();
        }

        public int searchTrueClear(int start){
            for(int i = start + 1; i < N; ++i){
                if(exist[i]) return i;
            }
            for(int i = start - 1; i >= 0; --i){
                if(exist[i]) return i;
            }
            return 0;
        }

        public int countFalse(int start, int end){
            int cnt = 0;
            for(int i = start; i <= end; i++){
                if(!exist[i]) cnt++;
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        String[] cmd3 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        String[] cmd4 = {"C", "C", "C", "U 2", "D 1", "D 1", "Z"};
        String[] cmd5 = {"C", "C", "C", "C", "C", "Z", "Z", "Z", "C"};
        System.out.println(s.solution(5, 0, cmd5));
    }
}
