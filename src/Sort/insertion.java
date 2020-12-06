package Sort;

public class insertion {
    public static int[] arr = {8, 5, 6, 2, 4};


    public static void main(String[] args) {
        for(int i = 1; i < arr.length; ++i){
            int j;
            int key = arr[i]; // 삽입될 숫자인 i번째 정수를 key로 저장.
            // 현재 정렬된 배열은 i-1까지이므로 i-1번째부터 역순으로 조사한다.
            for(j = i - 1; j >= 0 && key < arr[j]; --j){
                // 정렬된 왼쪽(앞쪽) 요소가 Key값보다 크다면 j번째 요소를 j+1번째 위치로 옮긴다.
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }

        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }
}
