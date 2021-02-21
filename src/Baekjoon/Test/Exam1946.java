package Baekjoon.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam1946 {
    public static void main(String[] args) throws IOException {
        //  두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다. - 정렬 할 수 있다는 힌트!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T > 0){
            int N = Integer.parseInt(br.readLine()); // 지원자 수
            int[] app = new int[N + 1];

            for(int i = 1; i <= N; ++i){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int dr = Integer.parseInt(st.nextToken()); // 서류 심사 순위
                int ir = Integer.parseInt(st.nextToken()); // 면접 순위
                app[dr] = ir;
            }

            int tmp = app[1];
            int pass = 1;

            // 서류 합격 1등 보다 점수가 낮은 지원자들은 1등의 인터뷰 등수보다 높아야함(이미 서류는 낮기 때문에)
            for (int i = 2; i <= N; ++i) {
                if (tmp >= app[i]) {
                    tmp = app[i];
                    pass++;
                }
            }
            System.out.println(pass);
//            sb.append(String.valueOf(pass) + "\n");
            T--;
        }
//        String answer;
//        if(sb.length() > 0) answer = sb.substring(0, sb.length() - 1);
//        else answer = sb.toString();
    }
}
