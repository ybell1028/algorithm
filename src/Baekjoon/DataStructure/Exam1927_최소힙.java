package Baekjoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exam1927_최소힙 {
    public static class minHeap{
        ArrayList<Integer> heap;

        public minHeap(){
            heap = new ArrayList<>();
            heap.add(Integer.MAX_VALUE);
        }

        void addHeap(int val) {
            heap.add(val);
            int cPos = heap.size() - 1;
            int pPos = cPos / 2;
            while (cPos > 1 && heap.get(cPos) < heap.get(pPos)) { // 부모노드보다 자식노드가 작다면 교환
                int temp = heap.get(pPos);
                heap.set(pPos, heap.get(cPos));
                heap.set(cPos, temp);
                cPos = pPos;
                pPos = cPos / 2;
            }
        }

        int delHeap(){
            if(heap.size() - 1 < 1){
                return 0;
            }
            int delMin = heap.get(1);
            int size = heap.size() - 1;

            int pos = 1;
            heap.set(pos, heap.get(size));
            heap.remove(size);

            while(pos * 2 < size){
                int min = heap.get(pos * 2);
                int minPos = pos * 2;
                if(minPos + 1 < size){
                    if(heap.get(minPos) > heap.get(minPos + 1)) {
                        minPos += 1;
                        min = heap.get(minPos);
                    }
                }
                if(min > heap.get(pos)) break;
                int temp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, temp);
                pos = minPos;
            }

            return delMin;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        minHeap mh = new minHeap();

        for(int i = 0; i < N; ++i){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                sb.append(String.valueOf(mh.delHeap()) + "\n");
            } else {
                mh.addHeap(x);
            }
        }

        System.out.println(sb.delete(sb.length() - 1, sb.length()));
    }
}
