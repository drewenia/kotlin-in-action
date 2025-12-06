package ch02

/* Kotlin programlarınızda sıkça kullanacağınız bir diğer temel yapı taşı, data saklamanıza imkân veren variable’lardır.
Kotlin’de bir variable declaration, bir keyword ile (val veya var) başlar ve ardından variable için verilen isim gelir.
Kotlin, güçlü type inference sayesinde birçok variable declaration’da type’ı atlamanıza izin verir; ancak type’ı her
zaman variable adından sonra explicit olarak yazabilirsiniz. Örneğin, en ünlü sorulardan birini ve onun cevabını bir
Kotlin variable’ında saklamanız gerekseydi, question ve answer adında iki variable declare ederek ve type’larını
explicit belirterek bunu yapabilirdiniz.
*/

val question214 : String =
    "The Ultimate Question of Life, the Universe, and Everything"

val answer214 : Int = 42

/* Type declaration’ları da atlayabilir ve örneği biraz daha kısa hale getirebilirsiniz: */

val question214v2 =
    "The Ultimate Question of Life, the Universe, and Everything"

val answer214v2 = 42

/* Expression-body fonksiyonlarda olduğu gibi, type’ı belirtmezseniz compiler initializer expression’ı analiz eder ve
onun type’ını variable’ın type’ı olarak kullanır. Bu durumda initializer olan 42, Int type’ındadır; dolayısıyla answer
variable’ı da aynı type’a sahip olur.

Bir floating-point constant kullanırsanız, variable’ın type’ı Double olur:
*/

val yearsToCompute214 = 7.5e6

/* Eğer variable’ınızı hemen initialize etmiyorsanız ve ona daha sonraki bir noktada assignment yapacaksanız, compiler
variable için type inference yapamaz. Bu durumda type’ını explicit olarak belirtmeniz gerekir:
*/

fun main(){
    val answer : Int
    answer = 42
}