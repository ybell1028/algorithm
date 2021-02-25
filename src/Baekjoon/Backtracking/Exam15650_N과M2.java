package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam15650_N과M2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int serial[] = new int[n];
        for(int i = 1;i <= serial.length; i++) serial[i-1] = i;

        int[] combArr = new int[n];

        Combi(combArr, n, r, 0, 0, serial);
    }

    private static void Combi(int[] combArr, int n, int r, int idx, int target, int[] arr){
        if(r == 0){
            for(int i = 0;i < idx; i++){
                System.out.print(arr[combArr[i]] + " ");
            }
            System.out.println();
        }
        else if(target == n) return;
        else{
            combArr[idx] = target;
            Combi(combArr, n, r-1, idx+1, target+1, arr);
            Combi(combArr, n, r, idx, target+1, arr);
        }
    }
}
