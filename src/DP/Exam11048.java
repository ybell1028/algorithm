import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//핵심 내용
//        시간 초과 이슈를 줄이기 위해 DP를 활용하자!!
//        (1,0), (0,1), (1,1) 방향으로 이동할 수 있지만 점화식을 세울 때 생각해보면, 캔디 숫자는 음수가 될 수 없으므로 (1,1) 즉 대각선 방향으로 가는 것은 최댓값이 될 수 없으므로 제외해도 무방합니다.
//        아래쪽과 오른쪽으로 이동했을 때 최댓값이 될 수 있는 지를 고민하면 되는 문제입니다.
//        즉, candyCntMap[i][j] += Math.max(candyCntMap[i-1][j], candyCntMap[i][j-1]) + inputAry[i][j];
//        해결 방법
//        오른쪽과 아래쪽 값만 비교하여 큰 쪽으로 이동하면 됩니다!!!


public class Exam11048 {

    private static int N, M;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());

        N = Integer.parseInt(nm.nextToken());
        M = Integer.parseInt(nm.nextToken());

        int[][] map = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            StringTokenizer mapStr = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(mapStr.nextToken());
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                map[i][j] += Math.max(map[i-1][j], map[i][j-1]);
            }
        }
        System.out.println(map[N][M]);
    }
}
