package Programmers.YAPP.Week20;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 셔틀버스 {
    class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int departT = 9 * 60;
            List<Integer>[] list = new List[n];
            
            for (int i = 0; i < timetable.length; i++) {
                int hh = Integer.parseInt(timetable[i].split(":")[0]);
                int mm = Integer.parseInt(timetable[i].split(":")[1]);
                int time = hh*60 + mm;
                queue.add(time);
            }

            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
                
                while(!queue.isEmpty()) {
                    int arrivedT = queue.poll();
                    if(arrivedT <= departT && list[i].size() < m) {
                        list[i].add(arrivedT);
                    }
                    else {
                        queue.add(arrivedT);
                        break;
                    }
                    answer = arrivedT - 1;
                }
                departT += t;
            }
            
            if(list[n - 1].size() < m) {
                answer = departT - t;
            }
            String hh = String.format("%02d",answer/60);
            String mm = String.format("%02d",answer%60);
            return hh + ":" + mm;
        }
    }
}
