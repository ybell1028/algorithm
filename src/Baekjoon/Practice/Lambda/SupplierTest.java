package Baekjoon.Practice.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {
    // Supplier 매개변수 X , 반환값 O
    // - getXXX() 매ㅔ소드를 제공하는 함수형 인터페이스
    // - 데이터를 공급하는 역할.
    public static void main(String[] args) {
        //기본적인 사용법
        Supplier<Integer> s1 = () -> {
            return 100;
        };
        System.out.println(s1.get());

        Supplier<User> s3 = () -> new User("아무개", 30);
        User u = s3.get();
        System.out.println(u);

        Supplier<List<User>> s4 = () -> {
            List<User> list = new ArrayList<User>();
            list.add(new User("아무개", 20));
            list.add(new User("우성환", 25));
            list.add(new User("김김김", 23));
            return list;
        };

        for (User user : s4.get()) {
            System.out.println(user);
        }

        //어떤 타입을 반환타입으로 선언하여 return 하는 형태이므로 반환하는 형태를 정해놓고
        //짜임새 있게 사용하는 방법이 Supplier를 사용하는데 가장 중요한 의미라고 할 수 있다.
    }

    static class User {
        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s(%s)", this.name, this.age);
        }

    }
}
