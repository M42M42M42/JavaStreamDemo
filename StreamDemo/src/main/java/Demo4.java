import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Demo4 {
    public static void main(String[] args) {

        // 使用Stream.reduce()，把一个Stream的所有元素按照聚合函数聚合成一个结果
        int sum = Stream.of(1, 2, 3, 4, 5).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum);

        // 如果去掉初始值，则得到一个Optional<Integer>：
        Optional<Integer> opt =  Stream.of(1, 2, 3, 4, 5).reduce((acc, n) -> acc + n);
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        // 求积
        int s = Stream.of(1, 2, 3 ,4, 5, 6).reduce(1, (acc, n) -> acc * n);
        System.out.println(s);

        // 利用reduce()对Java对象进行操作
        // 按行读取配置文件
        List<String> props = List.of("prop1=yes", "prop2=no", "prop3=123");
        Map<String, String> map = props.stream()
                // 把字符串k=v转化为Map[k]=v
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    return Map.of(ss[0], ss[1]);
                })
                // 把所有Map聚合到一个Map
                .reduce(new HashMap<String, String>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }
}
