package Baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam14888_연산자끼워넣기 {
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] num;
    static HashMap hm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int start = 0;
        int sum = 0;

        num = new int[N];
        int[] oper = new int[10]; // 주어지는 수의 최대 갯수는 11개이므로 연산자는 10개
        boolean[] visited = new boolean[N - 1];
        hm = new HashMap<String, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i){
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; ++i){
            sum += Integer.parseInt(st.nextToken());
            for(int j = start; j < sum; ++j){
                oper[j] = i; // 0 1 2 3 차례대로 + - * /
            }
            start = sum;
        }

        StringBuilder sb = new StringBuilder();
        combination(sb, oper, visited, 0, N - 1);

        calc(hm);

        System.out.println(max);
        System.out.println(min);
    }

    static void combination(StringBuilder sb, int[] arr, boolean[] visited, int depth, int n){
        if(depth == n){
            cnt++;
            hm.putIfAbsent(sb.toString(), 1);
            return;
        } else {
            for(int i = 0; i < n; ++i){
                if(!visited[i]){
                    visited[i] = true;
                    sb.append(arr[i] + " ");
                    combination(sb, arr, visited,depth + 1, n);
                    sb.delete(sb.length() - 2, sb.length());
                    visited[i] = false;
                }
            }
        }
    }

    static void calc(HashMap <String, Integer> hm){
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            int a = num[0];
            int b;
            int stIdx = 1;
            StringTokenizer stOper = new StringTokenizer(entry.getKey());
            while(stOper.hasMoreTokens()){
                int operIdx = Integer.parseInt(stOper.nextToken()); // 얘가 문제
                b = num[stIdx++];
                if(operIdx == 0){
                    a += b;
                } else if(operIdx == 1){
                    a -= b;
                } else if(operIdx == 2){
                    a *= b;
                } else {
                    if(a < 0 && b > 0){
                        a = -a / b; // 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다.
                        a = -a;
                    } else {
                        a /= b;
                    }
                }
            }
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
    }
}
