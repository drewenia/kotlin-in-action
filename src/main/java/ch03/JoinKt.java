package ch03;
import java.util.List;

/* Top level function olarak joinToStringv2 methodunu ch03
klasöründeki join.kt den import ettim */
import static ch03._3_5_utilityFunctionsAsExtensionsKt.joinToStringFinal;
import static strings.ExtensionFunctionsKt.lastChar;
import static strings.StringFunctions.joinToStringv2;

public class JoinKt {
    public static void main(String[] args) {
        List<String> strings = List.of("1", "2", "3");
        String test = joinToStringv2(strings,"-","(",")");
        System.out.println( test);

        // extensionFunctions.kt içerisinden geliyor
        char c = lastChar("Java");
        System.out.println(c);

        //ch03 altında ki 3.5 den geliyor
        String finalString = joinToStringFinal(strings,";","#","#");
        System.out.println(finalString);
    }
}
