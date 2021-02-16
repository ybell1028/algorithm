package Programmers.Kakao2021OR;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class 순위검색 {
    static class Solution {
        public int[] solution(String[] info, String[] query) {
            int cnt = 0;
            int[] answer = new int[query.length];
            String si[][] = new String[info.length][];
            for(int i = 0; i < si.length; ++i){
                si[i] = info[i].split(" ");
            }

            for (int i = 0; i < query.length; ++i) { // 매번 전처리를 할께 아니라 한방에 해놓고 돌리자
                //parse query
                String[] sq = query[i].split(" and ");
                String[] temp = sq[3].split(" ");
                sq[3] = temp[0];
                int qpoint = Integer.parseInt(temp[1]);
                for (int j = 0; j < info.length; ++j) {
                    boolean green = true;
                    if(Integer.parseInt(si[j][si[j].length - 1]) < qpoint) continue;
                    for(int k = 0; k < si[j].length - 1; ++k){
                        if("-".equals(si[j][k]) || "-".equals(sq[k])) continue;
                        if(!sq[k].equals(si[j][k])){
                            green = false;
                            break;
                        }
                    }
                    if (green) {
                        cnt++;
                    }
                }
                answer[i] = cnt;
                System.out.println(answer[i]);
                cnt = 0;
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
