package Programmers.YAPP.Week12;

import java.util.*;

import static java.lang.Math.sqrt;

public class 쿼드압축후개수세기 {
    static class RC {
        public int row;
        public int col;

        public RC(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Solution {
        static int len = 0;
        static Stack<int[][]> stack;
        static int[] answer = new int[2];

        public int[] solution(int[][] arr) {
            len = arr.length;
            stack = new Stack<>();
            stack.add(arr);
            compress(arr, 2);
            int cnt = 1;
            Queue<RC> queue = new LinkedList<>();
            queue.add(new RC(2, 2));
            while(!stack.isEmpty()){
                if(queue.isEmpty()){
                    answer[0] /= 4;
                    answer[1] /= 4;
                    break;
                }
                int[][] zip = stack.pop();
                int n = 0;
                while(cnt-- > 0){
                    RC rc = queue.poll();
                    for(int i = rc.row - 2; i < rc.row; ++i){
                        for(int j = rc.col - 2; j < rc.col; ++j){
                            if(zip[i][j] == 0) answer[0]++;
                            else if(zip[i][j] == 1) answer[1]++;
                            else queue.add(new RC(2 * i , 2 * j));
                        }
                    }
                }
                cnt = queue.size();
            }
            return answer;
        }

        public void compress(int[][] arr, int criteria){
            if(criteria == len) return;

            int div = len / criteria;

            int[][] compressArr = new int[div][div];

            for(int i = 0; i < div; ++i){
                for(int j = 0; j < div; ++j){
                    RC end = new RC(2 * (i + 1) , 2 * (j + 1)); // div가 1, 1이
                    compressArr[i][j] = compressible(arr, end);
                }
            }

            stack.push(compressArr);
            compress(compressArr, criteria * 2);
        }

        public int compressible(int[][] arr, RC end) {
            RC start = new RC(end.row - 2, end.col - 2);
            int key = arr[start.row][start.col];
            boolean possible = true;
            for(int i = start.row; i < start.row + 2; ++i){
                for(int j = start.col; j < start.col + 2; ++j){
                    if(arr[i][j] != key || arr[i][j] == -1) {
                        possible = false;
                        break;
                    }
                }
                if(!possible) break;
            }
            return possible ? key : -1;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1}};
        int[][] arr1 = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        int[][] arr2 = {{0, 0}, {0, 0}};
        int[][] arr3 = {{1}};
        Solution s = new Solution();
        int[] answer = s.solution(arr2);
        for(int a : answer){
            System.out.print(a + " ");
        }
    }
}
