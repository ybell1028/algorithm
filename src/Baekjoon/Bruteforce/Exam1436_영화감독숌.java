package Baekjoon.Bruteforce;

//666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662, 6663 ... 6669
// 7666 ... 9666
// 10666,
// 11666, 12666, 13666, 14666, 15666, 16661, 16666

import java.util.Scanner;

public class Exam1436_영화감독숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 666;
        int cnt = 0;
        while(cnt < N){
            if(String.valueOf(num).contains("666")) cnt++;
            num++;
        }
        System.out.println(String.valueOf(num-1));
        sc.close();
    }
}
