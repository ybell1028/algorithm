package Baekjoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class Exam1495_기타리스트 {
    public static int volume[];
    public static int DP[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        volume = new int[102];
        DP = new int[1001][2];

        StringTokenizer stNSM = new StringTokenizer(br.readLine());

        int N, S, M;

        N = Integer.parseInt(stNSM.nextToken()); // 곡의 갯수
        S = Integer.parseInt(stNSM.nextToken()); // 시작 볼륨
        M = Integer.parseInt(stNSM.nextToken()); // 최대 볼륨 값

        StringTokenizer stV = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            volume[i] = Integer.parseInt(stV.nextToken());
        }

        DP[S][0] = 1; // DP 배열에서 시작 볼륨에 1 저장, 후에 초기화 루프를 통해 0으로 초기화됨

        //Keypoint -> ***DP에 가능했던 볼륨 수치를 우선 전부 기록하고 최대 볼륨 범위인 M까지만 DP를 검색****
        for(int i = 1; i <= N; i++){ // 인덱스 i는 입력받은 볼륨을 조작
            for(int j = 0; j <= M; j++){ // 인덱스 j는 DP를 조작 <= 최대볼륨 M
                //[j][1]은 임시배열
                if(DP[j][0] != 0){
                    if(j - volume[i] >= 0){
                        DP[j - volume[i]][1] = 1;
                    }

                    if(j + volume[i] < 1001){
                        DP[j + volume[i]][1] = 1;
                    }
                }
            }

            for (int j = 0; j <= M; ++j) { // 초기화
                //[j][0]은 찐배열
                DP[j][0] = DP[j][1];
                DP[j][1] = 0;
            }
        }

        for(int i = M; i >= 0; i--){
            if(DP[i][0] == 1){
                bw.write(String.valueOf(i + "\n"));
                break;
            }
            if(i == 0){
                bw.write(String.valueOf(-1 + "\n"));
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
