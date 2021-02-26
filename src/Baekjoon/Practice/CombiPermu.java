package Baekjoon.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombiPermu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int serial[] = new int[n];
        for(int i = 1;i <= serial.length; i++) serial[i-1] = i;

        int[] combArr = new int[r];

        Com(combArr, n, r, 0, 0, serial);
    }

    private static void Com(int[] combArr, int n, int r, int idx, int target, int[] arr){
        if(r == 0){
            Per(combArr, 0);
        }
        else if(target == n) return;
        else{
            combArr[idx] = arr[target];
            Com(combArr, n, r-1, idx+1, target+1, arr);
            Com(combArr, n, r, idx, target+1, arr);
        }
    }

    private static void Per(int[] arr, int start){
        int len = arr.length;
        if(start == len - 1){
            for(int item: arr) System.out.print(item + " ");
            System.out.println();
            return;
        }
        for(int i = start; i < len - 1; i++){
            swap(arr, start, i);
            Per(arr, start + 1);
            swap(arr, start, i);
        }
    }

    public static void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
