import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo6 {
    public static void main(String[] args) {

        // 排序（此方法要求Stream的每个元素必须实现Comparable接口）
        List<String> list1 = List.of("hello", "thought", "workers")
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list1);

        // 自定义排序规则（传入指定的Comparator）
        List<String> list2 = List.of("hello", "thought", "workers")
                .stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
        System.out.println(list2);

        // 去重
        List<String> list3 = List.of("hello", "thought", "hello", "workers", "workers", "hello")
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list3);

        // 截取（skip()用于跳过当前Stream的前N个元素，limit()用于截取当前Stream最多前N个元素）
        List<String> list4 = List.of("hello", "thought", "hello", "workers", "workers", "hello")
                .stream()
                .skip(2) // 跳过"hello", "thought"
                .limit(3) // 截取3个
                .collect(Collectors.toList());
        System.out.println(list4);

        // 合并
        Stream<String> s1 = List.of("1", "2", "3", "4").stream();
        Stream<String> s2 = List.of("5", "6").stream();
        Stream<String> s = Stream.concat(s1, s2);
        System.out.println(s.collect(Collectors.toList()));

        // flatMap（把Stream的每个元素（这里是List）映射为Stream，然后合并成一个新的Stream）
        Stream<List<Integer>> ss = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        Stream<Integer> ii = ss.flatMap(list -> list.stream());
        System.out.println(ii.collect(Collectors.toList()));

        // 并行
        List<String> list7 = List.of("hello", "thought", "workers")
                .stream()
                .parallel()
                .collect(Collectors.toList());
        System.out.println(list7);
    }
}
