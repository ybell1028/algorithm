package Programmers.YAPP.Week18;

import java.util.*;

public class 방금그곡 {
    class Solution {
        class Music implements Comparable {
            public String title;
            public int time;
            public int order;

            Music(String title, int time, int order){
                this.title = title;
                this.time = time;
                this.order = order;
            }

            @Override
            public int compareTo(Object obj){
                Music music = (Music)obj;
                if(this.time == music.time) return music.order - this.order;
                return this.time - music.time;
            }
        }

        public String solution(String m, String[] musicinfos) {
            PriorityQueue<Music> pq = new PriorityQueue<>(Collections.reverseOrder());
            int order = 1;
            for(String s : musicinfos){
                String[] info = s.split(",");
                String[] start = info[0].split(":");
                String[] end = info[1].split(":");

                int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
                int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
                int time = hour * 60 + minute;
                int len = calcLen(info[3], info[3].length()); // len은 악보 정보의 시간 길이
                String result;
                if(time > len){
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < time / len; ++i){
                        sb.append(info[3]);
                    }
                    sb.append(sb.substring(0, time % len));
                    result = sb.toString();

                } else {
                    result = info[3].substring(0, time + (info[3].length() - len));
                }
                System.out.println(result);
                if(result.contains(m) && !result.contains(m + "#")){
                    pq.add(new Music(info[2], time, order++));
                }
            }

            // while(!pq.isEmpty()){
            //     System.out.println(pq.poll().title);
            // }

            if(pq.isEmpty()) return "(None)";
            Music answer = pq.poll();
            return answer.title;
        }

        public int calcLen(String code, int bound) {
            int cnt = 0;
            for(int i = 0; i < bound; ++i){
                if(code.charAt(i) == '#') continue;
                else cnt++;
            }
            return cnt;
        }
    }
}
