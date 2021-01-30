package Test;

import java.util.Scanner;

public class Exam2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A, B, V;

        A = sc.nextInt();
        B = sc.nextInt();
        V = sc.nextInt();

        int pd = A - B; // 하루에 움직이는 거리

        int result = (V - A) / pd + 1;

        System.out.println(result);
    }
}
