import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        putNotGet();
    }

    static void putNotGet() {
        List<Object> objs = Arrays.asList(1, "two");
        List<? super Integer> ints = objs;

        // ints.add(3); // ok, list’e value koyabilirsin
        // double dbl = sum(ints);
        // compile-time error. Yalnızca Object’ler get edilebilir
        String str = "";
        for (Object obj : ints) {
            str += obj.toString();
        }
        System.out.println(str); //1two
    }

    static double sum(Collection<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
