import java.io.*;

public class Exam10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] alpha = new int[26];

        for(int i = 0; i < s.length(); i++){
            alpha[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < alpha.length; i++){
            bw.write(alpha[i] + " ");
        }

        bw.flush();
    }
}
