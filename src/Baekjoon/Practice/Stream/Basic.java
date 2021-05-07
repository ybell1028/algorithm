package Baekjoon.Practice.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basic {
    public static List<Number> staticList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    public static void main(String[] args) {
        //매핑 - 중간처리 기능으로 스트림의 요소를 다른 요소로 대체하는 작업을 한다.

        //flatXXX() : 요소를 대체하는 복수개의 요소들로 구성된 새로운 스트림을 리턴
        List<String> input1 = Arrays.asList("java8 lambda","stream mapping");
        input1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(System.out::println);

        List<Number> mine = Arrays.asList(2,4,6);
        System.out.println(isValid(mine));

        String[] A = { "서울", "대전", "대구", "부산" };
        String[] B = { "강원", "전주", "서울", "부산", "제주" };

        List<String> listA = Arrays.asList(A);
        List<String> listB = Arrays.asList(B);

        final List<String> union = new ArrayList<>(listA);
        System.out.println("union 1");
        print(union);
        listB.stream().filter(e -> !union.contains(e)).distinct().forEach(union::add);
        System.out.println("union 2");
        print(union);
        // filter안의 Predicate가 참인 것만 스트림에 추가됨
        //즉 리스트 A에 원소 중 리스트 B에 포함되어있는데 스트림에 추가됨
        final List<String> intersect = listA.stream().filter(listB::contains).distinct().collect(Collectors.toList());
        System.out.println("intersect");
        print(intersect);
        final List<String> difference = union.stream().filter(e -> !intersect.contains(e)).distinct().collect(Collectors.toList());
        System.out.println("difference");
        print(difference);

    }
    public static boolean isValid(List<Number> lists) {
        return staticList.stream()
                .anyMatch(lists::contains);
    }
    public static void print(List<String> list){
        list.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
