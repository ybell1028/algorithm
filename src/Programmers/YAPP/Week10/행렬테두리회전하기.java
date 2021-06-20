package Programmers.YAPP.Week10;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 행렬테두리회전하기 {
    static class Solution {
        static LinkedList<Integer> list = new LinkedList<>();
        static int[][] arr;
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            int aIdx = 0;
            arr = new int[rows + 1][columns + 1];
            for(int i = 1; i <= rows; ++i){
                for(int j = 1; j <= columns; ++j){
                    arr[i][j] = (i - 1) * columns + j;
                }
            }
            for(int[] q : queries){
                RC edge1 = new RC(q[0], q[1]);
                RC edge2 = new RC(q[2], q[3]);
                answer[aIdx++] = rotation(edge1, edge2);
            }
            return answer;
        }

        class RC {
            public int row;
            public int col;
            public RC(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        public static int rotation(RC edge1, RC edge2){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int row = edge1.row;
            int col = edge1.col;
            int temp;
            list.add(arr[row][col]);
            while(col < edge2.col){
                temp = arr[row][++col];
                pq.add(temp);
                arr[row][col] = list.poll();
                list.add(temp);
            }
            while(row < edge2.row){
                temp = arr[++row][col];
                pq.add(temp);
                arr[row][col] = list.poll();
                list.add(temp);
            }
            while(col > edge1.col){
                temp = arr[row][--col];
                pq.add(temp);
                arr[row][col] = list.poll();
                list.add(temp);
            }
            while(row > edge1.row){
                temp = arr[--row][col];
                pq.add(temp);
                arr[row][col] = list.poll();
                list.add(temp);
            }
            while(!list.isEmpty()) list.poll();
            return pq.poll();
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            int rows = 3;
            int columns = 3;
            int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2}, {2,2,3,3}};
            System.out.println(s.solution(rows, columns, queries));
        }
    }
}
