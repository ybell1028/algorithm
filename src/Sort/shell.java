package Sort;

public class shell {

    public static void shellSort(int[] arr, int n){
        for(int gap = n / 2; gap > 0; gap /= 2){
            if(gap % 2 == 0) gap++; // gap을 홀수로 만든다.

            for(int i = 0; i < gap; ++i){
                insertionSort(arr, i, gap);
            }
        }
    }

    public static void insertionSort(int[] arr, int start, int gap){
        int j, key;

        for(int i = start + gap; i <= arr.length - 1; i += gap){
            key = arr[i]; // 삽입 정렬이 두번째 요소에서 시작하듯, 쉘 정렬의 부분 리스트 삽입 정렬도 start + gap부터 시작

            // 현재 정렬된 배열은 i-gap 까지 이므로 i-gap번째 부터 역순으로 조사한다
            // j 값은 first 이상이어야 하고
            // key 값보다 정렬된 배열에 있는 값이 크면 (arr[j] > key)
            // j번째를 j+gap번째로 이동
            for(j = i - gap; j >= start && arr[j] > key; j -= gap){
                arr[j + gap] = arr[j];
            }
            arr[j + gap] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 6, 20, 4, 3, 22, 1, 0, 15, 16};

        shellSort(arr, arr.length);

        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }
}
