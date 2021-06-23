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

            if(cacheSize == 0){
                return cities.length * 5;
            }

            for(String city : cities){
                if(list.contains(city.toLowerCase(Locale.ROOT))){ // LRU라 큐 갱신해줘야함
                    list.remove(city.toLowerCase(Locale.ROOT));
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 1;
                } else if(list.size() < cacheSize) {
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 5;
                } else {
                    list.remove(0);
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 5;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] cities0 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities2 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(sol.solution(0, cities3));
    }
}
