package Baekjoon.Implimentaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam2456_나는학급회장이다 {
    // 단, 점수가 가장 큰 후보가 여러 명인 경우에는 3점을 더 많이 받은 후보를 회장으로 결정하고,
    // 3점을 받은 횟수가 같은 경우에는 2점을 더 많이 받은 후보를 회장으로 결정한다.
    // 3점과 2점을 받은 횟수가 모두 동일하면, 1점을 받은 횟수도 같을 수밖에 없어 회장을 결정하지 못하게 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] point = new int[4][4];
        int[] sum = new int[4];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; ++j) {
                int p = Integer.parseInt(st.nextToken());
                sum[j] += p;
                point[j][p]++;
            }
        }

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        int max = 0;
        for(int i = 1; i <= 3 ; ++i){
            if(sum[i] > max) {
                max = sum[i];
                while(!queue1.isEmpty()){
                    queue1.poll();
                }
                queue1.add(i); // 어차피 queue1 안엔 점수가 같은 사람끼리만 남게된다.
            } else if(sum[i] == max){
                queue1.add(i);
            }
        }

        if(queue1.size() <= 1){
            System.out.println(queue1.poll() + " " + max);
        } else {
            for (int i = 3; i >= 2; --i) {
                int mpoint = 0;
                while (!queue1.isEmpty()) {
                    int cdd = queue1.poll();
                    if (mpoint < point[cdd][i]) {
                        mpoint = point[cdd][i];
                        while(!queue2.isEmpty()) queue2.poll();
                        queue2.add(cdd);
                    } else if (mpoint == point[cdd][i]) {
                        queue2.add(cdd);
                    }
                }
                if(queue2.size() == 1) break;
                while(!queue2.isEmpty()) queue1.add(queue2.poll());
            }
            if(queue2.size() == 1) System.out.println(queue2.poll() + " " + max);
            else System.out.println(0 + " " + max);
        }
    }
}
