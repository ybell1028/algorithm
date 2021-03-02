package Programmers.코딩테스트고득점Kit.Greedy;

import java.util.*;

public class 섬연결하기 {
    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;
        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            if(this.cost < o.cost)
                return -1;
            else if(this.cost == o.cost)
                return 0;
            else
                return 1;
        }
    }

    public static int[] parent;
    public static ArrayList<Edge> edgeList;

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return true;
        else return false;
    }

    static class Solution {
        public int solution(int n, int[][] costs) {
            parent = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            edgeList = new ArrayList<Edge>();

            for(int[] cost : costs){
                edgeList.add(new Edge(cost[0], cost[1], cost[2]));
            }

            Collections.sort(edgeList);

            int answer = 0;

            for(int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                if(!isSameParent(edge.v1, edge.v2)) {
                    answer += edge.cost;
                    union(edge.v1, edge.v2);
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        int[][] costs = {{
            0, 1, 1
        }, {
            0, 2, 2
        }, {
            1, 2, 5
        }, {
            1, 3, 1
        }, {
            2, 3, 8
        }};
        System.out.println(s.solution(n, costs));
    }
}
