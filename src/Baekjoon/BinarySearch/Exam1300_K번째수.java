package Baekjoon.BinarySearch;

import java.io.IOException;
import java.util.Scanner;

public class Exam1300_K번째수 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 1 ~ 100000
        int K = sc.nextInt();
        long result = 0;

        // A[i][j] = i * j인 2차원 배열을 1차원 배열 B로 만들고 오름차순으로 정렬했을때,
        // B[k]를 구하라. 단 A와 B의 인덱스는 1부터 시작한다.

        long start = 1;
        long end = K;
        long mid = 0;
        while(start <= end){
            long cnt = 0;
            mid = (start + end) / 2;
            for(int i = 1; i <= N; ++i){
                // mid / i ?
                // i 는 1 ~ n 행 중 i번째 행을 가리킨다.
                // 2차원 배열 A에서 i번째 행의 원소들 중 mid 값보다 같거나 작은 원소의 개수
                cnt += Math.min(mid / i, N);
                // count 시 n과 mid / i 중 최솟값을 선택하는 이유는?
                // mid / i 는 절대 n보다 클 수 없기 때문에. (행렬 상 i행의 원소 개수는 무조건 n개이다.)
                // 그렇기 떄문에, mid / i 값이 n보다 크게 나온다면 그냥 n을 count 하면 된다.
            }
            if(cnt >= K){
                // cnt >= k 인 경우, mid는 k번째 수에 포함된다.
                // 그리고 숫자를 낮춰서 재탐색한다. (end = mid - 1)
//                result = mid;
                result = mid;
                end = mid - 1;
            } else {
                // cnt < k 인 경우, mid는 k번째 수에 절대 포함되지 않는다..
                // 그래서 개수를 늘리기 위해 숫자를 높여서 재탐색한다. (start = mid + 1)
                start = mid + 1;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
