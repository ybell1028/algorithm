import java.io.*;
import java.util.StringTokenizer;

public class Exam1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        double end = Math.sqrt(M);

        if (N == 1) N = 2;

        for(int i = N; i <= M; i++){
            boolean prime = true;
            for(int j = 2; j <= (int)end; j++){
                if(i != j && i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if(prime) bw.write(i + "\n");
        }
        bw.flush();
    }
}
