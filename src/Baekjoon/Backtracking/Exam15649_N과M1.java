package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam15649_N과M1 {
    static int N, M;
    static int serial[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        serial = new int[N]; // {1, 2, ,3 ,4}
        for(int i = 1;i <= serial.length; i++) serial[i-1] = i;

        doPermutation(serial, 0);
    }

    private static void doPermutation(int[] arr, int start){
        int len = arr.length;

        if(start == M){ // 출력
            for(int i = 0;i < M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < len; i++){// 1
            swap(arr, start, i); // 2
            doPermutation(arr, start + 1); // 3
            swap(arr, start, i); // 4, 원상복구
        }
        // 트리거 start == len - 1이 아니라 M일때?
    }

    private static void swap(int[] a, int depth, int n){
        int temp = a[depth];
        a[depth] = a[n];
        a[n] = temp;
    }

}