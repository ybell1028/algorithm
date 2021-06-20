package Programmers.YAPP.Week10;

import java.util.*;

public class 다단계칫솔판매 {
    //enroll에 민호의 이름은 없습니다. 따라서 enroll의 길이는 민호를 제외한 조직 구성원의 총 수
    //enroll 에 등장하는 이름은 조직에 참여한 순서에 따릅니다.

    //referral 내에서 i 번째에 있는 이름은 배열 enroll 내에서 i 번째에 있는 판매원을 조직에 참여시킨 사람의 이름

    //seller 내의 i 번째에 있는 이름은 i 번째 판매 집계 데이터가 어느 판매원에 의한 것인지를 나타냅니다.
    //seller 에는 같은 이름이 중복해서 들어있을 수 있습니다.

    //amount 내의 i 번째에 있는 수는 i 번째 판매 집계 데이터의 판매량을 나타냅니다.
    //판매량의 범위, 즉 amount 의 원소들의 범위는 1 이상 100 이하인 자연수입니다.
    //칫솔 한 개를 판매하여 얻어지는 이익은 100 원으로 정해져 있습니다.
    static class Solution {
        static Map<String, ArrayList<String>> erMap = new HashMap<>();
        static Map<String, Integer> saMap = new HashMap<>();
        static Map<String, Integer> resultMap = new HashMap<>();
        static int[] result;
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            result = new int[enroll.length];
            for(int i = 0; i < seller.length; ++i){
                saMap.put(seller[i], saMap.getOrDefault(seller[i], 0) + amount[i] * 100);
            }
            for(int i = 0; i < referral.length; ++i){
                if(saMap.get(enroll[i]) == null) resultMap.put(enroll[i], 0);
                else resultMap.put(enroll[i], saMap.get(enroll[i]));
                if(referral[i].equals("-")) continue;
                erMap.computeIfAbsent(referral[i],  s -> new ArrayList<>()).add(enroll[i]);
            }

            for(int i = 0; i < enroll.length; ++i){
                test(enroll[i]);
            }

            int[] answer = {};
            return answer;
        }

        public int test(String e){
            ArrayList<String> erList = erMap.get(e);
            int origin = resultMap.get(e);
            if(erList == null) {
                resultMap.put(e, (int)(origin * 0.9));
                return (int)(origin * 0.1);
            }
            else {
//                resultMap.put(e, resultMap.get(e) + (int)(origin * 0.1));
                for(String key : erMap.keySet())
                    resultMap.put(e, resultMap.get(e) + test(key));
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        s.solution(enroll, referral, seller, amount);
    }
}
