import java.io.*;

public class Exam1463 {
    public static int min = 1000000;

    public static void divThree (int x, int cnt){
        if(x % 3 == 0) run(x/3, ++cnt);
        else return;
    }

    public static void divTwo (int x, int cnt){
        if(x % 2 == 0) run(x/2, ++cnt);
        else return;
    }

    public static void subOne (int x, int cnt){
        if (x == 1) return;
        else run(x - 1, ++cnt);
    }

    public static void run (int x, int cnt){
        if (cnt > min) return;
        if (x == 1 && cnt < min) {
            min = cnt;
            return;
        }
        divThree(x, cnt);
        divTwo(x, cnt);
        subOne(x, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        run(x, 0);

        bw.write(String.valueOf(min));
        bw.flush();

        br.close();
        bw.close();
    }
}
