import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Exam14502 {
    public static int M, N;

    public static int virusCnt;
    public static int minVirus;

    public static LinkedList<XY> Virus = new LinkedList<XY>();

    public static class XY {
        int x;
        int y;

        XY(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stNM = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stNM.nextToken());
        N = Integer.parseInt(stNM.nextToken());

        int[][] lab = new int[M][N];
        minVirus = M * N + 1;
        int safeArea = M * N;

        for (int i = 0; i < M; i++) {
            StringTokenizer stRow = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(stRow.nextToken());
                if(lab[i][j] == 2){
                    Virus.add(new XY(i, j)); // 바이러스의 위치 추출 -> 리스트에 추가
                }
                else if(lab[i][j] == 1) safeArea--;
            }
        }

        safeArea -= 3; // 추가되는 벽의 갯수만큼 빼주기
        safeArea -= solve(lab);
        bw.write(String.valueOf(safeArea + "\n"));

        bw.flush();

        br.close();
        bw.close();
    }

    public static int solve(int[][] lab) {
        int m = lab.length;
        int n = lab[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { // 벽놓기 시작하는 위치
                // 이 루프로 돌아올떄 lab은 언제나 초기 상태에 있어야 한다.
                int wallCnt = 0;
                int[][] installed = new int[m][n];
                if (setWall(lab, i, j, wallCnt)) lab[i][j] = 0; // 1번째로 세운 벽 되돌리기
            }
        }

        return minVirus;
    }

    public static boolean setWall(int[][] lab, int m, int n, int wallCnt) { // 먼저 벽 설치
        if (lab[m][n] != 0) return false;
        lab[m][n] = 1;
        wallCnt++;
        if (wallCnt >= 3) {
            virusCnt = 0; // 퍼진 바이러스의 수
            int visited[][] = new int[M][N];
            for(int i = 0; i < Virus.size(); i++){
                XY virus = Virus.get(i); // 바이러스의 위치
                dfs(lab, visited, virus.getX(), virus.getY());
            }
            // 여기 사이에서 최소 값 비교
            if(virusCnt < minVirus) minVirus = virusCnt;
            lab[m][n] = 0; // 3번째로 세운 벽 되돌리기
            return false;
        } else {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    setWall(lab, i, j, wallCnt);
                }
            }
            lab[m][n] = 0; // 2번째로 세운 벽 되돌리기
        }
        return true;
    }

    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static boolean dfs(int[][] lab, int[][] visited, int m, int n) {
        if (m < 0 || m >= M || n < 0 || n >= N) return false;
        if (visited[m][n] != 0) return false;
        visited[m][n] = 1;
        if (lab[m][n] == 1) return false;
        virusCnt++;

        for(int dir[] : dirs){
            int m1 = m + dir[0];
            int n1 = n + dir[1];

            dfs(lab, visited, m1, n1);
        }
        return true;
    }
}