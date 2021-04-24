package Programmers.YAPP.Week7;

import java.util.*;

public class 더맵게 {
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 1;
            MinHeap mh = new MinHeap();

            for (int sco : scoville) {
                mh.push(sco);
            }

            int newSco;
            int mixedSco;
            while (mh.list.get(1) < K && mh.list.size() >= 3) {
                newSco = mh.delete();
                mixedSco = mh.delete();
                mh.push(newSco + mixedSco * 2);
                answer++;
            }

            if(mh.list.size() == 2 && mh.list.get(1) < K) answer++;

            if(answer >= scoville.length) return -1;
            else return answer;
        }

        public static class MinHeap {
            public ArrayList<Integer> list;

            MinHeap() {
                list = new ArrayList<>();
                list.add(1000001);
            }

            private void swap(int p1, int p2) {
                int temp = list.get(p1);
                list.set(p1, list.get(p2));
                list.set(p2, temp);
            }

            private void push(int a) {
                list.add(a);
                int p = list.size() - 1;
                while (p / 2 >= 1 && list.get(p / 2) > list.get(p)) {
                    swap(p, p / 2);
                    p = p / 2;
                }
            }

            private int delete() {
                int p = 1;
                int del = list.get(1);
                if(list.size() <= 2) return list.remove(list.size() - 1);
                list.set(1, list.remove(list.size() - 1));

                while (p * 2 <= list.size() - 1) {  // 자기보다 작은게 있으면 교환
                    if (p * 2 + 1 <= list.size() - 1 && list.get(p * 2) > list.get(p * 2 + 1)) {
                        if (list.get(p) > list.get(p * 2 + 1)) {
                            swap(p, p * 2 + 1);
                            p = p * 2 + 1;
                        } else break;
                    } else {
                        if (list.get(p) > list.get(p * 2)) {
                            swap(p, p * 2);
                            p = p * 2;
                        } else break;
                    }
                }
                return del;
            }
        }
        public static void main(String args[]) {
            int[] sco1 = {1, 2, 3, 9, 10, 12};
            int[] sco2 = {1, 2, 10, 12, 3, 9, 4, 6, 7};

            int K = 200;

            Solution s = new Solution();

            System.out.println(s.solution(sco1, K));
        }
    }

}

