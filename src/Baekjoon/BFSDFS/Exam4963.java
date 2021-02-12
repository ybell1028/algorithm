import java.io.*;
import java.util.StringTokenizer;


public class Exam4963 {

    public static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer whST = new StringTokenizer(br.readLine());
            w = Integer.parseInt(whST.nextToken());
            h = Integer.parseInt(whST.nextToken());
            if (w == 0 && h == 0) break;

            int map[][] = new int[h][w];

            for (int i = 0; i < h; i++) { // map에 지도 내용 입력
                StringTokenizer mapST = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(mapST.nextToken());
                }
            }

            bw.write(String.valueOf(solve(map) + "\n"));
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static int solve(int[][] map){
        int h = map.length;
        int w = map[0].length;
        int cnt = 0;
        boolean[][] land = new boolean[h][w]; // 계속해서 육지가 기록되는 land

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){ // 여기가 좌표마다 탐색을 시작하는 부분
//                System.out.println("새로운 좌표로 탐색 시작 : 좌표 : (" + i + ", " + j + ")\n");
                boolean[][] visited = new boolean[h][w]; // 매 시작마다 초기화되는 visited
                if(dfs(map, visited, land, i, j)) cnt++;
            }
        }
        return cnt;
    }

    static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; // 0, 1일때 조사

    public static boolean dfs(int[][] map, boolean[][] visited, boolean[][] land, int x, int y) { //dfs가 한번 끝날때마다 섬 하나 추가

        if (x < 0 || x >= h || y < 0 || y >= w) return false;

        if (visited[x][y] == true) return false;
        visited[x][y] = true;

        if (land[x][y] == true) return false;
        land[x][y] = true;

        if (map[x][y] == 0) return false; // 시작점이 땅이 아니라면 false 반환

//        System.out.println("새로운 땅 발견 : 좌표 : (" + x + ", " + y + ")");
        for (int[] dir : dirs) {
            int x1 = dir[0] + x;
            int y1 = dir[1] + y;

            dfs(map, visited, land, x1, y1);
        }

        return true;
    }
}
