package Baekjoon.Practice.Stream;

import java.util.Arrays;
import java.util.List;

public class 메소드참조표현식 {
    public String addNim(String s) {
        return s + "님";
    }

    public static void main(String[] args) {
        //이중 콜론(::) - 정식 명칭은 메소드 참조 표현식으로, 람다식에서 파라미터를 중복해서 쓰기 싫을 때 사용합니다.
        //사용 방법 [인스턴스]::[메소드 또는 new]

        List<String> names = Arrays.asList("김갑순", "김갑돌");

        //ex1) 리스트를 순회하면서 println을 하고자 할 때

        // x를 건네고 받는 과정에서 x를 두 번 적게 된다.
        // 아예 x들을 빼버리고 아래와 같이 작성할 수 있다.
        names.forEach(x -> System.out.println(x));
        names.forEach(System.out::println);
        /*여기서는 System.out이 인스턴스 부분이며, 그 인스턴스의 메소드 중 하나인 println이 메소드명으로 사용되었습니다.
          참고로 System.out은 PrintStream 인스턴스를 반환합니다.*/


        //ex2) Stream의 map()을 사용해 새로운 스트림을 생성하고자 할 때
        메소드참조표현식 dct = new 메소드참조표현식();
        names.stream().map(x -> dct.addNim(x)).forEach(System.out::println); // 적용 전
        //x -> dct.addNim(x)을 dct:addNim로 바꿀 수 있습니다.
        names.stream().map(dct::addNim).forEach(System.out::println); // 적용 후
        //만약 addNim()이 스태틱 메소드인 경우 다음과 같이 사용 가능합니다.
        //names.stream().map(메소드참조표현식::addNim).forEach(System.out::println);

        //ex3) 생성자가 파라미터 한 개로 이루어진 DTO의 배열을 생성하고자 할 때
    }
}
