package ch05

/* Daha önce de belirttiğimiz gibi, bir lambda, değer olarak etrafta dolaştırabileceğiniz küçük bir behavior parçasını
kodlar. Bağımsız olarak declare edilebilir ve bir variable’da saklanabilir. Ancak daha sık olarak, bir function’a
geçirilirken doğrudan declare edilir. img.png, lambda expressions declare etmenin syntax’ını gösterir. Kotlin’de bir
lambda expression her zaman curly braces ile çevrilidir. Argument’ların etrafında parentheses olmadığını unutmayın. Ok
işareti, argument list’i ile lambda’nın body’sini birbirinden ayırır. Bir lambda expression’ı bir variable’da
saklayabilir ve sonra bu variable’ı normal bir function gibi ele alabilirsiniz (ilgili argument’larla call
edebilirsiniz): */

fun main() {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(2, 3)) // 5

    println(lambdaExpressionExample513()) // 242
    lambdaExpressionExample513v2()
    printOlderPeople513v2()
    showNames513()
    getAgeExample513()
    sumExample513()
}

// İsterseniz, bir lambda expression’ı doğrudan da call edebilirsiniz:
fun lambdaExpressionExample513(): Int {
    return { x: Int, y: Int -> x * y }(11, 22)
}

/* Ancak böyle bir syntax okunabilir değildir ve pek anlamlı sayılmaz (lambda body’sini doğrudan execute etmeye
eşdeğerdir). Bir kod parçasını bir block içine almak istiyorsanız, kendisine geçirilen lambda’yı execute eden run
library function’ını kullanabilirsiniz: */

fun lambdaExpressionExample513v2() {
    run { println(42) } // Lambda içindeki code’u çalıştırır
}

/* run function’ı, özellikle bir expression beklendiği yerde birden fazla statement içeren bir block’u execute etmeniz
gerektiğinde kullanışlı hale gelir. Bir miktar hazırlık yapan veya ek work gerçekleştiren bir top-level variable
declaration’ını düşünün: */

val myFavouriteNumber513 = run {
    println("I am thinking!")
    println("I'm doing some more work...")
    42
}

/* Çalışma sırası (çok önemli)

run { ... } bloğu hemen çalışır
İçindeki println’ler ekrana basılır
En son expression (42) run’ın dönüş değeri olur
Bu değer myFavouriteNumber’a atanır

Neden run kullanılır?

Bir değeri üretmeden önce küçük bir işlem bloğu çalıştırmak için
Geçici değişken yaratmadan logic’i gruplayabilmek için
*/

/* İleride, bu tür invocation’ların — bir lambda expression oluşturup onu doğrudan {…}() ile call etmeye kıyasla — neden
runtime overhead oluşturmadığını ve built-in language construct’lar kadar efficient olduğunu öğreneceksiniz. En yaşlı
kişiyi bir list’te bulan örneğe geri dönelim: */

data class Person513(val name: String, val age: Int)

fun printOlderPeople513() {
    val people = listOf(
        Person513("Alice", 29),
        Person513("Bob", 33)
    )
    println(people.maxByOrNull { it.age })
}

/* Bu örneği herhangi bir syntax kısayolu kullanmadan yeniden yazarsanız, aşağıdakini elde edersiniz: */
fun printOlderPeople513v2() {
    val people = listOf(
        Person513("Alice", 29),
        Person513("Bob", 33)
    )
    println(people.maxByOrNull { p: Person513 -> p.age }) // Person513(name=Bob, age=33)
}

/* Burada ne olduğu açık olmalıdır: curly braces içindeki code bir lambda expression’dır ve bunu function’a bir argument
olarak geçirirsiniz. Lambda expression, Person type’ında bir argument alır ve onun age’ini return eder. Kotlin’de, bir
function call’unda lambda expression son argument ise, onu parentheses dışına taşımanıza izin veren bir syntactic
convention vardır. Bu örnekte lambda tek argument’tır, bu yüzden parentheses’ten sonra yerleştirilebilir. Lambda bir
function’ın tek argument’ı olduğunda, call’dan boş parentheses’leri de kaldırabilirsiniz: Bir function birden fazla
argument alıyorsa ve sadece son argument bir lambda ise, Kotlin’de lambda’yı parentheses dışında tutmak da good style
olarak kabul edilir. İki veya daha fazla lambda geçirmek istiyorsanız, birden fazlasını dışarı taşıyamazsınız; bu yüzden
genellikle hepsini parentheses içinde tutmak daha iyidir. */

