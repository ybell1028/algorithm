package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam2841 {

    public static class maxHeap {
        // 최대 힙이란 부모노드엔 큰 값이 자식 노드엔 작은값이, 같은 레벨 노드 끼린 큰 값이 왼쪽(k - 1) 작은 값이 오른쪽 (k)
        ArrayList<Integer> heap;

        public maxHeap() {
            heap = new ArrayList<Integer>();
            heap.add(1000000); // 인덱스 1부터 시작하기 위함
        }

        private int getItem(int i){
            return heap.get(i);
        }
        private int getSize(){
            return heap.size();
        }

        private void insert(int val){
            heap.add(val);
            int p = heap.size() - 1;
            while(p > 1 && heap.get(p / 2) < heap.get(p)){
                // heap.get(p / 2) = 부모노드
                // heap.get(p) = 자식노드
                int temp =  heap.get(p / 2);
                heap.set(p / 2, heap.get(p));
                heap.set(p, temp);

                p /= 2;
            }
        }

        private int delete(){
            if(heap.size() - 1 < 1){
                return 0;
            }

            int max = heap.get(1);
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int p = 1;

            while(p * 2 < heap.size()){
                int big = heap.get(p * 2);
                int bigP = p * 2;

                if(p * 2 + 1 < heap.size() && big < heap.get(p * 2 + 1)){
                    big = heap.get(p * 2 + 1);
                    bigP = p * 2 + 1;
                }

                if(heap.get(p) > big) break;

                int temp = heap.get(p);
                heap.set(p, heap.get(bigP));
                heap.set(bigP, temp);
                p = bigP;
            }
            return max;
        }
    }

    public static final int LINE_RANGE = 6;
    public static final int PRET_RANGE = 300000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //핵심 = 만약, 어떤 줄의 프렛을 여러 개 누르고 있다면, 가장 높은 프렛의 음이 발생한다.
        //문제 목표 = 첫째 줄에 멜로디를 연주하는데 필요한 최소 손가락 움직임을 출력한다.
        int n = Integer.parseInt(st.nextToken()); // 멜로디에 포함되어 있는 음의 수, ≤ 500,000
        int p = Integer.parseInt(st.nextToken()); // 한 줄에 있는 프렛의 수, 2 ≤ P ≤ 300,000

        maxHeap[] heap = new maxHeap[LINE_RANGE + 1];
        boolean[][] pret = new boolean[LINE_RANGE + 1][p + 1];

        for(int i = 0; i < LINE_RANGE + 1; ++i){
            heap[i] = new maxHeap();
        }

        int finger = 0; // 손가락으로 프렛을 한 번 누르거나 떼는 것을 손가락을 한 번 움직였다고 한다.

        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int newPret = Integer.parseInt(st.nextToken());

            if(!pret[line][newPret]) {
                // 프렛을 아직 누르고 있지 않을 경우
                pret[line][newPret] = true;
                heap[line].insert(newPret);
                finger++;
            }

            if(heap[line].getSize() > 0){
                while(heap[line].getItem(1) > newPret){
                    heap[line].delete();
                    finger++;
                }
            } else {
                heap[line].insert(newPret);
            }
        }
        System.out.println(finger);
    }
}
