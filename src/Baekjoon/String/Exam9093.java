import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            while(st.hasMoreTokens()) {
                char[] word = st.nextToken().toCharArray();
                Stack<Character> stack = new Stack<Character>();

                for(int j = 0; j < word.length; j++){
                    stack.push(word[j]);
                }
                for(int j = 0; j < word.length; j++){
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
