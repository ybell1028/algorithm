package Baekjoon.Practice.Stream;

import java.util.*;
import java.util.stream.*;

public class 결과만들기 {
    public static void main(String[] args) {
        //Calculating - 최소, 최대, 합, 평균 등 기본형 타입으로 결과를 만들어낼 수 있습니다.
        //만약 스트림이 비어있는 경우 count와 sum은 0을 출력하면 됩니다.
        long count = IntStream.of(1, 3, 5, 7, 9).count();
        long sum = LongStream.of(1, 3, 5, 7, 9).sum();
        System.out.println("count, sum");
        System.out.println(count + " " + sum);
        System.out.println();

        //하지만 평균, 최소, 최대의 경우에는 표현할 수가 없기 때문에 Optional을 이용해 리턴합니다.
        OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
        OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
        System.out.println("min, max");
        System.out.println(min.getAsInt() + " " + max.getAsInt());
        System.out.println();

        //Reduction - 스트림은 reduce라는 메소드를 이용해서 결과를 만들어냅니다. 스트림에 있는 여러 요소의 총합을 낼 수도 있습니다.
        //다음은 reduce 메소드가 받는 세가지의 파라미터 입니다.
        //- **accumulator** : 각 요소를 처리하는 계산 로직. 각 요소가 올 때마다 중간 결과를 생성하는 로직.
        //- **identity** : 계산을 위한 초기값으로 스트림이 비어서 계산할 내용이 없더라도 이 값은 리턴.
        //- **combiner** : 병렬(*parallel*) 스트림에서 나눠 계산한 결과를 하나로 합치는 동작하는 로직.

        //인자를 한 개 받는 경우
        //다음 예제에서는 두 값을 더하는 람다를 넘겨주고 있습니다.
        OptionalInt reduced =
                IntStream.range(1, 4) // [1, 2, 3]
                        .reduce((a, b) -> Integer.sum(a, b));

        /*OptionalInt reduced =
                IntStream.range(1, 4) // [1, 2, 3]
                        .reduce(Integer::sum);

        OptionalInt reduced =
                IntStream.range(1, 4) // [1, 2, 3]
                        .reduce((a, b) -> {
                            return Integer.sum(a, b);
                        });*/

        System.out.println("reduce 1 param");
        System.out.println(reduced.getAsInt());
        System.out.println();

        //인자를 두 개 받는 경우
        int reducedTwoParams = // identity (기본값)이 있기때문에 Optional 필요 없음
                IntStream.range(1, 4) // [1, 2, 3]
                        .reduce(10, Integer::sum); // method reference

        System.out.println("reduce 2 param");
        System.out.println(reducedTwoParams);
        System.out.println();

        //인자를 세 개 받는 경우
        //Combiner는 병렬처리 시 각자 다른 쓰레드에서 실행한 결과를 마지막에 합치는 단계입니다. 따라서 병렬 스트림에서만 동작합니다.

        //단일 스트림 - 마지막 인자 combiner 실행 안됨
        Integer reducedParams = Stream.of(1, 2, 3)
                .reduce(10, // identity
                        Integer::sum, // accumulator까지만 실행
                        (a, b) -> { // 실행 안됨
                            System.out.println("combiner was called");
                            return a + b;
                        });
        System.out.println("reduce 3 param sequence");
        System.out.println(reducedParams);
        System.out.println();

        //결과는 다음과 같이 36이 나옵니다. 먼저 accumulator는 총 세번 동작합니다.
        //초기값 10에 각 스트림 값을 더한 세 개의 값(10 + 1 = 11, 10 + 2 = 12, 10 + 3 = 13)을 계산합니다.
        //
        //`Combiner`는 `identity`와 `accumulator`를 가지고 여러 쓰레드에서 나눠 계산한 결과를 합치는 역할입니다.
        // 12 + 13 = 25, 25 + 11 = 36 이렇게 두 번 호출됩니다.
        Integer parallelreducedParams = Stream.of(1, 2, 3)
                .parallel()
                .reduce(10,
                        Integer::sum,
                        (a, b) -> {
                            System.out.println("combiner was called");
                            return a + b;
                        }
                );
        System.out.println("reduce 3 param parallel");
        System.out.println(parallelreducedParams);
        System.out.println();

        //Collecting
        //Collector 타입의 인자를 받아서 처리를 하는데요. 자주 사용하는 작업은 Collectors 객체에서 제공하고 있습니다.
        List<Product> productList =
                Arrays.asList(new Product(23, "potatoes"),
                        new Product(14, "orange"),
                        new Product(13, "lemon"),
                        new Product(23, "bread"),
                        new Product(13, "sugar"));

        //Collectors.toList()
        //스트림에서 작업한 결과를 담은 리스트로 반환합니다. 다음 예제에서는 map으로 각 요소의 이름을 가져온 후 Collectors.toList를 이용해서 리스트로 결과를 가져옵니다.
        List<String> collectorCollection =
                productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println("Collectors.toList()");
        collectorCollection.forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println();

        //Collectors.joining()
        //스트림에서 작업한 결과를 하나의 스트링으로 이어 붙일 수 있습니다.
        String listToString1 =
                productList
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.joining());
        System.out.println("Collectors.joining()");
        System.out.println(listToString1);
        System.out.println();

