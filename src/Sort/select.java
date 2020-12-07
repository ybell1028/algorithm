package Sort;

public class select {
    public static int[] arr = {9, 6, 7, 3, 5};

    public static void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        for(int i = 0; i < arr.length - 1; ++i){
            int min = arr[i];
            int mIdx = i;
            for(int j = i; j < arr.length; ++j){
                if(arr[j] < min) {
                    min = arr[j];
                    mIdx = j;
                }
            }
            swap(i, mIdx);
        }

        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }
}
