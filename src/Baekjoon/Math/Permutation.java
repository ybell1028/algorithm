import java.util.*;

public class Permutation {
    public static void main(String[] ar){
        Permutation ex = new Permutation();
        int[] arr = { 1, 2, 3, 4, 5 };
        ex.doPermutation(arr, 0);
    }

    public void doPermutation(int[] arr, int startIdx){
        int length = arr.length;
        if(startIdx == length-1){
            for(int n: arr) System.out.print(n + " ");
            System.out.println();
            return;
        }

        for(int i=startIdx; i<length; i++){
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx+1);
            swap(arr, startIdx, i);
        }


        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        //permu와 짝
        for(int i =0; i < list.size(); ++i){
            Collections.sort(list);
            String current = list.remove(i);
            permu(set, list, current);
            list.add(current);
        }
    }

    public void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public static void permu(Set<Integer> set, List<String> all, String current){
        //set - 조합의 결과를 담는 Set
        //all - 현재 턴에서 남은 요소들
        //current - 현재 진행된 요소의 조합

        //다음거 추가하지 않는 경우
        set.add(Integer.parseInt(current));
        if(all.size() == 0) return;;

        //다음 거 추가하는 경우
        for(int i = 0; i < all.size(); ++i){
            String next = all.remove(0);
            permu(set, all, current + next);
            all.add(next);
        }

    }
}