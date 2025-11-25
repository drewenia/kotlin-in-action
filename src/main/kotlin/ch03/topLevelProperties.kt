package ch03

import kotlin.math.E
import kotlin.math.PI
import kotlin.math.max

/* Tıpkı function’lar gibi, property’ler de bir file’ın top level’ına yerleştirilebilir. Tekil data parçalarını bir
class’ın dışında saklamak çok sık gerekmese de yine de kullanışlıdır. Örneğin, bir operation’ın kaç kez
gerçekleştirildiğini saymak için bir **var** property kullanabilirsiniz:
Böyle bir property’nin değeri bir static field içinde saklanır. Top-level property’ler, kodunuzda sabitleri (constants)
tanımlamanıza da imkân tanır:
*/

var opCount = 0

/* Varsayılan olarak, top-level property’ler tıpkı diğer property’ler gibi Java koduna accessor method’ları şeklinde
açılır (val için getter; var için getter + setter). Eğer bir sabitin Java tarafından public static final field olarak
görünmesini istiyorsan—kullanımını daha doğal yapmak için—onu const bildirimiyle işaretleyebilirsin (bu sadece primitive
type’lar ve String için geçerlidir):*/

const val UNIX_LINE_SEPERATOR = "\n"
/* Java'da ki karşılığı */
//public static final String UNIX_LINE_SEPARATOR = "\n";

/* Kotlin standard library ayrıca birçok kullanışlı top-level function ve property içerir. Bunun bir örneği kotlin.math
package’ıdır. Bu package, iki sayının maksimumunu hesaplayan max function’ı gibi tipik matematiksel ve trigonometrik
operation’lar için kullanışlı function’lar sağlar. Ayrıca Euler sayısı veya pi gibi birçok matematiksel sabit içerir.*/
fun getPi(){
    println(max(PI, E))
}

fun performOperation(){
    opCount++
}

fun main(){
    performOperation()
    println("Operation performed $opCount times")
    println(getPi()) // 3.141592653589793
}