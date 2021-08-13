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
                //재생 시간이 다르다면 재생 시간이 긴 음악 정보을 우선
                if (this.time != music.time) return this.time - music.time;
                //재생 시간이 같다면 먼저 들어온 음악 정보를 우선
                else return music.order - this.order;
            }
        }

        public String solution(String m, String[] musicinfos) {
            //조건과 일치하며 '우선순위가 가장 높은 하나의 음악 제목'만 반환하면 되니 내림차순 우선순위 큐를 사용
            PriorityQueue<Music> pq = new PriorityQueue<>(Collections.reverseOrder());
            //콤마를 기준으로 멜로디를 나눠주는 seperate 함수로 네오가 기억한 멜로디를 담은 문자열 m을 재구성 해줍니다.
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
                // 시작 시간보다 종료 시간의 분이 더 큰 케이스
                if (sMinute > eMinute) {
                    minute = (60 - sMinute) + eMinute;
                    hour--;
                } else {
                    minute = eMinute - sMinute;
                }

                String seperatedInfo = seperate(info[3]);
                int len = seperatedInfo.split(",").length; // len은 주어진 악보의 총 길이
                int time = hour * 60 + minute; // 총 소요 시간 계산

                String result;
                if (time > len) {
                    //악보 길이보다 재생 시간이 길면
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < time / len; ++i) {
                        sb.append(seperatedInfo);
                    }
                    sb.append(cutCode(seperatedInfo, time % len));
                    result = sb.toString();
                } else {
                    //악보 길이보다 재생 시간이 짧으면
                    result = seperate(info[3].substring(0, time + (info[3].length() - len)));
                }
                if (result.contains(seperatedM)) {
                    //재생시간에 맞춰 재구성한 악보에 네오가 기억한 멜로디가 포함 되어있다면 Music 인스턴스를 생성해 pq에 삽입
                    pq.add(new Music(info[2], time, order++));
                }
            }

            if (pq.isEmpty()) return "(None)";
            Music answer = pq.poll();
            return answer.title;
        }

        public String cutCode(String code, int len) {
            //code를 len까지 끊어서 재구성 해주는 함수
            String[] seperated = code.split(",");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; ++i){
                sb.append(seperated[i] + ",");
            }
            return sb.toString();
        }

        public String seperate(String code) {
            //이어진 멜로디 문자열을 콤마를 통해 구분시켜주는 함수
            code = code.replace("", ",");
            code = code.replace(",#", "#");
            return code.substring(1);
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
