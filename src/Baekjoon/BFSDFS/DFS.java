//package BFSDFS;
//
//import java.io.*;
//import java.util.*;
//
////미로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면
////다시 가장 가까운 갈림길로 돌아와서 이곳으로부터 다른 방향으로 다시 탐색을 진행하는 방법과 유사하다.
////즉, 넓게(wide) 탐색하기 전에 깊게(deep) 탐색하는 것이다.
////사용하는 경우: 모든 노드를 방문 하고자 하는 경우에 이 방법을 선택한다.
//
///* 인접 리스트를 이용한 방향성 있는 그래프 클래스 */
//class Graph {
//    private int V;   // 노드의 개수
//    private LinkedList<Integer> adj[]; // 인접 리스트
//
//    /** 생성자 */
//    Graph(int v) {
//        V = v; // 그래프의 크기
//        adj = new LinkedList[v]; // LinkedList로 인접 리스트 생성
//        for (int i=0; i<v; ++i) // 인접 리스트 초기화
//            adj[i] = new LinkedList(); // 리스트를 여러줄기로 생성
//    }
//
//    /** 노드를 연결 v->w */
//    void addEdge(int v, int w) { adj[v].add(w); } // 리스트 노드 v에 w를 연결(추가)
//
//    /** DFS에 의해 사용되는 함수 */
//    void DFSUtil(int v, boolean visited[]) {
//        // 현재 노드를 방문한 것으로 표시하고 값을 출력
//        visited[v] = true;
//        System.out.print(v + " ");
//
//        // 방문한 노드와 인접한 모든 노드를 가져온다.
//        // 0의 경우 listIterator는 1 -> 2 -> 4
//        Iterator<Integer> i = adj[v].listIterator();
//        while (i.hasNext()) {
//            // i.next()로 인해서 n에 1이 들어가고 iteratorList에서는 삭제됨
//            int n = i.next();
//            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
//            if (!visited[n])
//                DFSUtil(n, visited); //n을 방문하게 끔 순환 호출
//        }
//    }
//
//    /** 주어진 노드를 시작 노드로 DFS 탐색 */
//    /** 주어진 노드를 시작 노드로 DFS 탐색 */
//    void DFS(int v) {
//        // 노드의 방문 여부 판단 (초깃값: false)
//        // V는 자신과 연결된 노드의 수
//        boolean visited[] = new boolean[V];
//
//        // v를 시작 노드로 DFSUtil 순환 호출
//        DFSUtil(v, visited);
//    }
//
//    /** DFS 탐색 */
//    void DFS() {
//        // 노드의 방문 여부 판단 (초깃값: false)
//        boolean visited[] = new boolean[V];
//
//        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
//        for (int i=0; i<V; ++i) {
//            if (visited[i] == false)
//                DFSUtil(i, visited);
//        }
//    }
//}
//
//public class DFS {
//    /** 사용 방법 */
//    public static void main(String args[]) {
//        Graph g = new Graph(5);
//
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(0, 4);
//        g.addEdge(1, 0);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 1);
//        g.addEdge(2, 3);
//        g.addEdge(2, 4);
//        g.addEdge(3, 2);
//        g.addEdge(3, 4);
//        g.addEdge(4, 0);
//        g.addEdge(4, 2);
//        g.addEdge(4, 3);
//
//        g.DFS(0); /* 주어진 노드를 시작 노드로 DFS 탐색 */
////        g.DFS(); /* 비연결형 그래프의 경우 */
//    }
//}
