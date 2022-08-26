import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo5 {
    public static void main(String[] args) {

        // 输出为List
        Stream<String> stream = Stream.of("Hello", null, "", "Thoughtworkers", "   ", null, "!");
        List<String> list = stream.filter(s -> s != null && !s.isBlank()).collect(Collectors.toList());
        System.out.println(list);

        // 输出为数组
        List<String> list2 = List.of("Apple", "Banana", "Orange");
        String[] array = list2.stream().toArray(String[]::new);
        for (String s : array) {
            System.out.println(s);
        }

        // 输出为Map
        Stream<String> stream3 = Stream.of("prop1:yes", "prop2:123");
        Map<String, String> map = stream3
                .collect(Collectors.toMap(
                        s -> s.substring(0, s.indexOf(':')), // key
                        s -> s.substring(s.indexOf(':') + 1))); // value
        System.out.println(map);

        // 分组输出
        // 分组的key是s -> s.substring(0, 1)，首字母
        List<String> list4 = List.of("Tom", "Jack", "Mary", "Ken", "Kevin", "Molly", "Jerry");
        Map<String, List<String>> groups = list4.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);
    }
}
