import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam9613 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //����
		int bigCase = Integer.parseInt(br.readLine()); //Test case

		for(int i = 0; i < bigCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int smallCase = Integer.parseInt(st.nextToken());
			int[] element = new int[smallCase];

			int sum = 0;
			int index = 0;

			while(st.hasMoreTokens()) {
				element[index] = Integer.parseInt(st.nextToken());
				index++;
			}

			for(int j = 0; j < smallCase - 1 ; j++) {
				for (int k = j + 1; k < smallCase; k++) {
					sum += gcd(element[j], element[k]);
				}
			}

			System.out.println(sum);

		}
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else {
			return gcd(b, a%b);
		}
	}

}
