package Baekjoon.Sort;

import java.io.*;

public class Exam14729_칠무해 {
    public static int[] score = new int [10000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; ++i){
            int idx = (int)(Double.parseDouble(br.readLine()) * 1000);
            score[idx]++;
        }

        int cnt = 0;

        for(int i = 0; i < 10000001; i++){
            if(cnt >= 7) break;
            else if(score[i] == 0) continue;
            else {
                while(score[i] > 0 && cnt < 7){
                    bw.write(String.format("%.3f", (double)i / 1000) + "\n");
                    score[i]--;
                    cnt++;
                }
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
