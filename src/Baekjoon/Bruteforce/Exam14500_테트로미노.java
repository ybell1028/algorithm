package Baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam14500_테트로미노 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String rc = br.readLine();
        StringTokenizer st = new StringTokenizer(rc);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] poli = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            String[] str = br.readLine().split(" ");;
            for(int j = 0; j < m ; j++){
                poli[i][j] = Integer.parseInt(str[j]);
            }
        }

        int[] tetro = {
                stick(poli, n, m),
                square(poli, n, m),
                cane(poli, n, m),
                stair(poli, n, m)
        };

        int max = 0;

        for(int i = 0; i < tetro.length; i++){
            max = Math.max(max, tetro[i]);
        }

        System.out.println(max);
    }

    private static int stick(int[][] poli, int n, int m){
        int max = 0;
        //행 검사
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= m - 4; j++){ // 시작 열
                int sum = 0;
                for(int k = j; k < j + 4; k++){ // 루프 열
                    sum += poli[i][k];
                }
                if (sum > max) max = sum;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j <= n - 4; j++){ // 시작 행
                int sum = 0;
                for(int k = j; k < j + 4; k++){ // 루프 행
                    sum += poli[k][i];
                }
                if (sum > max) max = sum;
            }
        }

        return max;
    }

    private static int square(int[][] poli, int n, int m){
        int max = 0;
        //행 검사
        for(int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = 0;
                for (int k = i; k < i + 2; k++) { // 행
                    for (int l = j; l < j + 2; l++) { // 루프 열
                        sum += poli[k][l];
                    }
                }
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    private static int cane(int[][] poli, int n, int m){
        int max = 0;
        //0도 회전
        for(int i = 0; i < m - 1; i++){ // 열 제한
            for(int j = 0; j <= n - 3; j++){ // 행 제한
                int sum = 0;
                for(int k = j; k < j + 3; k++){ // 루프
                    if(k == j + 2) sum += (poli[k][i] + poli[k][i+1]);
                    else sum += poli[k][i];
                }
                if (sum > max) max = sum;
            }
        }

        //180도 회전
        for(int i = 0; i < m - 1; i++){ // 열 제한
            for(int j = 0; j <= n - 3; j++){ // 행 제한
                int sum = 0;
                for(int k = j; k < j + 3; k++){ // 루프
                    if(k == j) sum += (poli[k][i] + poli[k][i+1]);
                    else sum += poli[k][i+1];
                }
                if (sum > max) max = sum;
            }
        }

        //90도
        for(int i = 0; i < n - 1; i++){ // 행 제한
            for(int j = 0; j <= m - 3; j++){ // 열 제한
                int sum = 0;
                for(int k = j; k < j + 3; k++){ // 루프 열
                    if(k == j) sum += (poli[i][k] + poli[i+1][k]);
                    else sum += poli[i][k];
                }
                if (sum > max) max = sum;
            }
        }

        //270도
        for(int i = 0; i < n - 1; i++){ // 행 제한
            for(int j = 0; j <= m - 3; j++){ // 열 제한
                int sum = 0;
                for(int k = j; k < j + 3; k++){ // 루프 열
                    if(k == j + 2) sum += (poli[i][k] + poli[i+1][k]);
                    else sum += poli[i+1][k];
                }
                if (sum > max) max = sum;
            }
        }

        return max;
    }

    private static int stair(int[][] poli, int n, int m) {
        int max = 0;
        //0도 회전
        for(int i = 0; i < m - 1; i++){ // 열 제한
            for(int j = 0; j <= n - 3; j++){ // 행 제한
                int sum = 0;
                for(int k = j; k < j + 3; k++){ // 루프
                    if(k <= j + 1) sum += (poli[k][i]);
                    if(k >= j + 1) sum += (poli[k][i+1]);
                }
                if (sum > max) max = sum;
            }
        }

        //180도 회전
        for(int i = 0; i < m - 1; i++){ // 열 제한
            for(int j = 0; j <= n - 3; j++){ // 행 제한
                int sum = 0;
                for(int k = j; k < j + 3; k++){ // 루프
                    if(k <= j + 1) sum += (poli[k][i+1]);
                    if(k >= j + 1) sum += (poli[k][i]);
                }
                if (sum > max) max = sum;
            }
        }

        //90도
        for(int i = 0; i < n - 1; i++){ // 행 제한
            for(int j = 0; j <= m - 3; j++){ // 열 제한
                int sum = 0;
                for(int k = j; k < j + 3; k++){ // 루프 열
                    if(k <= j + 1) sum += (poli[i][k]);
                    if(k >= j + 1) sum += (poli[i+1][k]);
                }
                if (sum > max) max = sum;
            }
        }

        //270도
        for(int i = 0; i < n - 1; i++){ // 행 제한
            for(int j = 0; j <= m - 3; j++){ // 열 제한
                int sum = 0;
                for(int k = j; k < j + 3; k++){ // 루프 열
                    if(k == j + 2) sum += (poli[i][k] + poli[i+1][k]);
                    else sum += poli[i+1][k];
                }
                if (sum > max) max = sum;
            }
        }

        return max;
    }
}
