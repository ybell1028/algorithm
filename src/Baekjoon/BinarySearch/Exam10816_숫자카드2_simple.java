package Baekjoon.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class Exam10816_숫자카드2_simple {
    public static int N, M;
    public static int[] plusCard;
    public static int[] minusCard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        plusCard = new int[10000001];
        minusCard = new int[10000001];

        int num;
        N = Integer.parseInt(br.readLine()); // 숫자 카드의 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            num = Integer.parseInt(st.nextToken());
            if(num >= 0){
                plusCard[num]++;
            }
            else {
                minusCard[-num]++;
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; ++i){
            num = Integer.parseInt(st.nextToken());
            if(num >= 0){
                bw.write( String.valueOf(plusCard[num])+ " ");
            }
            else {
                bw.write( String.valueOf(minusCard[-num])+ " ");
            }
        }
        bw.flush();
        System.out.println();

        br.close();
        bw.close();
    }
}