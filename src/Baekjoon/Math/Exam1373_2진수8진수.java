package Baekjoon.Math;

import java.io.*;

public class Exam1373_2진수8진수 {
    private static int OCT_DEGREE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int front = -1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - 48 == 1){
                front = i;
                break;
            }
        }

        if(front == -1) front = 0;

        s = s.substring(front); // 스트링 앞에 0 자르기

        int[] bin = new int[s.length()];
        int[] oct;

        for (int i = 0; i < s.length(); i++) {
            bin[i] = Integer.parseInt(s.substring(i, i + 1));
        }

        int quo = (s.length() / OCT_DEGREE);
        int rem = (s.length() % OCT_DEGREE); // 나올수 있는 값 0, 1, 2

        if (rem == 0) {
            rem = OCT_DEGREE; // 편의를 위해 0일땐 3으로 바꿔 줌
            oct = new int[quo];
        } else oct = new int[quo + 1];

        for (int i = 0; i < rem; i++) {
            if (bin[i] == 1)
                oct[0] += Math.pow(2, rem - (i + 1)); // 2 1 0, 1 0, 0
        }

        bw.write(String.valueOf(oct[0]));

        if (s.length() > OCT_DEGREE) {
            for (int i = 1; i < oct.length; i++) { // 여기는 oct의 인덱스

                int start = (i - 1) * OCT_DEGREE + rem;// rem = 3일때 3, 6, 9... rem = 1일때 2, 5, 8 ...
                int end = start + OCT_DEGREE - 1;

                for (int j = start; j <= end; j++) { // 여기는 bin의 인덱스, rem + 1부터 rem + 3까지(2~4) rem + 4 부터 rem + 6 (5 ~ 7까지)

                    if (bin[j] == 1) oct[i] += Math.pow(2, end - j);

                }
                bw.write(String.valueOf(oct[i]));
            }
        }
        bw.flush();
    }
}
