import kotlin.Unit;
import kotlin.collections.CollectionsKt;

import java.util.ArrayList;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("42");
        // Java code’unda Kotlin standard library’den bir function kullanabilirsin.
        CollectionsKt.forEach(strings, s -> {
            System.out.println(s);
            // Unit type’ında bir value’yu explicit olarak return etmen gerekir.
            return Unit.INSTANCE;
        });
    }
}



