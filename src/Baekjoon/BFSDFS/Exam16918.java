package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam16918 {
    public static int R, C, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        char[][] setup = new char[R][C];
        char[][] boom = new char[R][C];
        char[][] allset = new char[R][C];

        for(int i = 0; i < R; ++i){
            String s = br.readLine();
            for(int j = 0; j < C; ++j){
                setup[i][j] = s.charAt(j);
                allset[i][j] = 'O';
                boom[i][j] = 'O';
            }
        }

        // 0초. 가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
        // 1초. 다음 1초 동안 봄버맨은 아무것도 하지 않는다.
        // 2초. 다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게된다.
        // 3초. 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
        // 이후 2초~3초를 반복한다.

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                if(setup[i][j] == 'O'){
                    boom[i][j] = '.';
                    for(int[] dirs : dir){
                        int nr = i + dirs[0];
                        int nc = j + dirs[1];
                        if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                        if(boom[nr][nc] == '.') continue;
                        boom[nr][nc] = '.';
                    }
                }
            }
        }

        switch (N % 4){
            case 1 : {
                printMap(setup);
                break;
            }
            case 0 :
            case 2 : {
                printMap(allset);
                break;
            }
            case 3 : {
                printMap(boom);
                break;
            }
            default: break;
        }
    }

    public static void printMap(char[][] map){
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
