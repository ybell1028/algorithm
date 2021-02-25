package Baekjoon.Math;

import java.util.*;

public class Exam1476_날짜계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int EC = 1, SC = 1, MC = 1;
        int cnt = 1;

        while(true){
            if(EC == E && S == SC && M == MC) break;
            cnt++;
            EC++; SC++; MC++;
            if(EC != 15) EC %= 15;
            if(SC != 28) SC %= 28;
            if(MC != 19) MC %= 19;
        }

        System.out.println(cnt);
    }
}
