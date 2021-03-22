package Baekjoon.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam1260_DFS와BFS_2 {
    static int N, M, V, cnt;
    static boolean visited[];

    static class Graph {
        int N;
        LinkedList<Integer>[] edgeList;

        Graph(int n){
            N = n;
            edgeList = new LinkedList[N + 1];
            for(int i = 0; i <= N; ++i){
                edgeList[i] = new LinkedList<>();
            }
        }

        void addEdge(int start, int end){
            edgeList[start].add(end);
        }

        void sortEdgeList(){
            for(LinkedList<Integer> list : edgeList) {
                Collections.sort(list);
            }
        }

        void DFS(int now){
            if(cnt == N) return;
            else if(visited[now]) return;
            else {
                System.out.print(now + " ");
                visited[now] = true;
                cnt++;
                for(int next : edgeList[now]){
                    DFS(next);
                }
            }
        }

        void BFS(int s){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            while(!queue.isEmpty()){
                if(cnt == N) break;
                int now = queue.poll();
                if(!visited[now]){
                    visited[now] = true;
                    System.out.print(now + " ");
                    while(!edgeList[now].isEmpty()){
                        queue.add(edgeList[now].poll());
                    }
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        Graph g = new Graph(N);

        for(int i = 0; i < M; ++i){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            g.addEdge(start, end);
            g.addEdge(end, start);
        }

        cnt = 0;
        visited = new boolean[N + 1];
        g.sortEdgeList();
        g.DFS(V);

        System.out.println();

        cnt = 0;
        visited = new boolean[N + 1];
        g.sortEdgeList();
        g.BFS(V);
        System.out.println();

        br.close();
    }
}
