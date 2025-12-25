package ch05

/* Kotlin’de, aksi halde bir functional interface kullanman gereken behavior’ı ifade etmek için çoğu zaman function
type’larını kullanabilirsin. Kotlin’de type alias’lar aracılığıyla function type’lara daha expressive isimler vermenin
bir yolunu göreceğiz. Ancak, kodunda daha explicit olmak isteyeceğin bazı durumlar olabilir. Kotlin’de bir fun interface
declare ederek kendi functional interface’lerini tanımlayabilirsin. Kotlin’deki functional interface’ler tam olarak bir
abstract method içerir, ancak buna ek olarak birkaç non-abstract method da içerebilir. Bu, bir function type’ın
signature’ına sığdıramayacağın daha complex construct’ları ifade etmene yardımcı olabilir. Aşağıdaki example’da, check
adlı abstract method’a sahip IntCondition adlı bir functional interface define edersin. Parameter’ını integer’a
dönüştürdükten sonra check’i invoke eden, checkString adlı ek bir non-abstract method define edersin. Java SAM’lerinde
olduğu gibi, check’in implementation’ını belirleyen bir lambda ile interface’i instantiate etmek için SAM constructor
kullanırsın. */

fun interface IntCondition53 {
    // Tam olarak bir abstract method …
    fun check(i: Int): Boolean

    // … ve ek non-abstract method’lar
    fun checkString(s: String) = check(s.toInt())
    fun checkChar(c: Char) = check(c.digitToInt())
}

/* Bir function, type’ı bir fun interface olarak defined edilmiş bir parameter kabul ettiğinde, yine doğrudan bir lambda
implementation sağlayabilir veya bir lambda’ya reference pass edebilirsin; her ikisi de interface implementation’ını
dynamic olarak instantiate eder. Aşağıdaki example’da, daha önce tanımladığımız IntCondition’ı alan bir checkCondition
function’ı define ediyorsun. Daha sonra bu function’ı çağırmanın birden fazla yolu vardır—örneğin, doğrudan bir lambda
pass ederek veya doğru type’a sahip bir function’a reference pass ederek. */

fun checkCondition53(i: Int, condition: IntCondition53): Boolean {
    return condition.check(i)
}

/* Hem Java hem de Kotlin kodundan kullanılmasını beklediğin code yazıyorsan, bir fun interface kullanmak Java call
site’larının clean olmasını da iyileştirebilir. Kotlin function type’ları, generic type’ları parameter ve return
type’lar olan object’ler olarak translate edilir. Herhangi bir şey return etmeyen function’lar için Kotlin, Java’nın
void’ine analog olarak Unit kullanır. Bu aynı zamanda, böyle bir Kotlin function type Java’dan invoke edildiğinde,
çağıranın açıkça Unit.INSTANCE return etmesi gerektiği anlamına gelir. Bir fun interface kullanmak bu gerekliliği
ortadan kaldırır ve call site’ı daha concise hâle getirir. Bu example’da, consumeHello ve consumeHelloFunctional
function’ları aynı şeyi yapar; ancak biri functional interface kullanılarak, diğeri ise Kotlin function type’ları
kullanılarak define edilmiştir. */

fun interface StringConsumer53 {
    fun consume(s: String)
}

fun consumeHello53(t: StringConsumer53) {
    t.consume("Hello")
}

fun consumeHello53Functional(t: (String) -> Unit) {
    t("Hello")
}

/* Java’dan kullanıldığında, fun interface kullanan function varyantı basit bir lambda ile call edilebilirken, Kotlin
function type’larını kullanan varyant, lambda’nın açıkça Kotlin’in Unit.INSTANCE’ini return etmesini gerektirir.

import kotlin.Unit;
public class MyApp {
    public static void main(String[] args) {
        /* Java */
        MainKt.consumeHello(s -> System.out.println(s.toUpperCase()));
        MainKt.consumeHelloFunctional(s -> {
            System.out.println(s.toUpperCase());
            return Unit.INSTANCE;
        });
    }
}
*/

/* Genel bir kural olarak, basit functional type’lar, API’nin belirli bir parameter set’i alan ve belirli bir type
döndüren herhangi bir function’ı kabul edebildiği durumlarda iyi çalışır. Functional type signature’ı içinde ifade
edemeyeceğin daha complex contract’ları veya operation’ları ifade etmen gerektiğinde ise, bir functional interface iyi
bir seçimdir. Lambda syntax’ı ve kullanımına ilişkin tartışmamızı bitirmek için, receiver’lı lambda’lara ve bunların
built-in construct’lar gibi görünen kullanışlı library function’ları tanımlamak için nasıl kullanıldığına bakalım. */

fun main() {
    val isOdd = IntCondition53 { it % 2 != 0 }
    println(isOdd.check(5)) // true
    println(isOdd.checkString("4")) // false
    println(isOdd.checkChar('9')) // true

    checkCondition53(11) { it % 2 != 0 }
    // (Int) -> Boolean — bu syntax ve genel olarak lambda’lar hakkında daha fazlasını bölüm 10.1’de öğreneceksin).
    val isOdd2: (Int) -> Boolean = { it % 2 != 0 }
    checkCondition53(5, isOdd2)
}