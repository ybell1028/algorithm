package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam15591 {

    public static class Dest{
        private int d;
        private int usado;
        Dest(int d, int usado){
            this.d = d;
            this.usado = usado;
        }
    }

    public static class Graph{
        private int V;
        private ArrayList<Dest> link[]; // 링크를 여러개 만들까?
        Graph(int v){
            V = v + 1;
            link = new ArrayList[V];
            for(int i = 0; i < V; ++i){
                link[i] = new ArrayList<>();
            }
        }
        private void addEdge(int v, Dest d){
            link[v].add(d);
        }

        private int BFS(int k, int v){
            int cnt = 0;
            Queue<Integer> queue = new LinkedList<>();
            if(link[v].isEmpty()) return 0;
            boolean[] visited = new boolean[V];
            visited[v] = true;
            queue.add(v);
            while(!queue.isEmpty()){
                v = queue.poll();
                for(int i = 0; i < link[v].size(); ++i){
                    Dest dest = link[v].get(i);
                    if(!visited[dest.d] && dest.usado >= k){ // usado가 k 보다 작다면 break;
                        visited[dest.d] = true;
                        queue.add(dest.d);
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
    //소들은 MooTube에 1부터 N까지 번호가 붙여진 N (1 ≤ N ≤ 5,000)개의 동영상을 이미 올려 놓았다.
    //존은 두 동영상이 서로 얼마나 가까운 지를 측정하는 단위인 “USADO”를 만들었다.
    // 존은 어떤 주어진 MooTube 동영상에 대해, 값 K를 정해서 그 동영상과 USADO가 K 이상인 모든 동영상이 추천되도록 할 것이다.
    // 존은 너무 많은 동영상이 추천되면 소들이 일하는 것이 방해될까 봐 걱정하고 있다! 그래서 그는 K를 적절한 값으로 결정하려고 한다.

    public static boolean[][] added;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()); // Q


        //존은 N-1개의 동영상 쌍을 골라서 어떤 동영상에서
        //다른 동영상으로 가는 경로가 반드시 하나 존재하도록 했다.

        Graph g = new Graph(n);

        int p, d, r;

        for(int i = 0; i < n - 1; ++i){ // n = 4일때 0 1 2
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()); // q
            r = Integer.parseInt(st.nextToken());
            Dest dest1 = new Dest(d, r);
            Dest dest2 = new Dest(p, r);
            g.addEdge(p, dest1);
            g.addEdge(d, dest2);
        }
        int[] cnt = new int[q];
        for(int i = 0; i < q; ++i){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken()); // usado가 k 이상인 영상의 갯수
            int v = Integer.parseInt(st.nextToken()); // 동영상 v에서 시작해서

            cnt[i] = g.BFS(k, v);
        }

        for(int i = 0; i < q; ++i){
            System.out.println(cnt[i]);
        }
    }
}

