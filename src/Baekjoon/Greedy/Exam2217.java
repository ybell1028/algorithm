package Greedy;

import java.io.*;

public class Exam2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int rope[] = new int[10001];
        int min = 10001;
        int max = -1;

        for(int i = 0; i < n; i++){
            int weight = Integer.parseInt(br.readLine());
            if(weight < min) min = weight; //min은 가장 적은 중량을 받칠수 있는 로프
            if(weight > max) max = weight; //max은 가장 많은 중량을 받칠수 있는 로프
            rope[weight]++;
        }

        int prevWeight = min;
        int line = n;
        int maxWeight = prevWeight * n;//maxWeight는 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량
        line -= rope[prevWeight];

        for(int i = prevWeight + 1; i <= max; i++){
            if(rope[i] > 0){
                if(maxWeight < i * line)
                    maxWeight = i * line;
                line -= rope[i];
            }
        }

        bw.write(String.valueOf(maxWeight + "\n"));
        bw.flush();

        br.close();
        bw.close();
    }
}