        //Collectors.joining은 세 개의 인자를 받을 수 있습니다. 이를 이용하면 간단하게 스트링을 조합할 수 있습니다.
        //delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자
        //prefix : 결과 맨 앞에 붙는 문자
        //suffix : 결과 맨 뒤에 붙는 문자
        String listToString2 =
                productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", ", "<", ">"));
        System.out.println("Collectors.joining() delimeter prefix suffix");
        System.out.println(listToString2);
        System.out.println();

        //Collectors.averagingInt()
        //숫자 값의 평균을 냅니다.
        Double averageAmount =
                productList.stream()
                .collect(Collectors.averagingInt(a -> a.getAmount()));
        /*Double averageAmount =
                productList.stream()
                        .collect(Collectors.averagingInt(Product::getAmount));*/
        System.out.println("Collectors.averagingInt()");
        System.out.println(averageAmount);
        System.out.println();

        //그 외에도 summingInt, byMin, byMax, counting 등이 있다.
        Integer sumAmount =
                productList.stream()
                .collect(Collectors.summingInt(Product::getAmount));
        System.out.println("Collectors.summingInt()");
        System.out.println(sumAmount);
        System.out.println();

        //Collectors.summarizingInt()
        //만약 합계와 평균 모두 필요하다면 스트림을 두번 생성해야 할까요?
        //이런 정보를 한번에 얻을 수 있는 방법으로는 `summarizingInt` 메소드가 있습니다.
        //- 개수 getCount()
        //- 합계 getSum()
        //- 평균 getAverage()
        //- 최소 getMin()
        //- 최대 getMax()
        IntSummaryStatistics statistics =
                productList.stream()
                .collect(Collectors.summarizingInt(Product::getAmount));
        System.out.println("Collectors.summarizingInt()");
        System.out.println(statistics);
        System.out.println();

        //Collectors.groupingBy() - 특정 조건으로 요소들을 그룹지을 수 있습니다.
        //수량을 기준으로 그룹핑해보겠습니다. 여기서 받는 인자는 함수형 인터페이스 Function입니다.
        Map<Integer, List<Product>> collectorMapOfLists =
                productList.stream()
                .collect(Collectors.groupingBy(a -> a.getAmount()));
        System.out.println("Collectors.groupingBy()");
        System.out.println(collectorMapOfLists);
        System.out.println();

        //Collectors.partitioningBy()
        //위의 groupingBy 함수형 인터페이스 Function을 이용해서 특정 값을 기준으로 스트림 내 요소들을 묶었다면, partitioningBy는 함수형 인터페이스 Predicate를 받습니다.
        Map<Boolean, List<Product>> mapPartitioned =
                productList.stream()
                .collect(Collectors.partitioningBy(a -> a.getAmount() > 15));
        System.out.println("Collectors.partitioningBy()");
        System.out.println(mapPartitioned);
        System.out.println();

        //Collectors.collectingAndThen()
        //특정 타입으로 결과를 collect 한 이후에 추가 작업이 필요한 경우 사용할 수 있습니다.
        //finisher가 추가된 모양인데, 이 피니셔는 collect를 한 후에 실행할 작업을 의미합니다
        // 다음 예제는 Collectors.toSet을 이용해서 결과를 Set으로 collect한 후 수정 불가한 Set으로 변환하는 작업을 추가로 실행하는 코드입니다.
        Set<Product> unmodifiableSet =
                productList.stream()
                        .collect(Collectors.collectingAndThen(Collectors.toSet(),
                                Collections::unmodifiableSet));

        //Collector.of()
        //필요한 로직이 있다면 직접 collector를 만들 수도 있습니다. accumulator와 combiner는 reduce에서 살펴본 내용과 동일합니다.

        //다음 코드에서는 collector를 하나 생성합니다.
        //컬렉터는 생성하는 supplier에 LinkedList의 생성자를 넘겨줍니다.
        //그리고 accumulator에는 리스트에 추가하는 `add` 메소드를 넘겨주고 있습니다.
        //따라서 이 컬렉터는 스트림의 각 요소에 대해서 LinkedList를 만들고 요소를 추가하게 됩니다.
        //마지막으로 combiner를 이용해 결과를 조합하는데, 생성된 리스트들을 하나의 리스트로 합치고 있습니다.
        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new,
                        LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });
        //따라서 다음과 같이 collect 메소드에 우리가 만든 커스텀 컬렉터를 넘겨줄 수 있고, 결과가 담긴 LinkedList가 반환됩니다.
        LinkedList<Product> linkedListofPersons =
                productList.stream()
                .collect(toLinkedList);
        System.out.println("Collector.of()");
        linkedListofPersons.forEach(a -> {
            System.out.print(a.getName() + " ");
        });
        System.out.println();
        System.out.println();

        //Matching
        //따라서 이 컬렉터는 스트림의 각 요소에 대해서 LinkedList를 만들고 요소를 추가하게 됩니다. 다음과 같은 세가지 메소드를 제공합니다.
        //하나라도 조건을 만족하는 요소가 있는지 (anyMatch)
        //모두 조건을 만족하는지 (allMatch)
        //모두 조건을 만족하지 않는지 (noneMatch)
        List<String> names = Arrays.asList("Eric", "Elena", "Java");

        boolean anyMatch = names.stream()
                .anyMatch(name -> name.contains("a"));
        boolean allMatch = names.stream()
                .allMatch(name -> name.length() > 3);
        boolean noneMatch = names.stream()
                .noneMatch(name -> name.endsWith("s"));
        System.out.println("Matching");
        System.out.println(anyMatch + " " + allMatch + " " + noneMatch);
    }

    static class Product{
        String name;
        int amount;

        public Product(int amount, String name) {
            this.amount = amount;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
