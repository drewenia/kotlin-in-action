package ch02
import ch02.Color231v2.*

/* when expression subject’ini bir variable içinde de yakalayabilir. Bu durumda, yakalanan variable’ın scope’u when
expression’ın body'si ile sınırlıdır ve yine de when expression’ın branch'leri içinde property’lerine erişim sağlar.*/

fun measureColor233() = ORANGE

/* when başında kontrol edilecek değeri (subject) alır ve branch’ler bu değerle karşılaştırılır: */
fun getWarmthFromSensor() =
    when (val result = measureColor233()) {
        RED,ORANGE,YELLOW -> "warm (red = ${result.r})"
        GREEN -> "neutral green = ${result.g})"
        BLUE,INDIGO,VIOLET -> "cold blue = ${result.b}"
    }

fun main() {
    println(getWarmthFromSensor())
}

/* Ne zaman ki when bir expression olarak kullanılırsa (yani sonucu bir assignment içinde veya bir return value olarak
kullanılıyorsa), compiler bu yapının eksiksiz olmasını zorunlu kılar. Bu, tüm olası yolların bir value döndürmesi
gerektiği anlamına gelir. Önceki örnekte, tüm enum constant’larını kapsıyoruz ve bu da when yapısını eksiksiz kılıyor.
Bunun yerine, else anahtar sözcüğünü kullanarak bir varsayılan case de sağlayabilirdik. Compiler, tüm olası yolların
kapsanıp kapsanmadığını çıkaramadığı durumlarda, bize bir varsayılan case sağlamayı zorunlu kılar. Bir sonraki bölümde
buna ilişkin bir örneğe bakacağız. */