package Baekjoon.Backtracking;

public class Combination {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1, 2, 3, 4, 5 ,6};
        boolean[] visited = new boolean[n];

        combi_recursive(arr, visited, 0, 6, 3);
    }

    // 백트래킹 사용
    static void combi_backtracking(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            print_back(arr, visited);
        } else {
            for(int i = start; i < n; ++i){ // i = start가 핵심
                visited[i] = true;
                combi_backtracking(arr, visited, i + 1, n, r - 1); // start에 i + 1을 넣는게 핵심
                visited[i] = false;
            }
        }
    }

    static void combi_recursive(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            print_re(arr, visited, n);
            return;
        }

        if(depth == n){
            return;
        }

        visited[depth] = true;
        combi_recursive(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combi_recursive(arr, visited, depth + 1, n, r);
    }

    static void print_back(int[] arr, boolean[] visited){
        for(int i = 0; i < arr.length; ++i){
            if(visited[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void print_re(int[] arr, boolean[] visited, int n){
        for(int i = 0; i < n; ++i){
            if(visited[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
