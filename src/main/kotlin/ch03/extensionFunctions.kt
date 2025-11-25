package strings

/* extension function basit bir şeydir: Bir class’ın üyesiymiş gibi çağrılabilen, ancak o class’ın dışında tanımlanan
bir function. Bunu göstermek için, bir string’in son karakterini hesaplayan bir method ekleyelim */

/* Eklemek istediğiniz function’ın adından önce extend ettiğiniz class veya interface’in adını koymanız yeterlidir. Bu
class adı receiver type olarak adlandırılır; extension function’ı çağırdığınız değer ise receiver object olarak
adlandırılır

String -> Receiver Type
Receiver Object -> this - this

Bir extension function deklarasyonunda, receiver type, extension’ın tanımlandığı type’dır. Function’ınızın hangi type’ı
extend ettiğini belirtmek için kullanılır. Receiver object, o type’ın instance’ıdır. Genişlettiğiniz type’ın property ve
method’larına erişmek için kullanılır. Bir extension function’ın gövdesinde, this’i bir method’ta kullanacağınız şekilde
kullanırsınız. Ve normal bir method’ta olduğu gibi, this’i atlayabilirsiniz:

fun String.lastChar(): Char = get(length - 1)

*/
fun String.lastChar(): Char = this.get(this.length - 1)

// Function’ı, normal class member'ı çağırır gibi aynı sözdizimiyle çağırabilirsiniz:
fun main() {
    /* Bu örnekte, **String** receiver type ve **"Kotlin"** receiver object’tir. Bir anlamda, String class’ına kendi
    method’unuzu eklemiş oldunuz. String, kodunuzun bir parçası olmasa ve hatta o class’ın source code’una sahip
    olmasanız bile, projede ihtiyaç duyduğunuz method’larla onu genişletebilirsiniz. */
    println("Kotlin".lastChar()) // n
}

/* Extension function içinde, genişlettiğiniz class’ın method ve property’lerine, class içinde tanımlanmış method’lar
gibi doğrudan erişebilirsiniz. Ancak, extension function’lar kapsüllemeyi (encapsulation) bozmanıza izin vermez. Class
içinde tanımlanan method’ların aksine, extension function’lar class’ın private veya protected member'larına erişemez.
Örneğin, extension function body'sinde, receiver üzerinde herhangi bir method’u çağırabilirsiniz; bu, hem class
üyelerini hem de extension function’ları çağırabileceğiniz anlamına gelir. Çağrı noktasında, extension function’lar
class üyelerinden ayırt edilemez ve genellikle, belirli method’un bir üye mi yoksa extension mı olduğu önemli değildir.
Elbette, * import’lar da çalışır: import strings.*

Import ettiğiniz class veya function’ın adını **as** anahtar kelimesi ile değiştirebilirsiniz:

import strings.lastChar as last
val c = "Kotlin".last()
*/