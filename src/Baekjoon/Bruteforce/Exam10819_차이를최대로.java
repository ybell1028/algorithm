package Baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam10819_차이를최대로 {
    static int result;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        nPr(arr, 0, N);
        System.out.println(max);
    }

    public static void nPr(int[] arr, int len, int r) { // 순열
        if(len == r){
            result = 0;
            for(int i = 0;i < arr.length-1;i++){ // 두 수의 차를 절대값 취해준것을 더해줌
                result += Math.abs(arr[i+1] - arr[i]);
            }
            if(max < result){
                max = result;
            }
            return;
        }
        for(int i = len; i < arr.length; i++){
            swap(arr, i, len);
            nPr(arr,len + 1, r);
            swap(arr, i, len);
        }
    }

    public static void swap(int[] a, int depth, int n){
        int temp = a[depth];
        a[depth] = a[n];
        a[n] = temp;
    }
}