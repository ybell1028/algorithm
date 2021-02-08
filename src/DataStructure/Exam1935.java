package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam1935 {
    public static double calc(Stack<Double> stack, char ch, double a, double b) {
        double result = 0.00;

        switch (ch) {
            case '+':
                stack.push(b + a);
                break;
            case '-':
                stack.push(b - a);
                break;
            case '*':
                stack.push(b * a);
                break;
            case '/':
                stack.push(b / a);
                break;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] post = br.readLine().toCharArray();
        double[] values = new double[N];
        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < post.length; i++){
            char ch = post[i];

            switch(ch){
                case '+':
                case '-':
                case '*':
                case '/':
                    calc(stack, ch, stack.pop(), stack.pop());
                    break;
                default :
                    stack.push(values[ch - 'A']); // A부터 순서대로 N개의 영대문자만이 사용되며, 길이는 100을 넘지 않는다
                    break;
            }
        }

        System.out.printf("%.2f", stack.peek());
    }
}
