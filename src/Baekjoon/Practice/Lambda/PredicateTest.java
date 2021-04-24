package Baekjoon.Practice.Lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {
    // - 매개변수와 반환값이 있는 메소드를 제공한다.
    // - testXXX()
    // - 매개값을 사용해 조사(조건) 후 논리값을 반환한다.
    // - Function 서브 셋.
    public static void main(String[] args) {
        Predicate<Integer> p1 = n -> n > 0;
        System.out.println(p1.test(0) ? "양수" : "양수가 아니다.");
        Predicate<String> p2 = s -> s.length() > 10;
        System.out.println(p2.test("홍길동입니다.") ? "긴 문장" : "짧은 문장");
        Predicate<Student> p3 = s -> (s.getEng() + s.getKor() + s.getMath()) >= 240;
        System.out.println(p3.test(new Student("홍길동", 100, 80, 90)) ? "합격" : "불합격");

        //- 매개변수가 2개
        BiPredicate<String, String> p4 = (s1, s2) -> s1.length() > s2.length();
        System.out.println(p4.test("홍길동", "홍민"));

       //Predicate에만 있는 기능
        // - 자바의 논리연산자와 같은 역할.
        // 1. and()
        // 2. or()
        // 3. negate()
        // 4. isEquals()
        Predicate<Integer> p5 = n -> n % 2 == 0;
        Predicate<Integer> p6 = n -> n % 5 == 0;
        int num = 4;
        if (p5.test(num)) {
            System.out.println("2의 배수입니다.");
        } else if (p6.test(num)) {
            System.out.println("5의 배수입니다.");
        }
        Predicate<Integer> p7 = p1.and(p6);
        if (p7.test(num)) {
            System.out.println("2와 5의 공배수입니다.");
        }
    }

    static class Student {
        private String name;
        private int kor;
        private int eng;
        private int math;

        public Student() {

        }

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKor() {
            return kor;
        }

        public void setKor(int kor) {
            this.kor = kor;
        }

        public int getEng() {
            return eng;
        }

        public void setEng(int eng) {
            this.eng = eng;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            int score = this.getEng() + this.getKor() + this.getMath();
            return String.format("이름 : %s,총점 : %d\n", this.name, score);
        }

    }

}
