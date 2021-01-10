package Sort;

public class quick {
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void quickSort(int[] list, int left, int right){
        if(left < right){
            int q = partition(list, left, right);


            // q는 자리를 찾은 피벗의 인덱스
            // 이를 기준으로 부분 리스트를 만들어(정확히는 범위를 정하여) 분할 정복을 반복.
            quickSort(list, left, q - 1);
            quickSort(list, q + 1, right);
        }
    }

    public static int partition(int[] list, int left, int right){
        //피벗을 중심으로 하여 부분 리스트로 나누는 함수
        int pivot = list[left];
        int low = left + 1;
        int high = right;

        while(true){
            while(low <= right && list[low] < pivot){
                //low가 right(부분함수의 끝)보다 커지거나
                low++;
            }

            while(high >= left && list[high] > pivot){
                //row가 left(부분함수의 앞)보다 작아지면 outofindex 에러 발생
                high--;
            }
            if(low > high) break; // low와 high가 엇갈리면 루프 탈출
            else swap(list, low, high); // 그렇지 않으면 요소를 교환
        }

        swap(list, left, high); // 피벗 값과 high 인덱스 값을 교환하여 피벗의 자리를 찾아줌.

        return high; // 현재 피벗의 인덱스를 반환
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 9, 1, 6, 2, 7};

        quickSort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
