package ch02

import java.io.BufferedReader
import java.io.StringReader

/* Diğer taraftaysan — yani error’ları throw etmek yerine onlardan kurtulmaya çalışıyorsan — exception’ları handle
etmek için catch ve finally clause’larıyla birlikte try construct’ünü kullanırsın. Bunu, bir BufferedReader’dan bir
satır metin okuyan, onu bir sayı olarak parse etmeyi deneyen ve satır geçerli bir sayı değilse sayı ya da null döndüren
aşağıdaki örnekte görebilirsin. */

// Kotlin’de bir function’dan throw edilebilecek exception’ları açıkça specify etmezsin.
fun readNumber251(reader : BufferedReader) : Int?{
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException){ // Exception type sağ taraftadır.
        return null
    } finally { // finally, Java’daki gibi çalışır.
        reader.close()
    }
}

fun main() {
    val reader = BufferedReader(StringReader("113"))
    println(readNumber251(reader)) // 113
}

/* Java’dan önemli bir fark olarak, Kotlin’de throws clause yoktur. Bu function’ı Java’da yazmış olsaydın, function
declaration’dan sonra açıkça throws IOException yazardın.

Integer readNumber(BufferedReader reader) throws IOException
*/

/* Bunu yapman gerekirdi, çünkü Java’nın readLine ve close method’ları, checked exception olan bir IOException throw
edebilir. Java dünyasında bu, açıkça handle edilmesi gereken bir exception type’ını tanımlar. Function’ının throw
edebileceği tüm checked exception’ları declare etmelisin ve başka bir function’ı call ediyorsan, onun checked
exception’larını ya handle etmen ya da kendi function’ının da bunları throw edebileceğini declare etmen gerekir. Diğer
birçok modern JVM language’ı gibi, Kotlin checked ve unchecked exception’lar arasında bir ayrım yapmaz. Bir function’ın
throw ettiği exception’ları specify etmezsin ve exception’ları handle edebilir ya da etmeyebilirsin. Bu tasarım kararı,
Java’daki checked exception kullanım pratiğine dayanır. Deneyimler, Java kurallarının çoğu zaman exception’ları yeniden
throw etmek ya da ignore etmek için çok fazla anlamsız code gerektirdiğini ve bu kuralların ortaya çıkabilecek
error’lardan seni tutarlı bir şekilde korumadığını göstermiştir. Örneğin, yukarıda ki code'da NumberFormatException
checked bir exception değildir. Bu nedenle, Java compiler seni bunu catch etmeye zorlamaz ve exception’ın runtime’da
meydana geldiğini kolayca görebilirsin. Bu talihsiz bir durumdur, çünkü geçersiz input data yaygın bir durumdur ve
düzgün bir şekilde handle edilmelidir. Aynı zamanda, BufferedReader.close method’u checked bir exception olan
IOException throw edebilir ve bunun handle edilmesi gerekir. Çoğu program, bir stream’in kapatılması başarısız olursa
anlamlı herhangi bir action alamaz; bu yüzden close method’undan gelen exception’ı catch etmek için gereken code
boilerplate’tir. */

/* Kotlin’de compiler, exception’ları handle etmeye seni zorlamaz. */

fun readNumber251v2(reader : BufferedReader) : Int{
    val line = reader.readLine()
    reader.close()
    return Integer.parseInt(line)
}

/* Java’nın try-with-resources’ına ne olacak? Kotlin bunun için özel bir syntax’a sahip değildir; bu, bir library
function olarak implement edilmiştir. Bölüm 10’da bunun nasıl mümkün olduğunu göreceksin. */
