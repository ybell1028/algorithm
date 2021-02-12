package Test;

import java.io.*;
import java.util.Stack;

public class Exam5397_smart {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; ++i){
            Stack<Character> st1 = new Stack<>();
            Stack<Character> st2 = new Stack<>();

            String str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                switch(str.charAt(j)){
                    case '<':{
                        if(!st1.isEmpty())
                            st2.push(st1.pop());
                        break;
                    }
                    case '>':{
                        if(!st2.isEmpty())
                            st1.push(st2.pop());
                        break;
                    }
                    case '-':{
                        if(!st1.isEmpty())
                            st1.pop();
                        break;
                    }
                    default:{
                        st1.push(str.charAt(j));
                    }
                }
            }

            while(!st2.isEmpty())
                // 스택 2에 남아있는 요소들을 전부 스택 1에 다시 담기
                st1.push(st2.pop());

            StringBuilder sb = new StringBuilder();
            while(!st1.isEmpty())
                sb.append(st1.pop());
            System.out.println(sb.reverse());
        }
    }
}
