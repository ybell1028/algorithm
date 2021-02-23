package Programmers.Hash;

import java.util.*;

//3시 17분 시작
//가독 성구리고 로직도 구린거같다..
public class 베스트앨범 {
    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            // 속한 노래가 많이 재생된 장르 > 장르내에서 많이 재생 된 곡 > 고유번호 낮음 > 고유번호 높음
            HashMap<String, HashMap<Integer, Integer>> origin = new HashMap<>();
            HashMap<String, Integer> genreRank = new HashMap<>();

            for(int i = 0; i < genres.length; ++i){ // 고유번호 i
                origin.computeIfAbsent(genres[i], s -> new HashMap<>()).put(i, plays[i]);
                genreRank.put(genres[i], genreRank.getOrDefault(genres[i], 0) + plays[i]);
            }

            List<Map.Entry<String, Integer>> grList = new LinkedList<>(genreRank.entrySet());

            Collections.sort(grList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int comparision = (o1.getValue() - o2.getValue()) * -1; // 빼기 결과가 음수라면 참, 양수라면 거짓
                    return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
                }
            });

            Map<String, Integer> sortedGR = new LinkedHashMap<>();
            for(Iterator<Map.Entry<String, Integer>> iter = grList.iterator(); iter.hasNext();){
                Map.Entry<String, Integer> entry = iter.next();
                sortedGR.put(entry.getKey(), entry.getValue());
            }

            int aIdx = 0;
            int alen = 0;

            for(String gkey : origin.keySet()){
                int size = origin.get(gkey).size();
                if(size >= 2) alen += 2;
                else alen += size;
            }

            int[] answer = new int[alen];

            for(String gkey : sortedGR.keySet()){
                HashMap<Integer, Integer> playRank = origin.get(gkey); // gkey는 재생수 높은 순으로 반복됨

                List<Map.Entry<Integer, Integer>> prList = new LinkedList<>(playRank.entrySet()); // 장르마다 재생수 내림차순으로 정렬

                Collections.sort(prList, new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        int comparision = (o1.getValue() - o2.getValue()) * -1; // 빼기 결과가 음수라면 참, 양수라면 거짓
                        return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
                    }
                });
                Map<Integer, Integer> sortedPR = new LinkedHashMap<>(); // 정렬된 Map
                for(Iterator<Map.Entry<Integer, Integer>> iter = prList.iterator(); iter.hasNext();){
                    Map.Entry<Integer, Integer> entry = iter.next();
                    sortedPR.put(entry.getKey(), entry.getValue());
                }

                int cnt = 2;

                for(int pkey : sortedPR.keySet()){
                    if(cnt <= 0) break;
                    answer[aIdx++] = pkey;
                    cnt--;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] genre = {"classic"};
        int[] plays = {500};
        System.out.println(s.solution(genre, plays));
    }
}
