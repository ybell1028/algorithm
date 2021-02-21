//package Baekjoon.Test;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Exam1946 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine());
//        while(T > 0){
//            int N = Integer.parseInt(br.readLine()); // 지원자 수
//            HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
//
//            for(int i = 0; i < N; ++i){
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                int score1 = Integer.parseInt(st.nextToken());
//                int score2 = Integer.parseInt(st.nextToken());
//                hm.computeIfAbsent(score1, s -> new PriorityQueue<>(Collections.reverseOrder())).add(score2);
//            }
//
//            for(int i = 0; i < N; ++i) {
//                int score1 = app[i][0];
//                int score2 = app[i][1];
//
//                for()
//            }
//            T--;
//        }
//    }
//}
