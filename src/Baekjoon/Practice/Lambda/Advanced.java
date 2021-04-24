package Baekjoon.Practice.Lambda;

import java.util.function.Consumer;

public class Advanced {
    //함수적 인터페이스 심화, 인터페이스 합치기
    //1. andThen()
    // - A.andThen(B) -> A와 B 인터페이스의 조합

    // - A실행 -> B실행.
    //2. compose()
    // - A.compose(B)
    // - B실행 -> A실행
    public static void main(String[] args) {
        Consumer<Mouse> c1 = m -> System.out.println(m.getName());
        Consumer<Mouse> c2 = m -> System.out.println(m.getPrice());

        Mouse m1 = new Mouse("TT-543 광마우스", 50000);

        //요구사항 -> m1의 이름과 가격을 출력하라
//        c1.accept(m1);
//        c2.accept(m1);

        // c3호출 -> c1호출 + c2호출;
        Consumer<Mouse> c3 = c1.andThen(c2);// c1 실행하고 c2실행하겠다.
        c3.accept(m1);

        Consumer<Mouse> c4 = c2.andThen(c1);
        c4.accept(m1);
    }

    static class Mouse implements Comparable {
        private String name;
        private int price;

        public Mouse() {
        }

        public Mouse(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return String.format("[이름 : %s]\n[가격 : %d]\n", this.name, this.price);
        }

        @Override
        public int compareTo(Object m) {

            if (m instanceof FunctionTest.Mouse) {
                Mouse m2 = (Mouse) m;
                if (this.name.equals(m2.getName()) && this.price == m2.price) {
                    return 1;
                }
            } else {
                return -1;
            }
            return 0;
        }
    }
}
