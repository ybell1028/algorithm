package Baekjoon.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 연속조합 {
    static int N;
    static int[] combi;
    static int[] num;
    static int[] temp;
    static List<String> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i){
            temp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; ++i){
            num = new int[i];
            combi = new int[i];
            for(int j = 0; j < i; ++j){
                num[j] = temp[j];
            }
            DFS(0, 0, i);
        }
        Collections.sort(list);
        System.out.println();
    }

    static void DFS(int depth, int start, int limit) {
        if (depth == limit) {
            StringBuilder sb = new StringBuilder();
            for (int t : combi) {
                sb.append(t);
            }
            list.add(sb.toString());
        } else {
            for (int i = start; i < N; i++) {
                combi[depth] = temp[i];
                DFS(depth + 1, i + 1, limit);
            }
        }
    }
}
