package Programmers.YAPP.Week20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 셔틀버스2 {
    static class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            String answer = "";
            Map<String, Long> map = Arrays.stream(timetable)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            List<Map.Entry<String, Long>> sorted = new ArrayList<>(map.entrySet());

            Collections.sort(sorted, Map.Entry.comparingByKey());

            int idx = 0;
            for(int i = 0; i < n; i++) {
                int ready = 0;
                int temp = 0;
                int time = 60 * 9 + t * i;
                while (idx < sorted.size() && temp < m) { // 브포1
                    Map.Entry<String, Long> entry = sorted.get(idx++);
                    ready = timeToMinute(entry.getKey());
                    if (ready <= time) {
                        temp += entry.getValue();
                    } else { // 브포 2
                        break;
                    }
                }

                if(temp >= m || idx >= sorted.size() || ready > time) idx--;

                if(i == n - 1){ // 막차 시간임
                    if(temp >= m){ // 인원 초과됨
                        answer = minuteToTime(timeToMinute(sorted.get(idx).getKey()) - 1); // 마지막에 탑승하는 시간보다 1분 빨리 줄서기
                        break;
                    }
                    else { // 인원 초과되지 않음
                        answer = minuteToTime(time); // 막차 시간에 맞춰서 줄서기
                        break;
                    }
                } else {
                    if(temp >= m){ // 인원 초과됨
                        Map.Entry<String, Long> entry = sorted.remove(idx);
                        //entry.getValue()보다 m이 더 크다면 음수가 되는 문제
                        if(entry.getValue() > m) sorted.add(idx, new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue() - m)); // 리스트에서 제거한 곳에 값을 수정하여 다시 추가
                        else sorted.add(idx, new AbstractMap.SimpleEntry<>(entry.getKey(), 0L));
                    }
                }
            }


            return answer;
        }

        public int timeToMinute(String time){
            String[] parsed = time.split(":");
            int hour = Integer.parseInt(parsed[0]);
            int minute = Integer.parseInt(parsed[1]);
            return hour * 60 + minute;
        }

        public String minuteToTime(int time){
            StringBuilder sb = new StringBuilder();
            int hour = time / 60;
            int minute = time % 60;
            if(hour < 10) sb.append("0");
            sb.append(hour + ":");
            if(minute < 10) sb.append("0");
            sb.append(minute);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};
        String[] timetable2 = {"09:10", "09:09", "08:00"};
        String[] timetable3 = {"09:00", "09:00", "09:00", "09:00"};
        String[] timetable4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        String[] timetable5 = {"23:59"};
        String[] timetable6 = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        String[] timetable7 = {"09:00", "09:30", "10:00", "10:59", "11:00", "23:59"}; // 3 60 2 -> 답 10:59
        String[] timetable8 = {"17:58", "17:58", "18:00", "18:02", "18:04"}; // 10 60 2
        String[] timetable9 = {"23:59", "18:10", "18:00", "18:00", "18:00", "18:02", "18:01"};
        String[] timetable10 = {"09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00", "09:00",
                "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01",
                "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01",
                "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01",
                "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01", "09:01",
                "09:01", "09:01", "09:01", "09:01"};
        Solution s = new Solution();
        System.out.println(s.solution(2, 1, 45, timetable10)); // 9시, 9시 반, 10시
    }
}
