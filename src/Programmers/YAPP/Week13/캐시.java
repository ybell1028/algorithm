package Programmers.YAPP.Week13;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

public class 캐시 {
    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            List<String> list = new LinkedList<>();
            //캐시 크기가 0이면 모든 데이터가 cache miss이므로 cities의 크기에 5를 곱해 반환
            if(cacheSize == 0){
                return cities.length * 5;
            }

            for(String city : cities){
                // 도시명은 대소문자를 구분하지 않음
                if(list.contains(city.toLowerCase(Locale.ROOT))){ //cache hit 일때
                    // LRU라 리스트(캐시) 갱신
                    list.remove(city.toLowerCase(Locale.ROOT));
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 1;
                } else if(list.size() < cacheSize) { // cache miss 일때
                    //캐시가 다 차지 않았으면 그냥 넣어줌
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 5;
                } else { // cache miss 일때
                    //캐시가 다 찼으면 가장 적게 쓰인 데이터(가장 앞 데이터) 삭제
                    list.remove(0);
                    //새 데이터 추가
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 5;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = ":";

        StringBuilder sb = new StringBuilder("123");
        String[] cities0 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities2 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(sol.solution(0, cities3));
    }
}
