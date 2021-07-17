package Programmers.YAPP.Week16;

import java.util.Stack;
import java.util.StringTokenizer;

public class 표편집_답 {
    static class Solution {
        public String solution(int n, int k, String[] cmd) {
            StringTokenizer st;
            String command;
            Stack<Integer> stack = new Stack<>();
            int tableSize = n;
            for(String c : cmd) {
                st = new StringTokenizer(c);
                command = st.nextToken();
                if(command.equals("U")) {
                    k -= Integer.parseInt(st.nextToken());
                } else if(command.equals("D")) {
                    k += Integer.parseInt(st.nextToken());
                } else if(command.equals("C")) {
                    stack.push(k);
                    tableSize -= 1;
                    if(k == tableSize) k -= 1;
                } else {
                    int removed = stack.pop();
                    if(k >= removed) k += 1;
                    tableSize += 1;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < tableSize; i++) {
                sb.append('O');
            }
            while(!stack.isEmpty()) {
                sb.insert(stack.pop().intValue(), 'X');
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        String[] cmd3 = {"C", "C", "C", "C", "C", "C", "C", "C", "C", "C"};
        String[] cmd4 = {"C", "C", "C", "U 2", "D 1", "D 1", "Z"};
        String[] cmd5 = {"C", "C", "C", "C", "C", "Z", "Z", "Z", "C"};
        System.out.println(s.solution(8, 2, cmd2));
    }
}
