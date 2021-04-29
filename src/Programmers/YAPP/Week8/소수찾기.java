package Programmers.YAPP.Week8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수찾기 {
    static class Solution {
        static List<String> list = new ArrayList<>();
        static final int LEN = 10000000;
        static boolean[] isPrime;
        static boolean[] check;
        static int prime = 0;
        public int solution(String numbers) {
            isPrime = new boolean[LEN + 1];
            check = new boolean[LEN + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for(int i = 2; i <= Math.sqrt(LEN); ++i){ // 에라토스테네스의 체
                if(!isPrime[i]) continue;
                for(int j = i + i; j <= LEN; j+=i){
                    isPrime[j] = false;
                }
            }

            boolean[] visited = new boolean[numbers.length()];
            for(int i = 0; i < numbers.length(); ++i){
                list.add(numbers.substring(i, i + 1));
            }
            int len = 0;
            while(len <= numbers.length()){
                for(int i = 1; i <= numbers.length(); ++i){
                    combi(visited, 0, numbers.length(), i);
                }
                list.add(list.remove(0)); // 앞에 빼고 뒤에 다시 넣어주기
                len++;
            }
            return prime;
        }

        public static void combi(boolean[] visited, int start, int n, int r){
            if(r == 0){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < visited.length; ++i){
                    if(visited[i]) sb.append(list.get(i));
                }
                int num = Integer.parseInt(sb.toString());
                if(!check[num]) {
                    if(isPrime[num]) {
                        System.out.println(num);
                        prime++;
                    }
                    check[num] = true;
                }
            } else {
                for (int i = start; i < n; ++i) {
                    visited[i] = true;
                    combi(visited, i + 1, n, r - 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("123455"));
    }
}
