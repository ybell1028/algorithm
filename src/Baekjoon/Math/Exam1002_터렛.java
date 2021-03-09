package Baekjoon.Math;

import java.io.*;
import java.util.StringTokenizer;
//11시 14분 시작 12시 58분 종료
public class Exam1002_터렛 {
    static double calcDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int location = -2;

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double distance = calcDistance(x1, y1, x2, y2);

            if(distance == 0) {
                if(r1 == r2) location = -1; // # 1-1
                else location = 0; // #1
            }
            else if (distance < r1 + r2) {
                int longer = Math.max(r1, r2);
                int shorter = Math.min(r1, r2);

                if (distance + shorter < longer) {
                    location = 0;
                } else if (distance + shorter == longer) {
                    location = 1;
                } else {
                    location = 2;
                }
            } else {
                if(distance > r1 + r2){
                    location = 0;
                }
                else if(distance == r1 + r2){
                    location = 1;
                }
            }

            bw.write(String.valueOf(location + "\n"));
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
