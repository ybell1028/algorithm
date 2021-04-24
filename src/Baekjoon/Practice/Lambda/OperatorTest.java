package Baekjoon.Practice.Lambda;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;

public class OperatorTest {
    // - 매개변수와 반환값이 있는 메소드를 제공한다.
    // - applyXXX()
    // - Function의 하위 호환 인터페이스(서브셋)
    // - 주로 매개값을 연산(***)을 통해 결과값을 만들어 내고 그 값을 반환.
    // - Function과 큰 차이는 Operator는 매개값과 반환값의 타입이 동일하다.(연산자들의 특징)
    public static void main(String[] args) {
        BinaryOperator<Integer> b1 = (n1,n2) -> n1+n2;
        System.out.println(b1.apply(3, 5));

        BinaryOperator<String> b2 = (firstName, lastName) -> lastName+"가 "+firstName;
        System.out.println(b2.apply("길동", "홍"));
    }
}
