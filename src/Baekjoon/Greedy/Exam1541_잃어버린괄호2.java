package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1541_잃어버린괄호2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        boolean plus = false;
        //식의 맨 앞이 -가 아니라면 +를 붙혀준다.
        if(s.charAt(0) != '-') {
            plus = true;
            s = "+" + s;
        }
        int result = 0;

        int end = 0;
        for(int i = 0; i < s.length(); i=end){
            end++;
            while(end < s.length() && (s.charAt(end) != '+' && s.charAt(end) != '-')) end++;
            if(s.charAt(i) == '+'){
                if(plus){
                    result += Integer.parseInt(s.substring(i + 1, end));
                } else {
                    result -= Integer.parseInt(s.substring(i + 1, end));
                }
            } else if(s.charAt(i) == '-'){
                result -= Integer.parseInt(s.substring(i + 1, end));
                if(plus){
                    plus = false;
                }
            }
        }
        System.out.println(result);
    }
}
