package Baekjoon.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam2589_보물섬 {
    public static char[][] map;
    public static int r, c;

    public static class YX{
        public int y;
        public int x;

        YX(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int BFS(YX yx){
        boolean[][] visited = new boolean[r][c];
        int[][] step = new int[r][c];
        Queue<YX> queue = new LinkedList<>();
        int max = 0;
        queue.add(yx);
        visited[yx.y][yx.x] = true;
        while(!queue.isEmpty()){
            YX temp = queue.poll();
            for(int dirs[]: dir){
                int ny = temp.y + dirs[0];
                int nx = temp.x + dirs[1];
                if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if(visited[ny][nx] != true && map[ny][nx] == 'L'){
                    queue.add(new YX(ny, nx));
                    visited[ny][nx] = true;
                    step[ny][nx] = step[temp.y][temp.x] + 1;
                    max = Math.max(max, step[ny][nx]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 육지 정보를 자료구조에 넣어서 BFS를 돌릴까?

        //BFS에서 최고값이 나오는걸 고르는걸까?
        // 보물이 묻혀있는 곳 최대 50 * 49 = 2450 가지 경우의 수

        map = new char[r + 1][c + 1];

        for(int i = 0; i < r; ++i){
            String s = br.readLine();
            for(int j = 0; j < c; ++j){
                map[i][j] = s.charAt(j);
            }
        }

        int max = 0;

        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j){
                if(map[i][j] == 'L'){
                    int temp = BFS(new YX(i, j));
                    if(temp > max){
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
