package Baekjoon.Practice.Lambda;

import java.util.function.Function;

public class FunctionTest {
    //람다식을 저장하는 용도(내부적으로는 람다식으로 만들어진 메소드를 소유한 익명객체를 생성 + 저장)
    //값 -> Function -> 값 반환
    // - 값 apply(값)

    // - 매개변수와 반환값이 있는 메소드를 제공한다.
    // - applyXXX()메소드를 제공하는 함수형 인터페이스.
    // - 매개값을 반환값으로 매핑(변환)하는 역할.
    public static void main(String[] args) {
        Function<String, Integer> f1 = (txt) -> {
            // txt 매개변수는 String이고 Integer를 반환한다.
          return txt.length();
        };
        System.out.println(f1.apply("아힝흥행"));

        Function<Integer, String> f2 = num -> {
            return num > 0 ? "양수" : "음수";
        };
        System.out.println(f2.apply(-1));
        System.out.println(f2.apply(7));

        Function<Mouse, Integer> f3 = mouse -> (int) (mouse.getPrice() * 1.1);
        //매개변수 mouse는 Mouse 클래스형이고, 객체로 생성한 생성자의 매개값을 받아서
        // Price를 초기화한 값으로 1.1을 곱해서 반환하겠다.
        System.out.println(f3.apply(new Mouse("TTT-5455", 1250)));
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

            if (m instanceof Mouse) {
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
