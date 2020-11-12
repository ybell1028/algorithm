//1. 오른쪽에서 왼쪽으로 이동하면서 n과 n-1을 비교한다. (배열의 크기 = n)
//
//2. n-1 < n인경우를 찾는다. 찾은 인덱스를 기준으로 왼쪽 영역과 오른쪽 영역을 나눌 수 있다.
//
//ex) 12543  --> 12 543
//
//123645987  --> 123645 987
//
//3. 해당 인덱스에 있는 숫자를 가지고 오른쪽 영역에서 오른쪽부터 왼쪽영역으로 움직이면서 크기를 비교한다.
//
//4. 크다면 자리를 바꾼다.
//
//5. 오른쪽영역의 숫자를 오름차순으로 정렬해준다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam10972 {
    public static void main(String[] args) throws IOException {
        Exam10972 exam = new Exam10972();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int[] ary = new int[N];

        for(int i = 0; i < N; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }

        if(exam.nextPermutation(ary)){
            for(int i = 0; i < N; i++){
                System.out.print(ary[i] + " ");
            }
            System.out.println();
        }
        else
            System.out.println("-1");
    }

    private boolean nextPermutation(int ary[]){
        //뒤에서부터 탐색하면서 a-1보다 a가 더 큰 경우를 찾음
        //즉 앞쪽 요소보다 뒷쪽 요소가 더 클때
        //ex1) 12543  --> 12 543
        //ex2) 123645987  --> 123645 987
        //ex3) 12345 --> a = 4, b = 4
        int a = ary.length - 1;

        while(a > 0 && (ary[a-1] >= ary[a])) a--;
        // ex1)의 경우 a = 2
        if(a <= 0) return false;

        //다시 뒤에서부터 탐색하며 a-1보다 b가 더 큰 경우 찾음
        int b = ary.length - 1;
        while(ary[a-1] <= ary[b]) b--;
        // ex1)의 경우 b = 4

        //a와 b를 swap
        // ex1) 13 542
        swap(ary, a-1, b);

        //a에서부터 끝까지를 오름차순 정렬
        int start = a; //a = 2
        int end = ary.length - 1; //end = 4

        while(start < end){
            swap(ary, start, end);
            start++;
            end--;
        }
        return true;
    }

    private void swap(int[] ary, int n1, int n2){
        int temp = ary[n1];
        ary[n1] = ary[n2];
        ary[n2] = temp;
    }
}
