package Programmers.YAPP.Week17;

import java.util.*;

public class 순위검색 {
    static class Solution {
        public int[] solution(String[] info, String[] query) {
            final int LEN = 4;
            int[] answer = new int[query.length];
            StringBuilder sb;
            Map<String, ArrayList<Integer>> infoMap = new HashMap<>();
            for(String str : info){
                String[] temp = str.split(" ");
                for(int i = 0; i < (1 << LEN); ++i){
                    sb = new StringBuilder();
                    for(int j = 0; j < LEN; ++j){
                        if((i & (1 << j)) > 0) sb.append(temp[j]);
                    }
                    infoMap.computeIfAbsent(sb.toString(), s -> new ArrayList<>()).add(Integer.parseInt(temp[4]));
                }
            }
            for(String key : infoMap.keySet()){
                infoMap.get(key).sort(null);
            }

            ArrayList<Integer> empty = new ArrayList<>();
            for(int i = 0; i < query.length; ++i){
                String score = query[i].split(" ")[7];
                String refined = query[i]
                        .replace(score, "")
                        .replace("-", "")
                        .replace("and", "")
                        .replace(" ", "");
                ArrayList<Integer> list = infoMap.getOrDefault(refined, empty);
                answer[i] = list.size() - binarySearch(list, Integer.parseInt(score));
            }
            return answer;
        }

        public int binarySearch(ArrayList<Integer> list, int score){
            int start = 0;
            int end = list.size();
            while(start < end){
                int mid = (start + end) / 2;
                if(list.get(mid) < score) start = mid + 1;
                else end = mid;
            }
            return start;
        }
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        Solution s = new Solution();
        s.solution(info, query);
    }
}
