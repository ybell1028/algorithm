package Baekjoon.Math;

import java.util.Scanner;

public class Exam2609_최대공약수와최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));
		
	}

	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else {
			return gcd(b, a%b);
		}
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);  
	}
	
}
