package Programmers.YAPP.Week22;

import java.util.*;

public class 추석트래픽 {
    static class Solution {
        class Req implements Comparable {
            public int start;
            public int end;
            public int process;

            Req(int end, String pro) {
                this.end = end;
                this.process = (int) (Double.parseDouble(pro) * 1000.0);
                this.start = end - process + 1;
            }

            @Override
            public int compareTo(Object obj) {
                Req req = (Req) (obj);
                return this.end - req.end;
            }
        }

        int max = 0;
        PriorityQueue<Req> pq;
        Stack<Req> stack;

        public int solution(String[] lines) {
            //lines 배열은 응답완료시간 S를 기준으로 오름차순 정렬되어 있다.
            // 응답완료시간 S는 작년 추석인 2016년 9월 15일만 포함 -> 날짜는 필요없음
            int len = lines.length;
            String[][] split = new String[lines.length][2];
            pq = new PriorityQueue<>();
            stack = new Stack<>();

            for (int i = 0; i < len; ++i) {
                String[] temp = lines[i].split(" ");
                temp[2] = temp[2].replace("s", "");
                pq.add(new Req(timeToInt(temp[1]), temp[2]));
            }
            while (!pq.isEmpty()) {
                Req req = pq.peek();
                int beforeSec = req.end;
                int afterSec = req.end + 1000;
                while (!pq.isEmpty()) {
                    Req req1 = pq.poll();
                    if ((req1.start >= beforeSec && req1.start < afterSec) ||
                            (req1.end >= beforeSec && req1.end < afterSec) ||
                            (req1.start <= beforeSec && req1.end >= afterSec)) {
                        stack.push(req1);
                    } else {
                        pq.add(req1);
                        break;
                    }
                }
                max = Math.max(stack.size(), max);
                while (!stack.isEmpty()) pq.add(stack.pop());
                pq.poll();
            }
            return max;
        }

        public int timeToInt(String time) {
            double result = 0;
            StringTokenizer st = new StringTokenizer(time, ":");
            double criteria = 60 * 60 * 1000;
            while (st.hasMoreTokens()) {
                result += Double.parseDouble(st.nextToken()) * criteria;
                if (criteria > 1000) criteria /= 60;
            }
            return (int) (result);
        }
    }
}
