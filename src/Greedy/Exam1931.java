package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Exam1931 {
    public static int[][] meetingArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        meetingArr = new int[n][2]; // meeting[i]에서 i는 회의 시작시간, meeting[i][0]은 소요시간, meeting[i][1]은 회의수

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetingArr[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            meetingArr[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // Comparator는 일반적이지 않은 문자열의 길이 순으로 보고 싶다든지
        // Comparable로 구현한 것 말고 기준으로 정렬하고 싶다든지 할 때 사용한다.
        // 끝나는 시간을 오름차순으로 정렬
        Arrays.sort(meetingArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
                if(start[1] == end[1]){
                    // 종료 시간이 같을경우엔 시작시간으로 정렬
                    return Integer.compare(start[0], end[0]);
                }
                // 종료시간으로 정렬
                return Integer.compare(start[1], end[1]);
            }
        });

        int cnt = 0;
        int end = -1;

        for(int i = 0; i < n; i++){
            if(meetingArr[i][0] >= end) { // 시작시간이 끝나는 시간보다 크다면
                end = meetingArr[i][1];
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();

        br.close();
        bw.close();
    }
}
