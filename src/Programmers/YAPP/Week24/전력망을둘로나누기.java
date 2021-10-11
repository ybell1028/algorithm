package Programmers.YAPP.Week24;
import java.util.*;

public class 전력망을둘로나누기 {
    class Solution {
        class Graph {
            public int N;
            public List<Integer>[] adjList;

            Graph(int n){
                N = n;
                adjList = new List[N];
                for(int i = 0; i < N; ++i){
                    adjList[i] = new LinkedList<>();
                }
            }

            private void addEdge(int v1, int v2){
                adjList[v1].add(v2);
                adjList[v2].add(v1);
            }
        }

        public int solution(int n, int[][] wires) {
            int min = Integer.MAX_VALUE;

            Graph g = new Graph(n + 1);

            for(int [] w : wires){
                g.addEdge(w[0], w[1]);
            }

            for(int[] w : wires){
                int cnt0 = BFS(g, w[0], w[1]);
                int cnt1 = BFS(g, w[1], w[0]);
                min = Math.min(min, Math.abs(cnt0 - cnt1));
            }

            return min;
        }

        public int BFS(Graph g, int start, int disconnected){
            int cnt = 0;
            boolean[] visit = new boolean[g.N];
            visit[disconnected] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            while(!queue.isEmpty()){
                int node = queue.poll();
                if(visit[node]) continue;
                visit[node] = true;
                cnt++;
                for(int n : g.adjList[node]) queue.add(n);
            }

            return cnt;
        }
    }
}
