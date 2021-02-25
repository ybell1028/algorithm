package Baekjoon.Math;

import java.io.*;

public class Exam1212_8진수2진수 {
    private static int OCT_DEGREE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int octStart = -1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - 48 > 0 && s.charAt(i) - 48 < 8){
                octStart = i;
                break;
            }
        }
        if(octStart == - 1) octStart = 0;
        s = s.substring(octStart);

        int[] oct = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            oct[i] = Integer.parseInt(s.substring(i, i + 1));
        }


        /*          여기까지 8진수 전처리         */

        int top = oct[0];
        int div = (int)Math.pow(2, OCT_DEGREE);
        int split = -1; // 나누는 지점

        for(int i = 0; i < OCT_DEGREE; i++){
            div /= 2;
            if(top / div >= 1) {
                split = i;
                break;
            }
        }

        if (split == -1) bw.write(String.valueOf(oct[octStart]));
        else {
            int[] bin = new int[s.length() * OCT_DEGREE];

            div = (int)Math.pow(2, OCT_DEGREE);
            for(int i = 0; i < OCT_DEGREE; i++){
                div /= 2;
                bin[i] = top / div;
                if (bin[i] >= 1) top %= div;
                if(i >= split) bw.write(String.valueOf(bin[i]));
            }

            if(octStart >= 0) {
                for (int i = 1; i < oct.length; i++) {
                    div = (int)Math.pow(2, OCT_DEGREE);
                    int moded = oct[i]; // 451일때 5
                    int start = i * OCT_DEGREE; // 4일때 start = 0
                    for (int j = start; j < start + OCT_DEGREE; j++) {
                        div /= 2;
                        bin[j] = moded / div;
                        if(bin[j] >= 1) moded %= div;
                        bw.write(String.valueOf(bin[j]));
                    }
                }
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}