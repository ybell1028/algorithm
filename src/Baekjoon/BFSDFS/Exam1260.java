package BFSDFS;

import java.io.*;
import java.util.*;

class Graphs{
    private int V; // 노드의 갯수
    protected LinkedList<Integer> adj[]; // 인접 리스트

    Graphs(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    protected void addList(int v, int w){
        adj[v].add(w);
    }

    protected void BFS(int s) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            bw.write( String.valueOf(s) + " ");

            Iterator<Integer> i = adj[s].listIterator();
            //이미 adj에는 정점 s의 이웃 노드들이 들어있음
            while(i.hasNext()){
                int next = i.next();
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        bw.flush();
        bw.close();
    }

    protected void DFS(int s){
        boolean[] visited = new boolean[V];

        DFSUtil(s, visited);

        System.out.println();
    }

    protected void DFSUtil(int s, boolean[] visited) {

        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> i = adj[s].listIterator();

        while (i.hasNext()) {
            int next = i.next();
            if(!visited[next]) DFSUtil(next, visited);
        }
    }
}

public class Exam1260 {
    public static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stNMV = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stNMV.nextToken());
        M = Integer.parseInt(stNMV.nextToken());
        V = Integer.parseInt(stNMV.nextToken());

        Graphs g = new Graphs(N + 1);

        for(int i = 0; i < M; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.addList(v, w);
            g.addList(w, v);
        }

        for(int i = 0; i < N + 1; ++i){
            Collections.sort(g.adj[i]);
        }

        g.DFS(V);
        g.BFS(V);

        br.close();
    }
}