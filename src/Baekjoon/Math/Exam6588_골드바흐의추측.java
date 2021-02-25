package Baekjoon.Math;

import java.util.*;

public class Exam6588_골드바흐의추측 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			boolean isTrue = false;
			
			if(n == 0) break;
			
			for(int i = 2; i <= n - 2; i++) {
				if(!isPrime(i)) continue;
				
				if(isPrime(n - i)) {
					System.out.println(n + " = " + i + " + " + (n-i));
					isTrue = true;
					break;
				}
			}
			if(!isTrue)
				System.out.println("Goldbach's conjecture is wrong.");
		}
	}

	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if((num % i) == 0) return false;
		}
		return true;
	}
}
