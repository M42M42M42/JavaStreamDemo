import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo3 {
    public static void main(String[] args) {

        // 筛选出偶数，进行打印
        IntStream.of(1, 2, 3, 4, 5)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // 从一组给定的LocalDate中过滤掉工作日，得到休息日
        Stream.generate(new LocalDateSupplier())
                .limit(31)
                .filter(ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
    }
}

class LocalDateSupplier implements Supplier<LocalDate> {
    LocalDate start = LocalDate.of(2022, 1, 1);
    int n = -1;
    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}
