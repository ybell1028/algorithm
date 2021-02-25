package Baekjoon.DataStructure;

import java.io.*;
import java.util.Stack;

public class Exam3986_좋은단어 {
    public static final int COL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = 0;
        char[] word;

        for(int i = 0; i < N; i++){
            Stack<Character> stack = new Stack<>();
            word = br.readLine().toCharArray();
            for(int j = 0; j < word.length; j++){
                if(stack.isEmpty()) stack.push(word[j]);
                else {
                    if(stack.peek() == word[j]) stack.pop();
                    else stack.push(word[j]);
                }
            }
            if(stack.isEmpty()) num++;
        }
        bw.write(String.valueOf(num + "\n"));
        bw.flush();

        br.close();
        bw.close();
    }
}
