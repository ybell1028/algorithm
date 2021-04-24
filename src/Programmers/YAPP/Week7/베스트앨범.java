package Programmers.YAPP.Week7;

import java.util.*;

public class 베스트앨범 {
	static class Solution {
        public int[] solution(String[] genres, int[] plays) {
			HashMap<String, Integer> allPlay = new HashMap<>();
			HashMap<String, HashMap<String, Integer>> eachPlay = new HashMap<>();
			
			int len = genres.length;
			for(int i = 0; i < len; ++i){
				allPlay.put(genres[i], allPlay.getOrDefault(genres[i], 0) + plays[i]);
				eachPlay.computeIfAbsent(genres[i], s -> new HashMap<>()).put(String.valueOf(i), plays[i]);
			}

			int answerLen = 0;
            for(String each : eachPlay.keySet()){
                if(eachPlay.get(each).size() >= 2){
                    answerLen += 2;
                } else answerLen += 1;
            }

            int[] answer = new int[answerLen];

            Map<String, Integer> all = sortMapByValue(allPlay); // value값으로 정렬
            int idx = 0;
			for(String key : all.keySet()){
                Map<String, Integer> each = sortMapByValue(eachPlay.get(key));
                int cnt = eachPlay.get(key).size() >= 2 ? 2 : 1;
                for(String eachKey : each.keySet()){
                      if(cnt-- <= 0) break;
                      answer[idx++] = Integer.parseInt(eachKey);
                }
            }
            return answer;
		}

        public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
            List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
            Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : entries) {
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        }
		
		public static void main(String[] args){
			Solution s = new Solution();
            String[] genres = {"classic", "pop", "classic", "classic", "pop", "citypop"};
            int[] plays = {500, 600, 150, 800, 2500, 1000};
            System.out.println(s.solution(genres, plays));
		}
    }
}
