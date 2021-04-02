package Baekjoon.BinarySearch;

import java.io.*;
import java.util.*;

public class Exam10816_숫자카드2_real {
    // 해당 수의 하한선, 상한선을 구하는 것이다. 이것 또한 binarySearch를 이용하지만 일반적인 binarySearch랑은 조금 다르다.
    // key값을 찾아도 끝나지 않고 계속 탐색 범위를 줄여가며 탐색을 한다
    static int lowerBound(int[] card, int target) { // lowerBound는 왼쪽
        int left = 0;
        int right = card.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;

            if(card[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    static int upperBound(int[] card, int target) { // upperBound는 오른쪽으로 줄여간다.
        int left = 0;
        int right = card.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;

            if(card[mid] > target) right = mid;
            else left = mid + 1;
        }
        if(card[right] == target) right++;
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 숫자 카드의 갯수
        int[] card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine()); // 숫자 카드의 갯수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) {
            int target = Integer.parseInt(st.nextToken());
            int lower = lowerBound(card, target);
            int upper = upperBound(card, target);
            bw.write(String.valueOf(upper - lower) + " ");
        }
        bw.write("\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
