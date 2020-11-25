import java.util.*;

public class Combination {
    public static void main(String[] args) {
        Combination ex = new Combination();
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int r = 2;
        int[] combArr = new int[n];

        ex.doCombination(combArr, n, r, 0, 0, arr);
    }

    public void doCombination(int[] combArr, int n, int r, int idx, int target, int[] arr){
        if(r == 0){ // r개를 다 뽑았을때 출력
            for(int i = 0; i < idx; i++)
                System.out.print(arr[combArr[i]] + " ");
            System.out.println();
        } else if(target == n) return; // r개를 다 못뽑고 arr의 모든 원소를 검사했을때 1
        else{
            combArr[idx] = target; // 2
            doCombination(combArr, n, r-1, idx+1, target+1, arr); //(i) 뽑는 경우 3
            doCombination(combArr, n, r, idx, target+1, arr); //(ii) 안뽑는 경우 4
        }
    }
}
