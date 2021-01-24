package Sort;

import java.util.ArrayList;

public class heap {
    public static class maxHeap {
        ArrayList<Integer> heap;

        public maxHeap() {
            heap = new ArrayList<Integer>();
            heap.add(1000000); // 인덱스 1부터 시작하기 위함
        }

        public void insert(int val){
            heap.add(val);
            int p = heap.size() - 1;
            while(p > 1 && heap.get(p / 2) < heap.get(p)){
                //부모 노드가 자식 노드 보다 작을 경우 스왑
                int temp = heap.get(p / 2);
                heap.set(p / 2, heap.get(p));
                heap.set(p, temp);

                p /= 2;
            }
        }

        public int delete() {
            if(heap.size() - 1 < 1){
                return 0;
            }

            int deleteItem = heap.get(1); // 루트 노드에 있는 값을 가져옴

            heap.set(1, heap.get(heap.size() - 1)); // 마지막 노드에 있는 요소를 루트 노드로 이동
            heap.remove((heap.size() - 1)); // 마지막 노드 삭제

            int pos = 1;
            while((pos * 2) < heap.size()){
                int max = heap.get(pos * 2);
                int maxPos = pos * 2;

                if(((pos * 2 + 1) < heap.size()) && max < heap.get(pos * 2 + 1)){
                    //max와 heap.get(pos * 2 + 1)은 이웃한 노드
                    max = heap.get(pos * 2 + 1);
                    maxPos = pos * 2 + 1;
                } // 현재 노드의 자식 노드 중 더 큰 노드를 고름

                // 루트 노드로 올라갔던 마지막 노드가 더 큰 자식 노드보다 크다면 while문 중지
                if(heap.get(pos) > max) break;

                //루트 노드와 더 큰 자식 노드를 교환
                int temp = heap.get(pos);
                heap.set(pos, heap.get(maxPos));
                heap.set(maxPos, temp);
                pos = maxPos;
            }

            return deleteItem;
        }
    }

    public static void main(String[] args) {
        int[] ary = {5, 7, 3, 5, 4, 6, 9, 2, 1, 3};

        maxHeap mh = new maxHeap();

        for(int i = 0; i < ary.length; i++){
            mh.insert(ary[i]);
        }

        for(int i = 0; i < ary.length; i++){
            ary[i] = mh.delete();
            System.out.print(ary[i] + " ");
        }
    }
}
