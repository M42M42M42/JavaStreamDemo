import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Demo1 {
    public static void main(String[] args) {

        // 使用Stream.of()静态方法，创建stream
        Stream<String> stream = Stream.of("A", "B", "C", "D", "E");
        stream.forEach(System.out::println);

        // 基于数组或者Collection，创建stream
        Stream<String> stream1 = Arrays.stream(new String[] {"hello", "world", "!"});
        Stream<String> stream2 = List.of("hello", "world", "!").stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);

        // 基于Supplier，通过Stream.generate()方法，创建stream（注意：无限序列必须先变成有限序列再打印！）
        Stream<Integer> fibonacci = Stream.generate(new FibonacciSupplier());
        fibonacci.limit(10).forEach(System.out::println);

        // Java标准库提供了IntStream、LongStream和DoubleStream这三种使用基本类型的Stream，使用可以提高运行效率
        IntStream intStream = Arrays.stream(new int[] {1, 2, 3, 4, 5});
        LongStream longStream = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);
        DoubleStream doubleStream = List.of("1.05", "2.33", "3.98").stream().mapToDouble(Double::parseDouble);
        intStream.forEach(System.out::println);
        longStream.forEach(System.out::println);
        doubleStream.forEach(System.out::println);
    }
}

// 生成斐波那契数列
class FibonacciSupplier implements Supplier<Integer> {
    int n1 = 0;
    int n2 = 1;
    public Integer get() {
        int n3 = n2;
        n2 = n1 + n2;
        n1 = n3;
        return n3;
    }
}
