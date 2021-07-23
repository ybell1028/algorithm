package Programmers.YAPP.Week17;

import java.util.*;

public class 합승택시요금 {
    static class Solution {
        public final int MAX_VAL = 20000001;;
        class Graph {
            public int n;
            List<Edge>[] adj;
            public int[][] minCost;

            private Graph(int n) {
                this.n = n;
                minCost = new int[n + 1][n + 1];
                adj = new ArrayList[n + 1];
                for(int i = 1; i < n + 1; ++i){
                    adj[i] = new ArrayList<>();
                    Arrays.fill(minCost[i], MAX_VAL);
                    minCost[i][i] = 0;
                }
            }

            class Edge implements Comparable<Edge> {
                public int v;
                public int cost;
                public Edge(int v, int cost) {
                    this.v = v;
                    this.cost = cost;
                }

                @Override
                public int compareTo(Edge o) {
                    return Integer.compare(this.cost, o.cost);
                }
            }

            private void addEdge(int v1, int v2, int cost){
                adj[v1].add(new Edge(v2, cost));
                adj[v2].add(new Edge(v1, cost));
            }

            private void dijkstra(int start) {
                PriorityQueue<Edge> pq = new PriorityQueue<>();
                pq.add(new Edge(start, 0));
                while (!pq.isEmpty()) {
                    Edge now = pq.poll();
                    if (minCost[start][now.v] < now.cost) continue;
                    for (Edge next : adj[now.v]) {
                        if (minCost[start][next.v] > minCost[start][now.v] + next.cost) {
                            minCost[start][next.v] = minCost[start][now.v] + next.cost;
                            pq.add(next);
                        }
                    }
                }
            }
        }

        public int solution(int n, int s, int a, int b, int[][] fares) {
            Graph g = new Graph(n);
            for(int[] fare : fares){
                g.addEdge(fare[0], fare[1], fare[2]);
            }
            g.dijkstra(s);
            g.dijkstra(a);
            g.dijkstra(b);

            int answer = Integer.MAX_VALUE;

            for(int i = 1; i < n + 1; ++i){
                answer = Math.min(answer, g.minCost[s][i] + g.minCost[a][i] + g.minCost[b][i]);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int[][] fares2 = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        int[][] fares3 = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
        int[][] fares4 = {{1, 2, 3}, {2, 3, 2}, {3, 4, 3}, {1, 4, 3}};
        System.out.println(s.solution(6, 4, 6, 2, fares));
//        System.out.println(s.solution(7, 5, 7, 1, fares2));
//        System.out.println(s.solution(6, 4, 5, 6, fares3));
//        System.out.println(s.solution(4, 1, 3, 3, fares4));
    }
}