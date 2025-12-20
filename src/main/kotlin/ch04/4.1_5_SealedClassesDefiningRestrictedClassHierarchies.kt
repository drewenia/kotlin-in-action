package ch04

/* Bu chapter’dan önce, Kotlin’deki class hierarchy’leriyle ilk tanışmanızı zaten yapmıştınız. Expression hierarchy
örneğini hatırlayın; bunu (1 + 2) + 4 gibi expression’ları encode etmek için kullanmıştınız. Expr interface’i, bir
number’ı represent eden Num tarafından ve iki expression’ın toplamını represent eden Sum tarafından implement edilir.
Tüm olası case’leri bir when expression’ında ele almak kullanışlıdır. Ancak, diğer branch’lerin hiçbiri eşleşmezse ne
olacağını belirtmek için else branch’ini sağlamak zorundasınız. when construct’unu bir expression olarak kullandığınız
için (yani return value’sunu kullandığınızdan), exhaustive olması gerekir: Kotlin Compiler, default seçeneği kontrol
etmenizi zorunlu kılar. Bu örnekte anlamlı bir şey return edemediğiniz için bir exception fırlatırsınız. Her zaman bir
default branch eklemek kullanışlı değildir. Bu aynı zamanda bir problem hâline de gelebilir; çünkü siz (ya da bir
çalışma arkadaşınız veya kullandığınız bir dependency’nin yazarı) yeni bir subclass eklediğinde, Compiler eksik bir case
olduğunu size bildirmez. Bu yeni subclass’ı ele almak için bir branch eklemeyi unutursanız, default branch seçilir ve
bu da fark edilmesi zor bug’lara yol açabilir. Kotlin bu probleme bir çözümle gelir: sealed class’lar. Bir superclass’ı
sealed modifier ile işaretlersiniz; bu, subclass oluşturma olasılığını kısıtlar. Bir sealed class’ın tüm doğrudan
subclass’ları compile time’da bilinmek zorundadır ve sealed class’ın kendisiyle aynı package’ta declare edilmelidir;
ayrıca tüm subclass’ların aynı module içinde yer alması gerekir. Bir interface kullanmak yerine, Expr’i bir sealed class
yapabilir ve Num ile Sum’ın ondan subclass olmasını sağlayabilirsiniz. */

sealed class Expr415

class Num415(val value: Int) : Expr415()
class Sum415(val left: Expr415, val right: Expr415) : Expr415()

fun eval415(e: Expr415): Int =
    /* when expression tüm olası case’leri kapsar, bu nedenle else branch’ine gerek yoktur. */
    when (e) {
        is Num415 -> e.value
        is Sum415 -> eval415(e.left) + eval415(e.right)
    }

/* Bir sealed class’ın tüm subclass’larını bir when expression’ında ele alırsanız, default branch sağlamanıza gerek
yoktur—Compiler, tüm olası branch’leri kapsadığınızı garanti edebilir. Sealed modifier’ın class’ı abstract yaptığını
unutmayın; açık bir abstract modifier’a gerek yoktur ve abstract member’lar declare edebilirsiniz. Sealed class’ların
davranışı img_4.png’de gösterilmiştir. Sealed class’larla when kullanıp yeni bir subclass eklediğinizde, value döndüren
when expression compile olmaz; bu, değiştirilmesi gereken koda işaret eder—örneğin, bir multiplication operator Mul
tanımlayıp eval function’ında ele almadığınızda. */

/*
sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
class Mul(val left: Expr, val right: Expr): Expr()
fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        // ERROR: 'when’ expression must be exhaustive,
        // add necessary 'is Mul' branch or 'else' branch instead
    }
*/

/* Class’ların yanı sıra, sealed modifier’ını sealed interface tanımlamak için de kullanabilirsiniz. Sealed
interface’ler aynı kuralları izler: sealed interface’i içeren module compile edildikten sonra, onun için yeni
implementation’lar sağlanamaz. */

sealed interface Toggleable415 {
    /* Her zamanki gibi, sealed interface’ler function’lar ve property’ler tanımlar… */
    fun toggle()
}

class LightSwitch415 : Toggleable415 {
    override fun toggle() = println("Lights")
}

class Camera415 : Toggleable415 {
    override fun toggle() = println("Camera")
}

/* Bir sealed interface’in tüm implementation’larını bir when statement’ında ele almak, else branch’i belirtmek zorunda
olmadığınız anlamına da gelir. */
