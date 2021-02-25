package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam10973_이전순열 {
    public static void main(String[] args) throws IOException {
        Exam10973_이전순열 exam = new Exam10973_이전순열();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int[] ary = new int[N];

        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        if (exam.prevPermutation(ary)) {
            for (int i = 0; i < N; i++) {
                System.out.print(ary[i] + " ");
            }
            System.out.println();
        } else
            System.out.println("-1");
    }

    private boolean prevPermutation(int ary[]){
        //뒤부터 검사
        int a = ary.length - 1;
        while(a > 0 && ary[a - 1] <= ary[a]) a--;
        if(a <= 0) return false;

        int b = ary.length - 1;
        while(ary[a - 1] <= ary[b]) b--;

        swap(ary, a - 1, b);

        //나눈 뒤를 내림차순으로 정리
        int start = a;
        int end = ary.length - 1;
        while(start < end){
            swap(ary, start, end);
            start++;
            end--;
        }
        return true;
    }

    private void swap(int[] ary, int n1, int n2){
        int temp = ary[n1];
        ary[n1] = ary[n2];
        ary[n2] = temp;
    }
}
