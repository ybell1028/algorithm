package Baekjoon.Practice.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 가공하기 {
    public static void main(String[] args) {
        //Filtering
        List<String> names = Arrays.asList("Eric", "Elena", "Java");

        Stream<String> stream1 =
                names.stream()
                        .filter(name -> name.startsWith("E"));
        System.out.println("간단한 필터링");
        stream1.forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        //Mapping
        Stream<String> stream2 =
                names.stream()
                        .map(String::toUpperCase);
                /*names.stream()
                        .map(s -> s.toUpperCase());*/
        System.out.println("소문자 -> 대문자 매핑");
        stream2.forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        //다음처럼 요소 내 들어있는 Product 개체의 수량을 꺼내올 수도 있습니다.
        //각 ‘상품’을 ‘상품의 수량’으로 맵핑하는거죠.
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("트윅스", 10));
        productList.add(new Product("스니커즈", 20));
        productList.add(new Product("몰티저스", 30));
        Stream<Integer> stream3 =
                productList.stream()
                        .map(Product::getAmount);
        System.out.println("Product -> Product 객체의 Amount로 매핑");
        stream3.forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        //flatMap - 중첩 구조를 한 단계 제거하고 단일 컬렉션으로 만들어주는 역할
        List<List<String>> list =
                Arrays.asList(Arrays.asList("a"),
                        Arrays.asList("b"));
        // [[a], [b]]

        List<String> flatList =
                list.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
        // [a, b]
        
        //객체에 flatMap을 적용할 경우
        List<Student> students = new LinkedList<>();
        students.add(new Student("나연", 100, 100, 60));
        students.add(new Student("모모", 100, 80, 50));
        students.add(new Student("사나", 90, 70, 80));
        System.out.println("객체에 flatMap 적용");
        //학생 객체를 가진 스트림에서 학생의 국영수 점수를 뽑아 새로운 스트림을 만들어 평균을 구하는 코드입니다.
        // 이는 map 메소드 자체만으로는 한번에 할 수 없는 기능입니다.
        students.stream()
                .flatMapToInt(student -> // stream에 있는 Student 객체를 전부 플래트닝(구조를 제거하고 단일 컬렉션으로 만듬)
                        IntStream.of(student.getKor(),
                                student.getEng(),
                                student.getMath())) // 학생마다 점수로 IntStream 생성
                .average().ifPresent(avg -> // 평균내기
                System.out.println(Math.round(avg * 10)/10.0));
        System.out.println("\n");

        //Sorting
        List<Integer> integerList = IntStream.of(14, 11, 20, 39, 23)
                .sorted() //인자없이 그냥 호출할 경우 오름차순으로 정렬
                .boxed()
                .collect(Collectors.toList());
                // [11, 14, 20, 23, 39]
        System.out.println("기본적인 정렬");
        integerList.forEach(s -> System.out.print(s + " ")); // List.stream().forEach에서 => List.forEach로 변경
        System.out.println("\n");

        //스트링 리스트에서 알파벳 순으로 정렬한 코드와 Comparator 를 넘겨서 역순으로 정렬한 코드입니다.
        List<String> lang =
                Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

        lang.stream()
                .sorted()
                .collect(Collectors.toList())
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
        // [Go, Groovy, Java, Python, Scala, Swift]

        lang.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
        // [Swift, Scala, Python, Java, Groovy, Go]

        //두 인자를 비교해서 값을 리턴하는 compare 메소드를 사용한 정렬법
        //문자열 길이 별로 정렬
        lang.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList())
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
        // [Go, Java, Scala, Swift, Groovy, Python]

        lang.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .collect(Collectors.toList())
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
        // [Groovy, Python, Scala, Swift, Java, Go]

        int sum = IntStream.of(1, 3, 5, 7, 9)
                .peek(System.out::println)
                .sum();
        //sum = 1 + 3 + 5 + 7 + 9 = 25
        System.out.println(sum);
    }

    static class Product{
        String name;
        int amount;

        public Product(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }

    static class Student{
        String name;
        int kor;
        int eng;
        int math;

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
    }
}
