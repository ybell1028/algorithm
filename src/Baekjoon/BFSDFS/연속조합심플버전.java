package Baekjoon.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 연속조합심플버전 {
    static int N;
    static int M;
    static int[] combi;
    static int[] num;
    static List<String> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < (1 << N); ++i){
            List<Integer> list = new LinkedList<>();
            for(int j = 0; j < N; ++j){
                if((i & (1 << j)) > 0) list.add(num[j]);
            }
            for(int e : list){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
