package Baekjoon.Practice.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basic {
    public static void main(String[] args) {

        //Iterable
        List<Double> temperature = new ArrayList<Double>(Arrays.asList(new Double[] { 20.0, 22.0, 22.5 }));
        temperature.forEach(s -> System.out.println(s)); // 같음
//        temperature.forEach(System.out::println); // 같음

        //Collection
        //removeIf(Predicate<? super E> filter - 필터 조건에 일치하는 인자를 삭제합니다.
        List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        list.removeIf(integer -> integer % 2 == 0);
        System.out.println(list);
    }
}
