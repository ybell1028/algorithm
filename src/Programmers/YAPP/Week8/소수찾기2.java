package Programmers.YAPP.Week8;

import java.util.*;

public class 소수찾기2 {
    // 25분 컷!
    class Solution {
        int LEN;
        String[] num;
        boolean[] visit;
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        public int solution(String numbers) {
            LEN = numbers.length();
            num = numbers.split("");
            boolean[] filter = new boolean[10000000];
            visit = new boolean[LEN];

            Arrays.fill(filter, true);

            filter[0] = false;
            filter[1] = false;

            for(int i = 2; i < Math.sqrt(filter.length); ++i){
                if(!filter[i]) continue;
                for(int j = i + i; j < filter.length; j += i){
                    filter[j] = false;
                }
            }

            DFS(0);
            int answer = 0;

            for(int i : set){
                if(filter[i]) answer++;
            }

            return answer;
        }

        public void DFS(int depth){
            for(int i = 0; i < LEN; ++i){
                if(!visit[i]){
                    visit[i] = true;
                    sb.append(num[i]);
                    set.add(Integer.parseInt(sb.toString()));
                    DFS(depth + 1);
                    sb.delete(depth, depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
