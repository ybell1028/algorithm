package Baekjoon.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam7576_토마토 {
    private static int N, M, empty;
    private static int[][] tomatoes;
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Site {
        public int row;
        public int col;

        Site(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static int BFS(Queue<Site> queue){
        int day = 0;
        int ripened = 0;
        int size = queue.size();
        boolean[][] visited = new boolean[N][M];
        while(!queue.isEmpty()){
            if(size <= 0) {
                day++;
                size = queue.size();
            }
            Site site = queue.poll();
            if(!visited[site.row][site.col] && tomatoes[site.row][site.col] == 1){
                visited[site.row][site.col] = true;
                ripened++;
                for(int dir[] : dirs){
                    int row2 = site.row + dir[0];
                    int col2 = site.col + dir[1];
                    if((row2 >= 0 && row2 < N) && (col2 >= 0 && col2 < M)){
                        if(tomatoes[row2][col2] == 0){
                            tomatoes[row2][col2] = 1;
                            queue.add(new Site(row2, col2));
                        }
                    }
                }
            }
            size--;
        }

        return (ripened == (N * M - empty)) ? day : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Site> queue = new LinkedList<>();

        M = Integer.parseInt(st.nextToken()); // 가로칸의 수
        N = Integer.parseInt(st.nextToken()); // 세로칸의 수

        tomatoes = new int[N][M];
        empty = 0;

        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j){
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 1){
                    queue.add(new Site(i, j));
                } else if(tomatoes[i][j] == -1){
                    empty++;
                }
            }
        }

        System.out.println(BFS(queue));

        br.close();
    }
}