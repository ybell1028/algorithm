package Programmers.Kakao2021Intern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam3 {
    static class Solution {
        public String solution(int n, int k, String[] cmd) {
            //n = 행의 갯수
            //k = 커서
            //cmd = 커맨드
            boolean[] table = new boolean[n];
            Stack<Integer> stack = new Stack<>();
            Arrays.fill(table, true);
            StringTokenizer st;
            String command;
            int num;
            for(String c : cmd){
                st = new StringTokenizer(c);
                command = st.nextToken();
                if(c.length() > 1){
                    num = Integer.parseInt(st.nextToken());
                    if(command.equals("U")){
                        for(int i = 0; i < num; ++i) {
                            if(!table[--k]) i--;
                        }
                    } else { // "D"
                        for(int i = 0; i < num; ++i) {
                            if(!table[++k]) i--;
                        }
                    }
                } else {
                    if(command.equals("C")){
                        table[k] = false;
                        int b = back(table);
                        stack.push(k);
                        if(k == b){ // 여기가 문제, 이분 탐색을 맨 뒤에 있는 false 찾기?
                            //단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택
                            while(!table[k]) k--;
                        } else {
                            while(!table[k]) k++;
                        }
                    } else { // "Z"
                        table[stack.pop()] = true;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; ++i){
                if(table[i]) sb.append("O");
                else sb.append("X");
            }

            return sb.toString();
        }

        public int back(boolean[] table){
            int s = 0;
            int e = table.length - 1;
            int mid;
            while(s < e){
                mid = s + e / 2;
                if(table[mid]){
                    for(int i = mid; i < table.length - 1; --i){
                        if(table[i]) {
                            s = mid + 1;
                            break;
                        }
                    }
                } else {
                    e--;
                }
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(s.solution(8, 2, cmd1));
    }
}
