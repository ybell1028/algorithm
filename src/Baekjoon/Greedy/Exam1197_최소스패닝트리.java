package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam1197_최소스패닝트리 {
    static class Edge implements Comparable<Edge>{
        public int start; // 출발지
        public int end; // 목적지
        public int weight; // 가중치

        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    static class Graph{
        private int V;
        public ArrayList<Edge>[] edgeList;
        Graph(int v){
            V = v;
            edgeList = new ArrayList[V + 1];
            for(int i = 0; i < edgeList.length; ++i){
                edgeList[i] = new ArrayList<>();
            }
        }

        void addEdge(Edge e){
            edgeList[e.start].add(e);
        }
    }

    public static void main(String[] args) throws IOException {
        //프림 알고리즘 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int sum = 0;

        Graph g = new Graph(V);

        for(int i = 0; i < E; ++i){ // 그래프 세팅
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.addEdge(new Edge(a, b, w));
            g.addEdge(new Edge(b, a, w));
        }

        int cnt = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V + 1];

        queue.add(1);
        while(!queue.isEmpty()){
            int minV = queue.poll();
            visited[minV] = true;
            for(Edge e : g.edgeList[minV]){
                if(!visited[e.end]) pq.add(e);
            }

            while(!pq.isEmpty()){
                Edge minE = pq.poll();
                if(!visited[minE.end]){
                    queue.add(minE.end);
                    visited[minE.end] = true;
                    sum += minE.weight;
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
