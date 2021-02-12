package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam2841 {

    public static final int LINE_RANGE = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //핵심 = 만약, 어떤 줄의 프렛을 여러 개 누르고 있다면, 가장 높은 프렛의 음이 발생한다.
        //문제 목표 = 첫째 줄에 멜로디를 연주하는데 필요한 최소 손가락 움직임을 출력한다.
        int n = Integer.parseInt(st.nextToken()); // 멜로디에 포함되어 있는 음의 수, ≤ 500,000
        int p = Integer.parseInt(st.nextToken()); // 한 줄에 있는 프렛의 수, 2 ≤ P ≤ 300,000

        Stack<Integer>[] pret = new Stack[LINE_RANGE + 1];

        for (int i = 1; i < LINE_RANGE + 1; ++i) {
            pret[i] = new Stack();
        }

        int finger = 0; // 손가락으로 프렛을 한 번 누르거나 떼는 것을 손가락을 한 번 움직였다고 한다.

        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int newPret = Integer.parseInt(st.nextToken());
            while (!pret[line].isEmpty()) {
                if (pret[line].peek() > newPret) {
                    pret[line].pop();
                    finger++;
                } else {
                    if (pret[line].peek() < newPret) {
                        pret[line].add(newPret);
                        finger++;
                    }
                    break;
                }
            }
            if (pret[line].isEmpty()) {
                pret[line].add(newPret);
                finger++;
            }
        }
        System.out.println(finger);
    }
}
