package Programmers.SummerCoding2021;

import java.util.Arrays;
import java.util.HashMap;

public class Exam1 {
    class Solution {
        public int[] solution(String code, String day, String[] data) {
            // data 형식 price=[가격] code=[6자리 숫자] time=[날짜]
            HashMap<String, Integer> hm = new HashMap();
            String time;
            for(String d : data){
                if(d.contains(code) && d.contains(day)){
                    String[] arr = d.split(" ");
                    time = arr[2];
                    String[] arr2 = arr[0].split("=");
                    hm.put(time, Integer.parseInt(arr2[1]));
                }
            }

            Object[] mapkey = hm.keySet().toArray();
            Arrays.sort(mapkey);
            int[] answer = new int[mapkey.length];
            for(int i = 0; i < answer.length; ++i){
                answer[i] = hm.get(mapkey[i]);
            }

            return answer;
        }
    }
}
