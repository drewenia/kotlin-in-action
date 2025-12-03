package ch04

/* Bu bölümden önce, Kotlin’de class hiyerarşileriyle ilk tanışmanızı zaten yapmıştınız. (1 + 2) + 4 gibi
expression’ları represent etmek için kullandığınız expression hiyerarşisi örneğini hatırlayın. Expr interface’i, bir
sayıyı represent eden Num tarafından ve iki expression’ın toplamını represent eden Sum tarafından implement edilir. Tüm
olası case’leri bir when expression içinde ele almak uygundur. Ancak diğer branch’lerin hiçbirinin eşleşmemesi durumunda
ne olacağını belirtmek için else branch’ini sağlamanız gerekir.
*/

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.right)
        /* Else branch’ini kontrol etmelisiniz. */
        else ->
            throw IllegalArgumentException("unknown expression")
    }

/* when construct’unu bir expression olarak kullanıyorsunuz (yani return value’ını kullanıyorsunuz), kapsamlı olması
gerekir: Kotlin compiler sizi default seçeneği kontrol etmeye zorlar. Bu örnekte anlamlı bir şey return edemezsiniz, bu
yüzden bir exception fırlatırsınız. Her zaman bir default branch eklemek zorunda olmak pratik değildir. Bu aynı zamanda
bir sorun da yaratabilir; çünkü eğer siz (veya bir iş arkadaşınız ya da kullandığınız bir dependency’nin yazarı) yeni
bir subclass eklerse, compiler hangi case’in eksik olduğunu size bildirmez. Eğer o yeni subclass’i ele almak için bir
branch eklemeyi unutursanız, compiler sadece default branch’i seçer ve bu da ince bug'lara yol açabilir. Kotlin, bu
soruna bir çözüm sunar: sealed class’lar. Bir superclass’i sealed modifier ile işaretlersiniz, bu da subclass oluşturma
olasılığını sınırlar. Bir sealed class’ın tüm doğrudan subclass’leri compile time’da bilinir olmalı ve sealed class ile
aynı package içinde declare edilmelidir, ayrıca tüm subclass’ler aynı module içinde bulunmalıdır. Interface kullanmak
yerine, Expr’i sealed class yapabilir ve Num ile Sum’un onun subclass’i olmasını sağlayabilirsiniz.
*/

sealed class Expression
class Number(val value : Int) : Expression()
class Summary(val left : Expression, val right : Expression) : Expression()

fun evaluation(e : Expression) : Int =
    when(e){
        is Number -> e.value
        is Summary -> evaluation(e.left) + evaluation(e.right)
    }

/* Bir sealed class’ın tüm subclass’lerini bir when expression içinde ele alırsanız, default branch sağlamanıza gerek
yoktur — compiler tüm olası branch’leri kapsadığınızdan emin olabilir. Sealed modifier’ın class’ın abstract olduğunu
ima ettiğini unutmayın; ayrıca açıkça abstract modifier kullanmanız gerekmez ve abstract member’lar declare
edebilirsiniz. Bir sealed class’ın tüm doğrudan subclass’leri compile time’da bilinir olmalıdır. Sealed class’larla
when kullandığınızda ve yeni bir subclass eklediğinizde, bir value döndüren when expression compile olmaz; bu da
değiştirilmesi gereken koda işaret eder — örneğin, bir çarpma operatörü Mul tanımladığınızda fakat onu evaluation
function içinde handle etmediğinizde. Class’lara ek olarak, sealed modifier’ı kullanarak sealed interface de
tanımlayabilirsiniz. Sealed interface’ler aynı kurallara uyar: Sealed interface’i içeren module compile edildikten
sonra, onun için yeni implementation sağlanamaz.
*/

sealed interface Toggleable{
    fun toggle()
}

class LightSwitch : Toggleable{
    override fun toggle() = println("lights")
}

class Camera : Toggleable{
    override fun toggle() = println("Camera")
}

/* Bir sealed interface’in tüm implementation’larını bir when statement içinde ele almak, else branch belirtmeniz
gerekmediği anlamına da gelir. Hatırlayacağınız üzere, Kotlin’de bir class’ı extend etmek ve bir interface’i implement
etmek için iki durumda da iki nokta üst üste kullanırsınız. Henüz ele almadığımız şey, Expr() içindeki class adından
sonraki parantezlerin anlamıdır. Bunu, Kotlin’de class’ların initialize edilmesini ele alan sonraki bölümde konuşacağız.
*/