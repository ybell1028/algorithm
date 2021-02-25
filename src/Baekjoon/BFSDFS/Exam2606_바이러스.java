package Baekjoon.BFSDFS;

import java.util.LinkedList;
import java.util.Scanner;

public class Exam2606_바이러스 {
    private static class Graph {
        public LinkedList<Integer> link[];
        int V;
        Graph(int v){
            V = v + 1;
            link = new LinkedList[V];
            for(int i = 0; i < V; ++i){
                link[i] = new LinkedList();
            }
        }

        private void addEdge(int v, int d){
            link[v].add(d);
        }
    }

    public static int cnt = 0;
    public static boolean visited[];

    public static void DFS(int v, Graph g){
        if(visited[v]) return;
        visited[v] = true;
        cnt++;
        while(!g.link[v].isEmpty()){
            int next = g.link[v].poll();
            DFS(next, g);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 컴퓨터의 수
        visited = new boolean[n + 1];
        Graph g = new Graph(n);
        int pair = sc.nextInt();
        for(int i = 0; i < pair; ++i) {
            int v = sc.nextInt();
            int d = sc.nextInt();
            g.addEdge(v, d);
            g.addEdge(d, v);
        }
        DFS(1, g);

        System.out.println(cnt - 1);
    }
}
