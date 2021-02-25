package Baekjoon.Math;

import java.io.*;
import java.util.StringTokenizer;

public class Exam5533_유니크 {
    public static final int COL = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 참가자의 수 (행의 수)
        // 열은 3으로 고정

        int[][] game = new int[N][COL];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < COL; j++){
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) { // 플레이어 차례
            //비교해야 하는것 [0][0] 과 [1][0], [2][0], ...
            // [0][1]과 [1][1], [2][1]
            int sum = 0;
            for (int j = 0; j < COL; j++) {
                    //여기서 [0][0]
                boolean dup = false;
                for(int k = 0; k < N; k++){
                    if(i == k) continue;
                    else if(game[i][j] == game[k][j]) {
                        dup = true;
                        break;
                    }
                }
                if(dup != true) sum += game[i][j];
            }
            bw.write(String.valueOf(sum + "\n"));
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
