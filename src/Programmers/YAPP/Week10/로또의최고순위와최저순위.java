package Programmers.YAPP.Week10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 로또의최고순위와최저순위 {
    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            ArrayList<Integer> lottoList = new ArrayList<>();
            ArrayList<Integer> winList = new ArrayList<>();
            int zero = 0;
            for(int i = 0; i < lottos.length; ++i){
                if(lottos[i] == 0) zero++;
                lottoList.add(lottos[i]);
                winList.add(win_nums[i]);
            }
            winList.retainAll(lottoList);
            int cor = winList.size();
            int[] answer = new int[2];
            answer[0] = rank(cor + zero);
            answer[1] = rank(cor);
            return answer;
        }

        public int rank(int c) {
            switch (c) {
                case 6:
                    return 1;
                case 5:
                    return 2;
                case 4:
                    return 3;
                case 3:
                    return 4;
                case 2:
                    return 5;
            }
            return 6;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            int[] lottos = {44, 1, 0, 0, 31, 25};
            int[] win_nums = {31, 10, 45, 1, 6, 19};
            System.out.println(s.solution(lottos, win_nums));
        }
    }
}
