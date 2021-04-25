package Baekjoon.Practice.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basic {
    public static void main(String[] args) {
        //매핑 - 중간처리 기능으로 스트림의 요소를 다른 요소로 대체하는 작업을 한다.

        //flatXXX() : 요소를 대체하는 복수개의 요소들로 구성된 새로운 스트림을 리턴
        List<String> input1 = Arrays.asList("java8 lambda","stream mapping");
        input1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(System.out::println);
    }
}
