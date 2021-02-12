import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam11048_Recursive {

    private static int N, M;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());

        N = Integer.parseInt(nm.nextToken());
        M = Integer.parseInt(nm.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            StringTokenizer mapStr = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(mapStr.nextToken());
            }
        }

        search(map,0, 0, 0);
        System.out.println(max);
    }

    private static void search(int[][] map, int r, int c, int sum){
        if(r > N - 1 || c > M - 1) return;

        sum += map[r][c];

        if(r == N - 1 && c == M - 1){
            if(sum > max) {
                max = sum;
            }
            return;
        }

        search(map, r + 1, c, sum);
        search(map, r, c + 1, sum);
        search(map, r + 1, c + 1, sum);
    }
}
