package Sort;

import java.util.LinkedList;
import java.util.Queue;

public class radix {
    public static final int MAX_SCALE = 10;

    public static int extDigit(int num, int digit) { // 자릿수 추출
        if (0 >= num && 9 <= num) return num;
        else {
            if (digit <= 0) {
                return num % 10;
            } else {
                int div = 10;
                div = (int) Math.pow(div, digit + 1);
                num = num % div;
                div /= 10;
                return num / div;
            }
        }
    }

    public static void radixSort(int[] ary, int digit) {
        Queue<Integer> bucket[];
        bucket = new LinkedList[MAX_SCALE];

        for (int i = 0; i < MAX_SCALE; ++i) {
            bucket[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i <= digit; ++i) { // 자릿수
            for (int j = 0; j < ary.length; ++j) {
                int bucket_num = extDigit(ary[j], i);
                bucket[bucket_num].add(ary[j]);
            }
            int aIdx = 0;
            int bIdx = 0;
            while (aIdx < ary.length && bIdx < bucket.length) {
                if (!bucket[bIdx].isEmpty()) {
                    ary[aIdx++] = bucket[bIdx].poll();
                } else {
                    bIdx++;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] ary = {15, 27, 64, 25, 50, 17, 39, 28};
        String e = String.valueOf(ary[0]);

        int digit = e.length();

        radixSort(ary, digit);

        for(int i = 0; i < ary.length; ++i){
            System.out.println(ary[i]);
        }
    }
}
