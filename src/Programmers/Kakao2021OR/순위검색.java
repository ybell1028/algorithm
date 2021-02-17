package Programmers.Kakao2021OR;

import java.util.*;

public class 순위검색 {
    static class Solution {
        // 참고 : https://girawhale.tistory.com/94
        public int[] solution(String[] info, String[] query) {
            Map<String, List<Integer>> infos = new HashMap<>();
            for (String in : info) {
                String[] split = in.split(" ");
                int score = Integer.parseInt(split[4]);

                //점수를 제외한 info로 가능한 모든 조합을 구해 key를 만든다
                for (int i = 0; i < (1 << 4); i++) { // info 하나당 조건이 4가지니까 총 나올 수 있는 경우의 수 = 16(아무것도 없는것 포함)
                    StringBuilder key = new StringBuilder();

                    for (int j = 0; j < 4; j++) { // 요건 대체 어케한거지 (나중에 써먹자)
                        if ((i & (1 << j)) > 0) key.append(split[j]);
                    }
                    //구한 Key마다 List를 생성해 점수를 add
                    //만들어진 key를 infos에 넣어야 하는데 만약 새로운 key가 나와 기존에 값이 없다면 Null Exception이 발생하게 된다.
                    // 따라서 computeIfAbsent() 메서드를 활용해 value가 없다면 new ArrayList<>()를 생성해주고 List에 점수를 넣어주었다.
                    infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
                }
            }

            //점수 List를 오름 차순으로 배열
            for (Map.Entry<String, List<Integer>> entry : infos.entrySet())
                entry.getValue().sort(null);

            int[] answer = new int[query.length];
            List<Integer> empty = new ArrayList<>();
            for (int i = 0; i < query.length; i++) {
                //query에서 -를 제외한 조건으로 key를 만들고 점수 List를 가져온다.
                String[] split = query[i].replaceAll("-", "").split(" and | ");
                String key = String.join("", split[0], split[1], split[2], split[3]);
                int score = Integer.parseInt(split[4]);

                //만약 key가 기존에 없던 새로운 조건들로만 이루어졌다면
                //null이 반환되기 때문에 getOrDefault()메서드를 통해 빈 List(empty)를 반환하였다.
                List<Integer> list = infos.getOrDefault(key, empty);

                //중요 ! info도 5만개면서, query의 수도 10만개이기 때문에 단순 검색으로는 불가능해 이분탐색을 활용하였다.
                int s = 0, e = list.size();

                while (s < e) {
                    int mid = (s + e) / 2;

                    if (list.get(mid) < score) s = mid + 1;
                    else e = mid;
                }

                answer[i] = list.size() - s;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        s.solution(info, query);
    }
}
