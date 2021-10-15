package Baekjoon.SlidingWindow;

import java.io.*;
import java.util.*;

public class DNA비밀번호 {
    static int S, P;
    static String[] DNA;
    static final int Y = 4;
    static int[] standard = new int[Y];
    static String[] ACGT = {"A", "C", "G", "T"};
    static Map<String, Integer> real = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        DNA = br.readLine().split("");

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < Y; ++i) standard[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < Y; ++i){
            real.put(ACGT[i], 0);
        }

        for(int i = 0; i <= DNA.length - P; ++i){
            if(i == 0) {
                for(int j = 0; j < P; ++j) {
                    real.put(DNA[j], real.get(DNA[j]) + 1);
                }
            } else {
                real.put(DNA[i - 1], real.get(DNA[i - 1]) - 1);
                real.put(DNA[i + P - 1], real.get(DNA[i + P - 1]) + 1);
            }
            if(isOk()) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isOk(){
        for(int i = 0; i < Y; ++i){
            if(standard[i] > real.get(ACGT[i])) return false;
        }
        return true;
    }
}
