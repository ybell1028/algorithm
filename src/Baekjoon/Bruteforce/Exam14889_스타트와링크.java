package Baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Exam14889_스타트와링크 {
    private static int N, R;
    private static int minDiff = Integer.MAX_VALUE;
    private static int sumStart, sumLink;
    private static int[] num;
    private static int[][] stat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        R = N / 2;

        stat = new int[N + 1][N + 1];
        num = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 1; i < N + 1; ++i) {
            num[i - 1] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; ++j) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(visited, 0, N, R);

        System.out.println(minDiff);

        br.close();
    }

    static void combination(boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int[] startTeam = new int[R];
            boolean[] startVisit = new boolean[R];
            sumStart = 0;
            int[] linkTeam = new int[R];
            boolean[] linkVisit = new boolean[R];
            sumLink = 0;
            int startIdx = 0;
            int linkIdx = 0;

            for (int i = 0; i < N; ++i) {
                if (visited[i]) {
                    startTeam[startIdx++] = i + 1;
                } else {
                    linkTeam[linkIdx++] = i + 1;
                }
            }

            calcStat(startTeam, startVisit, 0, true, R, 2);
            calcStat(linkTeam, linkVisit, 0, false, R, 2);
            minDiff = Math.min(minDiff, Math.abs(sumStart - sumLink));

            return;
        } else {
            for (int i = start; i < n; ++i) {
                visited[i] = true;
                combination(visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    static void calcStat(int[] team, boolean[] visited, int start, boolean isStart, int n, int r) {
        if (r == 0) { // 이 안에서 또 두개를 뽑아야 함
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < n; ++i){
                if(visited[i]) list.add(team[i]);
            }
            int a = list.poll();
            int b = list.poll();
            if(isStart) sumStart += (stat[a][b] + stat[b][a]);
            else sumLink += (stat[a][b] + stat[b][a]);

            return;
        } else {
            for (int i = start; i < n; ++i) {
                visited[i] = true;
                calcStat(team, visited, i + 1, isStart, n, r - 1);
                visited[i] = false;
            }
        }
    }
}