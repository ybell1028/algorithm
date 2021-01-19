package SamsungTest;

import java.io.*;
import java.util.StringTokenizer;

public class Exam3190 {
    public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 시계방향 상우하좌

    public static int snake() {
        int tRow, tCol; // 임시 위치
        int sec = 1; // 초
        int cIdx = 0; // 방향전환 인덱스
        int dIdx = 1; // 방향 인덱스, 처음엔 오른쪽으로
        board[sRow][sCol] = 2; // 시작은 왼쪽 최상단
        while (true) {
            if (cIdx < l && sec == x[cIdx]) {
                // 1. 방향 바뀌었는지 체크
                if (c[cIdx] == 'D') {
                    if(dIdx == 3) dIdx = 0;
                    else dIdx++;
                } else {
                    if (dIdx == 0) dIdx = 3;
                    else dIdx--;
                }
                cIdx++;
            }
            // 2. 안바뀌었으면 그냥 방향대로 나아감
            tRow = sRow + dir[dIdx][0];
            tCol = sCol + dir[dIdx][1];
            sec++;
            //3. 나가 가려는 방향이 레인지 벗어났는지 체크
            if (tRow < 0 || tRow >= n || tCol < 0 || tCol >= n) break;
            else if(board[tRow][tCol] == 2) break; // 자기 몸에 부딛힘
            else if(board[tRow][tCol] == 0) { // 앞에 사과가 없다면
                board[sRow][sCol] = 0; // 꼬리 빠져 나옴
                // 사과가 없다면 꼬리 그대로 두고
            }
            sRow = tRow;
            sCol = tCol;
            board[sRow][sCol] = 2; // 머리 이동
        }
        return sec;
    }

    public static void changeDir(int dIdx, char c) {

    }

    public static int[][] board;
    public static int[] x;
    public static char[] c;
    public static int sRow = 0; // 뱀이 있는 행
    public static int sCol = 0; // 뱀이 있는 열
    public static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); // 보드의 크기
        int k = Integer.parseInt(br.readLine()); // 사과의 갯수
        //맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.

        board = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1; // 주어진 위치에 사과 넣기
        }

        l = Integer.parseInt(br.readLine()); // 방향 전환 횟수

        x = new int[l];
        c = new char[l];

        for (int i = 0; i < l; ++i) { // 게임 시간이 증가하는 순으로 주어짐
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken()); // 게임 시작후 흐른 시간
            c[i] = st.nextToken().charAt(0); // L이면 왼쪽으로 90도 전환, D면 오른쪽으로 90도 전환
        }

        System.out.println(snake());
    }
}
