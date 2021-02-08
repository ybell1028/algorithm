package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam2589 {
    public static char[][] map;
    public static int[][] dst;
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

    public static void BFS(YX yx){
        boolean[][] visited = new boolean[r][c];
        int[][] step = new int[r][c]; // 나아갈 수 있는 방향의 수
        Queue<YX> queue = new LinkedList<>();

        queue.add(yx);
        visited[yx.y][yx.x] = true;
        int far = 0;
        while(!queue.isEmpty()){
            int cnt = 0;
            YX temp = queue.poll();
            for(int dirs[]: dir){
                int ny = temp.y + dirs[0];
                int nx = temp.x + dirs[1];
                if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if(visited[ny][nx] != true && map[ny][nx] == 'L'){
                    queue.add(new YX(ny, nx));
                    visited[ny][nx] = true;
                    cnt++;
                }
            }
            far++;
            if(cnt == 0) { // 더이상 나아갈 길이 없음
                if(dst[r][c] < far){
                    dst[r][c] = far;
                    far = 0;
                }
            }
        }
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

        //dst[시작지점][시작지점] = 시작지점에서 갈 수 있는 가장 먼 곳의 거리

        map = new char[r + 1][c + 1];
        dst = new int[r + 1][c + 1];

        for(int i = 0; i < r; ++i){
            String s = br.readLine();
            for(int j = 0; j < c; ++j){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j){
                if(map[i][j] == 'L'){
                    BFS(new YX(i, j));
                }
            }
        }
    }
}
