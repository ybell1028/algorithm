package Baekjoon.BFSDFS;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Exam2178_미로탐색 {
    public static int N, M;
    public static int[][] maze;
    public static int CNT = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];

        for(int i = 0; i < N; ++i){
            String row = br.readLine();
            for(int j = 0; j < M; ++j){
                maze[i][j] = Integer.parseInt(row.substring(j, j+1));
            }
        }

        BFS(0, 0);

        System.out.println(CNT);
    }

    public static int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void BFS(int n, int m){
        boolean[][] visited = new boolean[N][M];
        LinkedList<NM> adj[][] = new LinkedList[N][M]; // 인접리스트

        for (int i = 0; i < N; ++i) {// 인접 리스트 초기화
            for(int j = 0; j < M; ++j){
                adj[i][j] = new LinkedList();
            }
        }

        for (int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j){
                for(int dir[] : dirs){ // 인접 리스트 추가
                    int n1 = i + dir[0];
                    int m1 = j + dir[1];
                    if(n1 < 0 || n1 >= N || m1 < 0 || m1 >= M) continue;
                    if(maze[n1][m1] == 0) continue;
                    adj[i][j].add(new NM(n1, m1));
                }
            }
        }

        LinkedList<NM> queue = new LinkedList<NM>();

        visited[n][m] = true;
        queue.add(new NM(n, m, 1));

        while(!queue.isEmpty()){
            NM nm = queue.poll();
            n = nm.getN();
            m = nm.getM();
            int prevCnt = nm.getCnt();

            if(n == N-1 && m == M-1 && prevCnt < CNT){
                CNT = prevCnt;
                continue;
            }

            Iterator<NM> i = adj[n][m].listIterator();
            while(i.hasNext()){
                NM n1m1 = i.next();
                int n1 = n1m1.getN();
                int m1 = n1m1.getM();
                if(!visited[n1][m1]){
                    visited[n1][m1] = true;
                    queue.add(new NM(n1, m1, prevCnt + 1));
                }
            }
        }
    }

    private static class NM{
        int n;
        int m;
        int cnt;

        NM(int n, int m){
            this.n = n;
            this.m = m;
        }

        NM(int n, int m, int cnt){
            this.n = n;
            this.m = m;
            this.cnt = cnt;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
