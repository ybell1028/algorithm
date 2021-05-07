package Programmers.YAPP.Week9;

import java.util.*;
import java.util.stream.Collectors;

public class 후보키 {
    static class Solution {
        public int solution(String[][] relation) {
            int rowLen = relation.length;
            int colLen = relation[0].length;
            Set<String> combiSet = new HashSet<>();
            for (int row = 0; row < rowLen; ++row) {
                for (int i = 1; i < (1 << colLen); i++) { // colLen = 속성의 갯구
                    StringBuilder key = new StringBuilder();
                    for (int j = 0; j < colLen; j++) {
                        if ((i & (1 << j)) > 0) key.append(j);
                    }
                    combiSet.add(key.toString());
                }
            }
            List<String> combiList = new ArrayList<>(combiSet);
            Collections.sort(combiList);

            for (int combiIdx = 0; combiIdx < combiList.size(); ++combiIdx) {
                HashMap<String, String> hm = new HashMap<>();
                List<String> splitList = Arrays.asList(combiList.get(combiIdx).split(""));
                for (String[] rel : relation) {
                    String attributes = splitList.stream()
                            .map(s -> rel[Integer.parseInt(s)])
                            .collect(Collectors.joining());
                    hm.putIfAbsent(attributes, combiList.get(combiIdx));
                }
                if(hm.size() == rowLen) { // 유일성 만족
                    for(int i = 0; i < combiList.size(); ++i){
                        String next = combiList.get(i);
                        StringBuilder sb = new StringBuilder();
                        for(String s : splitList) sb.append(s);
                        if(sb.toString().equals(next)) continue;
                        List<String> nextList = Arrays.asList(next.split(""));
                        int correct = splitList.stream()
                                .filter(nextList::contains)
                                .collect(Collectors.toList())
                                .size();
                        if(correct == splitList.size()){
                            if(combiIdx > i) combiIdx--;
                            combiList.remove(i--);
                        }
                    }
                } else combiList.remove(combiIdx--);// 유일성 X
            }
            return combiList.size();
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
            String[][] relation2 = {{"100","ryan","music","2"}, {"100","ap","music","2"}};
            String[][] relation3 = {{"100","ryan","music","4"}, {"200","ap","physics","2"}, {"300","req","music","1"}, {"400","res","art","3"}, {"500","res","music","5"}, {"600","res","physics","6"}};
            System.out.println(s.solution(relation2));
        }
    }
}
