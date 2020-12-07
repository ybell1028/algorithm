package Greedy;

import java.util.LinkedList;
import java.util.Scanner;

public class Exam1541 {
    public static void calc(LinkedList<Integer> num, LinkedList<Character> oper, int i){
        if(oper.get(i) == '+') {
            num.set(i, num.get(i) + num.get(i + 1));
            num.remove(i + 1);
            oper.remove(i);
        }
        else {
            num.set(i, num.get(i) - num.get(i + 1));
            num.remove(i + 1);
            oper.remove(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String formula = sc.next() + "=";

        LinkedList<Integer> num = new LinkedList<Integer>();
        LinkedList<Character> oper = new LinkedList<Character>();

        int i = 0;
        int j = i;
        for (i = 0; i < formula.length(); i = j + 1) {
            boolean end = false;
            for (j = i; true; j++) {
                if(formula.charAt(j) == '+' || formula.charAt(j) == '-'){
                    num.add(Integer.parseInt(formula.substring(i, j)));
                    oper.add(formula.charAt(j));
                    break;
                } else if (formula.charAt(j) == '='){
                    num.add(Integer.parseInt(formula.substring(i, j)));
                    end = true;
                    break;
                }
            }
            if(end == true) break;
        }

        int minus = 0;

        while(!oper.isEmpty()){
            if(minus >= oper.size()) {
                for(i = 0; i < oper.size(); i++){
                    calc(num, oper, i);
                    i--;
                }
                break;
            }
            if (oper.get(minus) == '-'){
                for(i = minus + 1; i < oper.size(); i++){
                    if(oper.get(i) == '+') {
                        calc(num, oper, i);
                        i--;
                    }
                    else {
                        minus = i - 1;
                        break;
                    }
                }
            }
            minus++;
        }
        System.out.println(num.poll());
    }
}
