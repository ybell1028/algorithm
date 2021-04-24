package Baekjoon.Practice.Lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {
    // 출처 : https://sas-study.tistory.com/106?category=769494
    // Consumer : 매개변수O, 반환값X -> 추상메소드 제공.
    // - accept() 메소드를 제공하는 함수형 인터페이스
    // - 매개변수를 받아서 소비하는 일을 구현하는 역할.
    // - 다양한 오버로딩 지원.
    public static void main(String[] args) {
        Consumer<Integer> c1 = a -> { System.out.println(a); };
        c1.accept(10);

        BiConsumer<Integer, Integer> c2 = (a, b) -> { System.out.println(a + b); };
        c2.accept(10, 20);

        //Consumer 심화 예제
        //Consumer는 MyNumber 객체를 매개변수로 갖는 accept(MyNumber num) 형태로 선언하고
        //그 accept 메소드 내부구현은 에로우 다음에나오는 System.out.println(num.getNum()); 부분입니다.
        Consumer<MyNumber> c4 = num -> System.out.println(num.getNum());
        //즉, accept() 안에다가 MyNumber 를 구현한 객체든 익명객체든 넣어줘야 한다.
        c4.accept(new MyNumber() {  // A
            @Override
            public int getNum() {
                return 100;
            }
        });

        c4.accept(() -> {  //B
            return 200;
        });
        //A부분은 기존 익명객체를 만드는 방법으로 getNum 메소드를 구현한 익명객체를 넣어주었고, B부분은 람다식을 이용해 익명객체를 만들어 대입하였다.
        //그 객체들의 getNum 메소드는 각각 100과 200을 리턴하게 되므로 순차적으로 100을 출력하고 200을 출력하는 결과를 보이게 된다.
    }
}
