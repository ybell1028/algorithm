import java.io.*;
import java.util.StringTokenizer;

public class Exam3985 {
    public static final int COL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] cake = new int[L];

        int eMax = 0;
        int rMax = 0;
        int eGuest = -1; // 가장 많은 조각을 받을 것으로 예상되는 방청객
        int rGuest = -1; // 실제 많은 조각 받는 방청객

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int tmp = Math.abs(start - end) + 1;
            int cnt = 0;
            if (tmp > eMax){
                eMax = tmp;
                eGuest = i + 1;
            }
            for(int j = start - 1; j < end; j++){
                if(cake[j] == 0) {
                    cake[j] = i + 1;
                    cnt++;
                }
            }
            if(cnt > rMax){
                rMax = cnt;
                rGuest = i + 1;
            }
        }

        bw.write(String.valueOf(eGuest + "\n"));
        bw.write(String.valueOf(rGuest + "\n"));

        bw.flush();

        br.close();
        bw.close();
    }

}
