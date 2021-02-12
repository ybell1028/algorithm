package Sort;

public class bubble {
    public static int[] arr = {7, 4, 5, 1, 3};

    public static void swap(int aIdx, int bIdx){
        int temp = arr[aIdx];
        arr[aIdx] = arr[bIdx];
        arr[bIdx] = temp;
    }

    public static void main(String[] args) {
        for(int i = 1; i < arr.length - 1; ++i){
            int limit = arr.length - i; // 인접한 레코드끼리 비교하는 경계
            /* i = 1 일때, j = 5 - 1 = 4, j + 1 = 5
               i = 2 일때, j = 5 - 2 = 3, j + 1 = 4
               ...
             */
            for(int j = 0; j < limit; ++j){
                // 앞에 있는 자료의 값이 뒤의 자료보다 크다면 교환
                if(arr[j] > arr[j+1]) swap(j, j+1);
            }
        }

        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }
}
