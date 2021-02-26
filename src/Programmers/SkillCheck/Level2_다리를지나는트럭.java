package Programmers.SkillCheck;

import Programmers.Kakao2021OR.신규아이디추천;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_다리를지나는트럭 {
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            //bridge_length - 다리길이, weight - 다리가 견딜 수 있는 무게, truck_weights - 트럭 별 무게
            int num = truck_weights.length;
            int time = 0;
            int[] enter = new int[num]; // 진입한 시간
            int cWeight = 0; // 현재 다리에 가해지고 있는 무게

            Queue<Integer> arrive = new LinkedList<>(); // 다리를 지난 트럭
            Queue<Integer> cross = new LinkedList<>(); // 다리를 건너는 트럭
            Queue<Integer> waiting = new LinkedList<>(); // 대기중인 트럭

            for (int i = 0; i < num; ++i) {
                waiting.add(truck_weights[i]);
            }

            int eEnd = 0;
            int eStart = 0;
            while (arrive.size() < num) {
                for (int i = eStart; i < eEnd; i++) {
                    if (time - enter[i] == bridge_length) {
                        cWeight -= cross.peek();
                        arrive.add(cross.poll());
                        eStart++;
                    }
                }
                if (waiting.size() > 0 && cWeight + waiting.peek() <= weight) {
                    int w = waiting.poll();
                    cWeight += w;
                    cross.add(w);
                    enter[eEnd++] = time;
                }
                time++;
            }
            return time;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] truck_weight = {7, 4, 5, 6};
        System.out.println(s.solution(2, 10, truck_weight));
    }
}
