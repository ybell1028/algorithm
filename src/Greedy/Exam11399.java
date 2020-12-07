package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam11399 { // 앞에 시간이 소요되는 만큼 뒤에도 같이 대기해야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        int[] line = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line);

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                sum += line[j];
            }
        }

        System.out.println(sum);

        br.close();
    }
}
