package Baekjoon.Greedy;

import java.io.*;
import java.util.StringTokenizer;

//시작 시간 11시 21분 33분 종료
public class Exam11047_동전0 {
    public static void main(String[] args) throws IOException {
        //최적 부분 구조를 가지고 있고 현재의 연산이 미래의 연산에 영향을 주는 케이스가 아니라면 그리디 알고리즘을 적용할 수 있다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        int cnt = 0;

        for(int i = 0; i < N; ++i){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0; --i){
            if(K <= 0) break;
            while(K >= coin[i]){
                K -= coin[i];
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
