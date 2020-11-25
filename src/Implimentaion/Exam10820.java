import java.io.*;

public class Exam10820 {
    public static int classify(char ch){
        if(ch >= 'a' && ch <= 'z') return 0;
        else if(ch >= 'A' && ch <= 'Z') return 1;
        else if(ch >= '0' && ch <= '9') return 2;
        else return 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";

        while((input = br.readLine()) != null){
            int[] ary = new int[4];

            for(int i = 0; i < input.length(); i++){
                char ch = input.charAt(i);
                ary[classify(ch)]++;
            }

            for(int i = 0; i < ary.length; i++)
                bw.write(ary[i] + " ");
            bw.write("\n");

            bw.flush();
        }
    }
}
