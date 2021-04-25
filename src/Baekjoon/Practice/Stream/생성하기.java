package Baekjoon.Practice.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class 생성하기 {
    public static void main(String[] args) {
        //배열 스트림
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arr);
        Stream<String> streamOfArrayPart =
                Arrays.stream(arr, 1, 3); // 1~2 요소 [b, c]
        System.out.println("배열 스트림");
        stream1.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //컬렉션 스트림
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream2 = list.stream();
        System.out.println("컬렉션 스트림");
        stream2.forEach(s -> System.out.print(s + " "));
        System.out.println();
//        stream1.forEach(System.out::println);

        //비어 있는 스트림
        Stream<Integer> emptyStream = Stream.empty();
        System.out.println("비어 있는 스트림");
        emptyStream.forEach(s -> System.out.println());
        System.out.println();

        //빌더(Builder)를 사용하면 스트림에 직접적으로 원하는 값을 넣을 수 있습니다.
        Stream<String> builderStream =
                Stream.<String>builder()
                        .add("Eric")
                        .add("Elena")
                        .add("Java")
                        .build(); // [Eric, Elena, Java]
        System.out.println("Stream.Builder()");
        builderStream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //generate 메소드를 이용하면 Supplier<T> 에 해당하는 람다로 값을 넣을 수 있습니다.
        // Supplier<T> 는 인자는 없고 리턴값만 있는 함수형 인터페이스죠. 람다에서 리턴하는 값이 들어갑니다.
        Stream<String> generatedStream =
                Stream.generate(() -> "gen").limit(5);
        System.out.println("Stream.generate()");
        generatedStream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //iterate 메소드를 이용하면 초기값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만듭니다.
        //이 방법도 스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야 합니다.
        Stream<Integer> iteratedStream =
                Stream.iterate(30, n -> n + 2).limit(5); // [30, 32, 34, 36, 38]
        System.out.println("Stream.iterate()");
        iteratedStream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //기본 타입형 스트림
        //제네릭을 사용하지 않고 직접적으로 해당 타입의 스트림을 다룰 수도 있습니다.
        // range 와 rangeClosed 는 범위의 차이입니다. 두 번째 인자인 종료지점이 포함되느냐 안되느냐의 차이입니다.
        IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
        LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
        System.out.println("기본 타입형 스트림");
        intStream.forEach(s -> System.out.print(s + " "));
        System.out.println();
        longStream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //Java 8 의 Random 클래스는 난수를 가지고 세 가지 타입의 스트림(IntStream, LongStream, DoubleStream)을 만들어낼 수 있습니다.
        DoubleStream doubleStream = new Random().doubles(3);
        System.out.println("Random 클래스로 스트림 생성");
        doubleStream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        //문자열 스트링
        IntStream charsStream = "Stream".chars();
        System.out.println("문자열 스트링으로 스트림 생성");
        "Stream".chars().forEach(s -> System.out.print(s + " "));
        System.out.println();

        //정규 표현식 이용
        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
        System.out.println("정규 표현식 이용");
        stringStream.forEach(s -> System.out.print(s + " "));
        System.out.println();

        List<Product> productList = Arrays.asList(new Product[]{new Product(1), new Product(2), new Product(3)});
        // 병렬 스트림 생성
        Stream<Product> parallelStream = productList.parallelStream();
        // 병렬 여부 확인
        boolean isParallel = parallelStream.isParallel();


        //스트림 연결하기
        Stream<String> stream3 = Stream.of("Java", "Scala", "Groovy");
        Stream<String> stream4 = Stream.of("Python", "Go", "Swift");
        Stream<String> concat = Stream.concat(stream3, stream4);
        System.out.println("스트림 연결하기");
        concat.forEach(s -> System.out.print(s + " "));
        System.out.println();
        // [Java, Scala, Groovy, Python, Go, Swift]
    }

    static class Product{
        int pro;

        Product(){
        }

        public Product(int pro) {
            this.pro = pro;
        }
    }
}
