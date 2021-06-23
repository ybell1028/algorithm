package Programmers.YAPP.Week13;

import java.util.*;

public class 튜플 {
    static class Solution {
        public int[] solution(String s) {
            // 앞 뒤 괄호 제거
            StringBuilder sb = new StringBuilder(s);
            sb.delete(0, 2);
            sb.delete(sb.length() - 2, sb.length());
            // "},{" 기준으로 split
            String[] first = sb.toString().split("},\\{");

            List<String> strList = Arrays.asList(first);
            int[] answer = new int[strList.size()];
            Comparator<String> c = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.compare(o1.length(), o2.length());
                }
            };
            //재정의한 comparator를 기준으로 문자여을 길이별 오름차순으로 정렬
            Collections.sort(strList, c);

            Map<String, Integer> previous = new HashMap<>();
            Map<String, Integer> present = new HashMap<>();

            int idx = 0;
            for(String fir : first){ // first는 위에서 "},{" 기준으로 split한 배열
                String[] second = fir.split(",");
                for(String sec: second){ // second는 first를 한번더 ","를 기준으로 split한 배열
                    // sec를 key로 하는 value가 없다면 0을 put해주고
                    // value가 존재한다면 1을 더해준다 = key 갯수를 세어준다.
                    present.put(sec, present.getOrDefault(sec, 0) + 1);
                }
                for(String key : present.keySet()){
                    //만약 이전 집합에 포함되지 않는 새로운 수가 이번 집합에 있다면?
                    //결과에 추가
                    if(previous.get(key) == null) answer[idx++] = Integer.parseInt(key);
                    //이전 집합에도 있었고 이번 집합에도 있지만 갯수가 늘어났다면?
                    //결과에 추가 (중복되는 수 세어주기)
                    else if(present.get(key) - previous.get(key) > 0){
                        answer[idx++] = Integer.parseInt(key);
                    }
                }
                previous = present; // 다음 루프를 위해 이번 집합을 이전 집합으로 바꿈
                present = new HashMap<>();
            }
            return answer;
        }
    }

    // "{{4,2,3},{3},{2,3,4,1},{2,3}}" = [3, 2, 4, 1]
    //가장 크기가 작은게 앞에 온다

    public static void main(String[] args) {

        String s3 = "{{123}}";
        String s4 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        String s5 = "{{2,3,2},{3},{1,2,3,2},{2,3}}";
        Solution sol = new Solution();

        sol.solution(s3);
    }
}
