package Baekjoon.DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Exam1918_후위표기식 {
    public static int priority(char ch) {
        if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char infix[];

        Stack<Character> operator = new Stack<>();

        infix = sc.next().toCharArray();

        for (int i = 0; i < infix.length; i++) {
            if (infix[i] >= 'A' && infix[i] <= 'Z') { // 글자는 그냥 출력
                System.out.print(infix[i]);
            } else if (infix[i] == '(') {
                operator.add(infix[i]);
            } else if (infix[i] == ')') { // 중위식에서 뒷 괄호를 만나면
                while (!operator.isEmpty()) {
                    if (operator.peek() == '(') { // 스택을 검사 => 앞괄호를 만나면
                        operator.pop(); // 앞괄호 삭제
                        break; // 루프 탈출
                    }
                    System.out.print(operator.pop()); // 스택을 검사 => 앞괄호가 아니면 그냥 출력
                }

            } else { // * / + - 일 경우
                while (!operator.isEmpty() && priority(operator.peek()) >= priority(infix[i])) { // 스택의 top과 현재 탐색중인 중위식 요소를 비교
                    System.out.print(operator.pop());
                }
                operator.add(infix[i]);//다시 담는다.
            }
        }
        while (!operator.isEmpty()) {
            // 반복 끝났는데 스택이 다 비어있지 않으면
            System.out.print(operator.pop());
            // 스택 상단 값 출력
        }
        System.out.println();
    }
}
