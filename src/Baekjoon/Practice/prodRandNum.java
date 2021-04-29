package Baekjoon.Practice;

import java.text.DecimalFormat;

public class prodRandNum {
    public static DecimalFormat df;
    public static void main(String[] args) {
        df = new DecimalFormat("0");
        int head = 0;
        int tail = 0;
        for(int i = 0; i < 100; ++i){
            if(head >= 50) System.out.print(")");
            else if(tail >= 50) System.out.print("(");
            else {
                String s = (int)(Math.random() * 2) + 1 == 1 ? "(" : ")";
                if(s.equals("(")) head++;
                else tail ++;
                System.out.print(s);
            }
        }
//        System.out.println(Math.random() * 2 + 1);
    }
}
