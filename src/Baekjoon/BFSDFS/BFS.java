package Baekjoon.BFSDFS;

//시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법이다.
//즉, 깊게(deep) 탐색하기 전에 넓게(wide) 탐색하는 것이다.
//사용하는 경우: 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택한다.


/* 1. a 노드(시작 노드)를 방문한다. (방문한 노드 체크)
 - 큐에 방문된 노드를 삽입(enqueue)한다.
 - 초기 상태의 큐에는 시작 노드만이 저장
   = 즉, a 노드의 이웃 노드를 모두 방문한 다음에 이웃의 이웃들을 방문한다.
2. 큐에서 꺼낸 노드과 인접한 노드들을 모두 차례로 방문한다.
 - 큐에서 꺼낸 노드를 방문한다.
 - 큐에서 커낸 노드과 인접한 노드들을 모두 방문한다.
   = 인접한 노드가 없다면 큐의 앞에서 노드를 꺼낸다(dequeue).
 - 큐에 방문된 노드를 삽입(enqueue)한다.
3. 큐가 소진될 때까지 계속한다. */


import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    static class Graph {
        private int V; // 노드의 개수
        private LinkedList<Integer> adj[]; // 인접 리스트

        /** 생성자 */
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) // 인접 리스트 초기화
                adj[i] = new LinkedList();
        }

        /** 노드를 연결 v->w */
        void addEdge(int v, int w) { adj[v].add(w); }

        /** s를 시작 노드로 한 BFS로 탐색하면서 탐색한 노드들을 출력 */
        void BFS(int s) {
            // 노드의 방문 여부 판단 (초깃값: false)
            boolean visited[] = new boolean[V];
            // BFS 구현을 위한 큐(Queue) 생성
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
            visited[s] = true;
            queue.add(s);

            // 큐(Queue)가 빌 때까지 반복
            while (queue.size() != 0) {
                // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
                s = queue.poll();
                System.out.print(s + " ");

                // 방문한 노드와 인접한 모든 노드를 가져온다.
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
                    if (!visited[n]) { // 방문했던 곳은 queue에 담지 않는다
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        g.addEdge(4, 3);

        g.BFS(0); /* 주어진 노드를 시작 노드로 BFS 탐색 */
    }
}
