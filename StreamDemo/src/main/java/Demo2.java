import java.util.List;
import java.util.stream.Stream;

public class Demo2 {
    public static void main(String[] args) {

        // 使用map操作，把一种操作运算，映射到一个序列的每一个元素上
        Stream<Integer> s1 = Stream.of(5, 4, 3, 2, 1);
        Stream<Integer> s2 = s1.map(n -> n * (n + 1));
        s2.forEach(System.out::println);

        List.of("  Hello ", " Thoughtworkers ", " how", " ARe ", "YOU")
                .stream()
                .map(String::trim) // 去空格
                .map(String::toLowerCase) // 变小写
                .forEach(System.out::println); // 打印
    }
}
