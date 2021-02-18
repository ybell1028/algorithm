//9분 48초
package Baekjoon.Implimentaion;

import java.io.*;

public class Exam1032 {
    public static int MAX_CHAR = 51;
    public static char[] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        pattern = br.readLine().toCharArray();
        for(int i = 1; i < n; ++i){
            String s = br.readLine();
            char[] sAry = s.toCharArray();
            for(int j = 0; j < s.length(); ++j){
                if(sAry[j] != pattern[j]){
                    pattern[j] = '?';
                }
            }
        }

        System.out.println(String.valueOf(pattern));
    }
}
