package Sort;

import java.io.*;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

public class Exam14729_radix {
    public static DecimalFormat df;
    public static int BASE = 10; // 10진수
    public static int DIGIT = 6; // .을 포함한 자릿수
    public static String[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        df = new DecimalFormat("000.000");
        int n = Integer.parseInt(br.readLine());
        score = new String[n];
        for(int i = 0; i < n; ++i){
            score[i] = df.format(Double.parseDouble(br.readLine()));
        }

        radixSort(score, n);

        df = new DecimalFormat("0.000");

        for(int i = 0; i < n; ++i){
            score[i] = df.format(Double.parseDouble(score[i]));
        }

        for(int i = 0; i < 7; ++i){
            bw.write(score[i] + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static int ext_digit(String score, int digit){
        String part = score.substring(digit, digit+1);
        return Integer.parseInt(part);
    }

    public static void radixSort(String[] score, int n){
        Queue<String> bucket[];
        bucket = new LinkedList[BASE];

        for(int i = 0; i < BASE; ++i){
            bucket[i] = new LinkedList<String>();
        }

        for(int i = DIGIT; i >= 0 ; --i){ // BASE는 진수
            if(i == 3) continue;
            for(int j = 0; j < n; ++j){
                int val = ext_digit(score[j], i);
                bucket[val].add(score[j]);
            }
            int sIdx = 0;
            for(int j = 0; j < BASE; ++j){
                while(!bucket[j].isEmpty() && sIdx < n){
                    score[sIdx] = bucket[j].poll();
                    sIdx++;
                }
            }
        }
    }
}
