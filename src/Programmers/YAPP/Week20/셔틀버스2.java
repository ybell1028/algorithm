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

            System.out.println(sorted);

            int idx = 0;
            int cnt = 0; // 무지성으로 올라가는 카운트가 필요함
            for(int i = 0; i < n; i++){
                int temp = 0;
                int time = 60 * 9 + t * i;
                while(idx < sorted.size() && temp < m){
                    Map.Entry<String, Long> entry = sorted.get(idx++); // 대기열이 없거나, 사람이 꽉찬다면 break;
                    cnt++;
                    int ready = timeToMinute(entry.getKey());
                    if(ready <= time){
                        temp += entry.getValue();
                    } else {
                        idx--;
                        break;
                    }
                }

                if(idx > sorted.size() || temp >= m) idx--;

                if(temp >= m) { // 승객 최대치 넘음
                    if(i == n - 1){ // 마지막 루프라면
                        if(cnt == 0) { // 해당 시간에 타는 사람이 아무도 없을 때
                            answer = minuteToTime(timeToMinute(sorted.get(idx).getKey()));
                        }
                        else { // 있을 때... 얼마만큼 빼야 여유가 생기는지
                            answer = minuteToTime(timeToMinute(sorted.get(idx).getKey()) - 1); // case 3,4 -> 대기열 맨앞에 있는 같은 시각에 도착한 사람들 맨 뒤에 위치하면 탑승하지 못하므로 1분 일찍 도착
                        }
                        // else answer = sorted.get(idx).getKey(); // 대기열 맨앞의 시간이 아니라면 그 시간에 맨 뒤시간 바로 앞시간에 도착해야함
                        break;
                    } else { // 아직 루프가 남았다면 맵 업데이트
                        Map.Entry<String, Long> entry = sorted.remove(idx);
                        sorted.add(idx, new AbstractMap.SimpleEntry<String, Long>(entry.getKey(), entry.getValue() - m));
                    }
                }

                if(cnt >= sorted.size()){ // 대기열을 전부 탐색함 -> 막차 시간에 맞춰가면 됨
                    time = 60 * 9 + t * (n - 1);
                    answer = minuteToTime(time);
                    break;
                }
                cnt--;
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
        Solution s = new Solution();
        s.solution(2, 1, 2, timetable3);
    }
}
