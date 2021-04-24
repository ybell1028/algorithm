package Baekjoon.Practice.Lambda;

public class Basic {
    public static void main(String[] args) {
        TestInterface t2 = new TestInterface() {
            @Override
            public int plusAandB(int a, int b) {
                return a + b;
            }
        };

        TestInterface t3 = (a , b) -> a + b;
        TestInterface t4 = (a , b) -> { return (a + b); };
        System.out.println(t4.plusAandB(1, 2));
    }
}
