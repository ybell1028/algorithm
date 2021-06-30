package Programmers.YAPP.Week14;

import java.util.*;

public class n진수게임 {
    static class Solution {
        public String solution(int n, int t, int m, int p) {
            int num = 0;
            StringBuilder sb = new StringBuilder();
            while(true) {
                sb.append(convert(n, num++));
                if(sb.length() >= m * (t - 1) + p) break;
            }
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < t; ++i){
                result.append(sb.substring(i * m + p - 1, i * m + p));
            }
            return result.toString();
        }

        public String convert(int n, int num){
            if(num == 0) return "0";
            StringBuilder sb = new StringBuilder();
            int temp = num;
            while(temp > 0) {
                int remain = temp % n;
                if(remain <= 9) sb.append(remain);
                else sb.append((char) (55 + remain));
                temp /= n;
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(16, 16, 2, 2));
    }
}
