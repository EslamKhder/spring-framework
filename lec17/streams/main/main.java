package main;


import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class main {

    /*
    public static int sum(int a, int b, Predicate<Integer> p) {
        return a + b;
    }//16502682
    sum(2,3, x -> x + x == 1);
    */

    public static void main(String[] args) {


        List<Student> students = List.of(
                new Student(10, 40),
                new Student(1, 2),
                new Student(4, 3),
                new Student(4, 44),
                new Student(10, 55)
        );

        System.out.println(
                students.stream().collect(Collectors.groupingBy(Student::getX, Collectors.counting()))
        );
        Map<Integer, Optional<Student>> students1 = students.stream()
                .collect(Collectors.groupingBy(Student::getX, Collectors.maxBy(
                        Comparator.comparing(Student::getX)
                )));
        /*

//groupingBy with max by
List<Student> students = List.of(
                new Student(10, 40),
                new Student(1, 2),
                new Student(4, 3),
                new Student(4, 44),
                new Student(10, 55)
        );

        System.out.println(
                students.stream().collect(Collectors.groupingBy(Student::getX, Collectors.counting()))
        );
        Map<Integer, Optional<Student>> students1 = students.stream()
                .collect(Collectors.groupingBy(Student::getX, Collectors.maxBy(
                        Comparator.comparing(Student::getX)
                )));
// groupingBy with counting
List<Student> students = List.of(
                new Student(10, 40),
                new Student(1, 2),
                new Student(4, 3),
                new Student(4, 44),
                new Student(10, 55)
        );

        System.out.println(
                students.stream().collect(Collectors.groupingBy(Student::getX, Collectors.counting()))
        );
        Map<Integer, Long> students1 = students.stream()
                .collect(Collectors.groupingBy(Student::getX, Collectors.counting()));

        // Collectors.groupingBy
        System.out.println(
        students.stream().collect(Collectors.groupingBy(Student::getX))
        );
        Map<Integer, List<Student>> students1 = students.stream()
        .collect(Collectors.groupingBy(Student::getX));

        // mapToInt with boxed
        List<Student> students = List.of(
                new Student(10, 40),
                new Student(1, 2),
                new Student(4, 3)
        );

        List<Integer> integers = students.stream()
                .mapToInt(Student::getX)  // Produces an IntStream
                .boxed()                  // Converts IntStream to Stream<Integer>
                .collect(Collectors.toList());

        System.out.println();

        // max
        List<Student> students = List.of(
                new Student(10, 40),
                new Student(1, 2),
                new Student(4, 3)
        );

        System.out.println(
                students.stream()
                        .max(Comparator.comparing(Student::getX))
        );

        // dropWhile
        List<Student> students = List.of(
                new Student(10, 40),
                new Student(1, 2),
                new Student(4, 3)
        );

        System.out.println(
                students.stream()
                        .dropWhile(o -> o.getX() >= 3)
                        .collect(Collectors.toList())
        );
        // takeWhile
        List<Student> students = List.of(
                new Student(10, 40),
                new Student(1, 2),
                new Student(4, 3)
        );

        System.out.println(
                students.stream()
                        .takeWhile(o -> o.getX() >= 3)
                        .collect(Collectors.toList())
        );
// limit and skip
System.out.println(
                students.stream()
                        .limit(5)
                        .collect(Collectors.toList())
        );

        System.out.println(
                students.stream()
                        .skip(2)
                        .collect(Collectors.toList())
        );
// sorted with comparing
    List<Student> students = List.of(
                new Student(1, 2),
                new Student(3, 4)
        );

        System.out.println(
                students.stream()
                .sorted(Comparator.comparing(Student::getX).reversed())
                .collect(Collectors.toList())
        );

        System.out.println(
                students.stream()
                        .sorted(Comparator.comparingInt(Student::getX).thenComparing(Student::getY))
                        .collect(Collectors.toList())
        );


         //example  input    input     output any thing not return such sout
        BiConsumer<Integer, Integer> println = (x, y) -> System.out.println(x + "  " + y);
        println.accept(5,10);

        //example  input    input     output
        BiFunction<Integer, Integer, Boolean> integerStringBiPredicate = (x,y)-> x==y;

        //example     input   input        output       result must be boolean
        BiPredicate<Integer, Integer> integerStringBiPredicate = (x,y)-> x==y;

        // example input and output same datatype
        UnaryOperator<Integer> integerUnaryOperator = x -> x * 3;
        System.out.println(integerUnaryOperator.apply(10));

        // example  (no input return Supplier)
        Supplier<Integer> supplier = ()-> 2;

        List<Integer> numbersV1 = Arrays.asList(5,4,3);

        BinaryOperator binaryOperator = new BinaryOperator() {
            @Override
            public Object apply(Object o, Object o2) {
                return (Integer)o + (Integer)o2;
            }
        };

        System.out.println(numbersV1.stream().filter().reduce(binaryOperator).get());
//        System.out.println(numbersV1.stream().reduce((integer, integer2) -> integer + integer2));

        // example ---------------------------------------------------------------
        List<Integer> numbersV1 = Arrays.asList(1001);

        System.out.println(numbersV1.stream().reduce(1000, Integer::compareTo));


        // example ---------------------------------------------------------------
        List<Integer> numbers = Arrays.asList(10, 22, 33,34, 53);

        // predicate , function , consumer

        // Integer as input.
        Predicate<Integer> integerPredicate = x -> x % 2 == 0;

        // Integer for input
        // Integer for output
        Function<Integer, Integer> integerIntegerFunction = z -> z * z;

        //Integer as input.
        Consumer<Integer> println = System.out::println;

        numbers.stream().
                filter(integerPredicate).
                map(integerIntegerFunction).
                forEach(println);


        // example ---------------------------------------------------------------
        int count = numbers.stream()
                // Identity Value     Accumulator Function:
                .reduce(0, (a, b) -> a + 1);

        System.out.println("Count: " + count);*/

    }

    /**
     * private static Consumer<Integer> getPrintln() {
     *         return System.out::println;
     *     }
     */
    /*
    private static Function<Integer, Integer> getIntegerIntegerFunction() {
        return z -> z * z;
    }
     */

    /*
    private static Predicate<Integer> getIntegerPredicate() {
        return x -> x % 2 == 0;
    }
     */
}
