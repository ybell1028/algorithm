package Programmers.YAPP.Week18;

import java.util.*;

public class 방금그곡 {
    static class Solution {
        class Music implements Comparable {
            public String title;
            public int time;
            public int order;

            Music(String title, int time, int order) {
                this.title = title;
                this.time = time;
                this.order = order;
            }

            @Override
            public int compareTo(Object obj) {
                Music music = (Music) obj;
                if (this.time != music.time) return this.time - music.time;
                else return music.order - this.order;
            }
        }

        public String solution(String m, String[] musicinfos) {
            PriorityQueue<Music> pq = new PriorityQueue<>(Collections.reverseOrder());
            String seperatedM = seperate(m);
            int order = 1;

            for (String s : musicinfos) {
                String[] info = s.split(",");
                String[] start = info[0].split(":");
                String[] end = info[1].split(":");

                int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
                int minute;
                int sMinute = Integer.parseInt(start[1]);
                int eMinute = Integer.parseInt(end[1]);
                if (sMinute > eMinute) {
                    minute = (60 - sMinute) + eMinute;
                    hour--;
                } else {
                    minute = eMinute - sMinute;
                }

                int time = hour * 60 + minute;
                int len = calcLen(info[3], info[3].length()); // len은 악보 정보의 시간 길이

                String result;
                if (time > len) {
                    String seperatedInfo = seperate(info[3]);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < time / len; ++i) {
                        sb.append(seperatedInfo);
                    }
                    sb.append(seperate(cutCode(info[3], time % len)));
                    result = sb.toString();
                } else {
                    result = seperate(info[3].substring(0, time + (info[3].length() - len)));
                }
                if (result.contains(seperatedM)) {
                    pq.add(new Music(info[2], time, order++));
                }
            }

            if (pq.isEmpty()) return "(None)";
            Music answer = pq.poll();
            return answer.title;
        }

        public int calcLen(String code, int bound) {
            int cnt = 0;
            for (int i = 0; i < bound; ++i) {
                if (code.charAt(i) == '#') continue;
                else cnt++;
            }
            return cnt;
        }

        public String cutCode(String code, int len) {
            int cnt = 0;
            for (int i = 0; i < code.length(); ++i) {
                if (code.charAt(i) == '#') len++;
                if (cnt == len) break;
                cnt++;
            }
            return code.substring(0, cnt);
        }

        public String seperate(String code) {
            code = code.replace("", ",");
            code = code.replace(",#", "#");
            StringBuilder sb = new StringBuilder(code);
            sb.delete(0, 1);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String m = "CC#B";
        String[] musicinfos = {"03:00,03:11,FOO,CC#B", "04:00,04:16,BAR,CC#BCC#BCC#B"};

//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}
        s.solution(m, musicinfos);
    }
}