fun showNames513() {
    val people = listOf(
        Person513("Alice", 29),
        Person513("Bob", 33)
    )

    /* lambda’yı geçirmek için named argument kullanır ve lambda’nın ne için kullanıldığını açık hale getirir */
    val names = people.joinToString(
        separator = "#",
        transform = { p: Person513 -> p.name }
    )
    /* Ve işte o call’u, lambda parentheses dışında olacak şekilde nasıl yeniden yazabileceğiniz. daha kısadır, ancak
    lambda’nın ne amaçla kullanıldığını açıkça ifade etmez; bu nedenle çağrılan function’a aşina olmayan kişiler için
    anlaması daha zor olabilir */
    val names2 = people.joinToString("|") { p: Person513 -> p.name }

    println(names) // Alice#Bob
    println(names2) // Alice|Bob
}

/* local variable’larda olduğu gibi, bir lambda parameter’ın type’ı infer edilebiliyorsa, onu explicit olarak
belirtmeniz gerekmez. maxByOrNull function’ında parameter type her zaman collection element type’ı ile aynıdır.
Compiler, maxByOrNull’u Person object’lerinden oluşan bir collection üzerinde call ettiğinizi bildiği için, lambda
parameter’ın da Person type’ında olacağını anlayabilir. Compiler’ın lambda parameter type’ını infer edemediği case’ler
vardır, ancak bunları burada ele almayacağız. Uygulayabileceğiniz basit kural şudur: her zaman type’lar olmadan
başlayın; eğer compiler şikâyet ederse, onları belirtin. Bazı argument type’larını belirtip diğerlerini sadece
isimleriyle bırakabilirsiniz. Bu, compiler’ın type’lardan birini infer edemediği durumlarda ya da explicit bir type
readability’yi artırdığında kullanışlı olabilir. Bu örnekte yapabileceğiniz son sadeleştirme, bir parameter’ı default
parameter adı olan **it** ile değiştirmektir. Bu isim, context yalnızca tek argument alan bir lambda beklediğinde ve
onun type’ı infer edilebildiğinde oluşturulur. Bu default isim, yalnızca argument adını explicit olarak belirtmediğiniz
durumda oluşturulur. it kullanımını kötüye kullanmayın. Özellikle nested lambdas durumunda, her lambda’nın parameter’ını
explicit olarak declare etmek daha iyidir; aksi halde it’in hangi değere referans verdiğini anlamak zorlaşır
(ve “Implicit parameter it of enclosing lambda is shadowed” benzeri bir warning alırsınız). Ayrıca, parameter’ın anlamı
veya type’ı context’ten net değilse, parameter’ları explicit olarak declare etmek de faydalıdır. */

/*

1 - people.maxByOrNull({ p: Person -> p.age })
2 - people.maxByOrNull() { p: Person -> p.age }
3 - people.maxByOrNull { p: Person -> p.age }
4 - people.maxByOrNull { p -> p.age }
5 - people.maxByOrNull { it.age }
6 - people.maxByOrNull(Person::age)

*/

/* people collection’dan en yaşlı kişiyi almak için maxByOrNull call’unu altı adımda sadeleştirdiniz.

(1) Lambda’yı parentheses dışına taşıdınız,
(2) artık boş olan parentheses çiftini kaldırdınız,
(3) p için parameter type’ı explicit olarak belirtmek yerine,
(4) Kotlin compiler’ın type inference’ını kullandınız ve
(5) tek lambda parameter’ı için implicit isim olan it’i kullandınız. Ayrıca
(6) member references biçiminde ek bir kısaltma da öğrendiniz.

*/

/* Bir lambda’yı bir variable’da saklarsanız, parameter type’larının infer edilebileceği bir context yoktur; bu yüzden
onları explicit olarak belirtmeniz gerekir: */

fun getAgeExample513() {
    val people = listOf(
        Person513("Alice", 29),
        Person513("Bob", 33)
    )
    val getAge = { p: Person513 -> p.age }
    println(people.maxByOrNull(getAge)) // Person513(name=Bob, age=33)
}

/* Şu ana kadar, yalnızca tek bir expression veya statement’tan oluşan lambda örneklerini gördünüz. Ancak lambdas bu
kadar küçük olmak zorunda değildir ve birden fazla statement içerebilir. Bu durumda, son expression sonuçtur — explicit
bir return statement’a gerek yoktur: */

fun sumExample513() {
    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum(2, 4))
    // Computing the sum of 2 and 4...
    // 6
}

/* Sırada, lambda expressions ile sıklıkla birlikte ele alınan bir kavramdan bahsedelim: context’ten variable’ları
capture etme. */