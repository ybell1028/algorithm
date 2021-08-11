package Programmers.YAPP.Week18;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴리뉴얼 {
    class Solution {
        public final int MAX = 11;

        public String[] solution(String[] orders, int[] course) {
            Arrays.sort(orders);

            Map<String, Integer> hm[] = new HashMap[MAX];
            for(int i = 0; i < MAX; ++i){
                hm[i] = new HashMap<>();
            }

            StringBuilder sb;
            int len;
            for(String order : orders) {
                String[] temp = order.split("");
                Arrays.sort(temp);
                for(int i = 0; i < (1 << order.length()); ++i){
                    sb = new StringBuilder();
                    for(int j = 0; j < order.length(); ++j) {
                        if((i & (1 << j)) > 0) sb.append(temp[j]);
                    }
                    len = sb.length();
                    if(len < 2) continue;
                    String key = sb.toString();
                    hm[len].put(key, hm[len].getOrDefault(key, 0) + 1);
                }
            }

            Set<String> ts = new TreeSet<>();

            for(int i : course){
                List<Map.Entry<String, Integer>> sortedMenu = new ArrayList<>(hm[i].entrySet());
                if(sortedMenu.isEmpty()) continue;
                sortedMenu.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
                int maxVal = sortedMenu.get(0).getValue();
                ts.addAll(sortedMenu.stream()
                        .filter(e -> e.getValue() > 1 && e.getValue() == maxVal)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet())
                );
            }
            return ts.toArray(new String[0]);
        }
    }
}
