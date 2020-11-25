import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<String> queue = new LinkedList<>();

        while(st.hasMoreTokens()){
            queue.add(st.nextToken());
        }

        long AB = Long.parseLong(queue.poll() + queue.poll());
        long CD = Long.parseLong(queue.poll() + queue.poll());

        System.out.println(AB + CD);
    }
}
