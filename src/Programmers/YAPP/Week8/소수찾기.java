package Programmers.YAPP.Week8;

import java.util.*;

public class 소수찾기 {
    static class Solution {
        static final int LEN = 10000000;
        static boolean[] isPrime;
        static int prime = 0;
        public int solution(String numbers) {
            isPrime = new boolean[LEN + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for(int i = 2; i <= Math.sqrt(LEN); ++i){ // 에라토스테네스의 체
                if(!isPrime[i]) continue;
                for(int j = i + i; j <= LEN; j+=i){
                    isPrime[j] = false;
                }
            }
            List<String> list = new ArrayList<>(Arrays.asList(numbers.split("")));
            Set<Integer> set = new HashSet<>();

            for(int i =0; i < list.size(); ++i){ // {1,2,3,4,5}, {2,3,4,5,1} ... 돌려가며 전체 조합을 얻는다.
                Collections.sort(list);
                String current = list.remove(i);
                combination(set, list, current);
                list.add(current);
            }

            for(int val : set){
                if(isPrime[val]) prime++;
            }
            return prime;
        }

        public static void combination(Set<Integer> set, List<String> list, String current){
            //set - 조합의 결과를 담는 Set
            //list - 현재 턴에서 남은 요소들
            //current - 현재 진행된 요소의 조합
            
            //다음거 추가하지 않는 경우
            set.add(Integer.parseInt(current));
            if(list.size() == 0) return;;

            //다음 거 추가하는 경우
            for(int i = 0; i < list.size(); ++i){
                String next = list.remove(0);
                combination(set, list, current + next);
                list.add(next);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("51234"));
    }
}
