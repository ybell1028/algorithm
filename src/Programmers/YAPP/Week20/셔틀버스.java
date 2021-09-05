package Programmers.YAPP.Week20;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 셔틀버스 {
    class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int departT = 9 * 60; // 버스 도착 시간
            List<Integer>[] list = new List[n];
            
            for (int i = 0; i < timetable.length; i++) {
                int hh = Integer.parseInt(timetable[i].split(":")[0]);
                int mm = Integer.parseInt(timetable[i].split(":")[1]);
                int time = hh * 60 + mm;
                queue.add(time);
            }

            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
                
                while(!queue.isEmpty()) {
                    int arrivedT = queue.poll(); // 사람들이 줄서기 시작한 시간
                    if(arrivedT <= departT && list[i].size() < m) { // 줄 선 시간이 버스 도착 시간과 같거나 전이면 && 버스에 좌석이 남아 있다면
                        list[i].add(arrivedT); // 리스트에 추가
                    }
                    else { // 아니면
                        queue.add(arrivedT); // 다시 큐에 넣는다.
                        break;
                    }
                    answer = arrivedT - 1;
                }
                departT += t; // t를 매번 추가해준다.
            }
            
            if(list[n - 1].size() < m) { // 막차에 좌석이 남아 있다면?
                answer = departT - t; // 막차 시간에 딱 맞춰 가면 된다
            }
            String hh = String.format("%02d",answer / 60);
            String mm = String.format("%02d",answer % 60);
            return hh + ":" + mm;
        }
    }
}
