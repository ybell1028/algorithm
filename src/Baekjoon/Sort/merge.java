package Sort;

public class merge {
    public static final int MAX_SIZE = 8;
    public static int[] sorted = new int[MAX_SIZE];

    public static void merge(int[] list, int left, int right, int mid){
        int first = left;
        int second = mid + 1;
        int sortedIdx = left; // 정렬된 배열을 조작하는 인덱스
        while(true){
            if(first > mid){ // 첫번째 부분 배열 인덱스가 mid(부분 경계)보다 커진다면
                // 나머지 두번째 부분배열에 있는 요소들을 sorted에 전부 복사
                for(int i = second; i <= right && sortedIdx < MAX_SIZE; ++i){
                    sorted[sortedIdx++] = list[i];
                }
                for(int i = left; i <= right; ++i){ // 정렬이 완료된 배열을 원래 배열에 복사
                    list[i] = sorted[i];
                }
                break;
            } else if (second > right){ // 두번째 부분 배열 인덱스가 right(배열 끝)보다 커진다면
                // 나머지 첫번째 부분 배열에 있는 요소들을 sorted에 전부 복사
                for(int i = first; i <= mid && sortedIdx < MAX_SIZE; ++i){
                    sorted[sortedIdx++] = list[i];
                }
                for(int i = left; i <= right; ++i){ // 정렬이 완료된 배열을 원래 배열에 복사
                    list[i] = sorted[i];
                }
                break;
            }

            if(list[first] < list[second]){
                // 첫번째 부분 배열의 요소를 sorted에 복사
                sorted[sortedIdx++] = list[first++];
            } else {
                // 두번째 부분 배열의 요소를 sorted에 복사
                sorted[sortedIdx++] = list[second++];
            }

        }
    }


    public static void merge_sort (int[] list, int left, int right){
        if(left == right){
            // left == right는 부분 배열 list의 크기가 1이라는 것을 뜻하므로 재귀 탈출.
            return;
        }
        int mid = (left + right) / 2;
        merge_sort(list, left, mid);
        merge_sort(list, mid + 1, right);
        merge(list, left, right, mid); // 분할이 끝난 배열을 합병하여 정렬
    }

    public static void main(String[] args) {
        int[] list = {20, 10, 12, 20, 25, 13, 15, 22};

        merge_sort(list, 0, list.length - 1);

        for(int i = 0; i < list.length; ++i){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
