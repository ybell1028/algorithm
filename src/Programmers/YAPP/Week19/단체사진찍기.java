package Programmers.YAPP.Week19;

import java.util.*;

public class 단체사진찍기 {

    static class Solution {
        static int cnt;
        static final int SIZE = 8;
        public int solution(int n, String[] data) {
            cnt = 0;
            String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

            permutation(SIZE, SIZE, new String[SIZE], friends, data, 0, 0);

            return cnt;
        }

        public void permutation(int n, int r, String[] perms, String[] friends, String[] data, int depth, int flag){
            if(depth == r){
                StringBuilder sb = new StringBuilder();
                for(String p : perms) sb.append(p);
                if(conditionOk(sb.toString(), data)) cnt++;
                return;
            }
            for(int i = 0; i < n; ++i){
                if((flag & (1 << i)) == 0){
                    perms[depth] = friends[i];
                    permutation(n, r, perms, friends, data, depth + 1, flag | 1 << i);
                }
            }
        }

        public boolean conditionOk(String result, String[] data) {
            boolean passed = true;
            for(String d : data){
                String[] split = d.split("");
                int expected = Integer.parseInt(split[4]) + 1;
                int diff = Math.abs(result.indexOf(split[0]) - result.indexOf(split[2]));
                switch(split[3]){
                    case "=" : {
                        passed = diff == expected;
                        break;
                    }
                    case "<" : {
                        passed =  diff < expected;
                        break;
                    }
                    case ">" : {
                        passed = diff > expected;
                        break;
                    }
                    default : break;
                }

                if(!passed) break;
            }
            return passed;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] data = {"N~F=0", "R~T>2", "M~C<2", "C~M>1"};
        System.out.println(s.solution(2, data));
    }
}
