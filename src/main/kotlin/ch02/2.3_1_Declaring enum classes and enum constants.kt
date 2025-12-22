package ch02

/* Bu bölümde, Kotlin’de enum declare etme örneğine bakacağız ve when yapısından bahsedeceğiz. When yapısı, Java’daki
switch yapısının daha güçlü ve sık kullanılan bir yerine geçeni olarak düşünülebilir. Ayrıca, type kontrolleri ve cast
işlemlerini birleştiren smart cast kavramını da ele alacağız. */

enum class Color231{
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

/* enum bir soft keyword’dür. Kotlin’de enum, soft keyword olarak adlandırılan bir yapıdır: class ifadesinden önce
geldiğinde özel bir anlama sahiptir, fakat diğer yerlerde (örneğin bir function, variable adı veya parameter için)
normal bir ad olarak kullanılabilir. Öte yandan class bir hard keyword’dür; onu bir identifier olarak kullanamazsın:
clazz veya aClass gibi alternatif bir yazım ya da ifade kullanman gerekir. */

/* Renklerin bir enum içinde saklanması faydalıdır, ancak daha iyisini yapabiliriz. Renk değerleri genellikle kırmızı,
yeşil ve mavi bileşenleriyle temsil edilir. Enum sabitleri, daha önce normal class’lar için gördüğün aynı constructor ve
property declaration söz dizimini kullanır. Bunu Color enum’unu genişletmek için kullanabilirsin: her enum sabitini
kendi r, g ve b değerleriyle ilişkilendirebilirsin. Ayrıca bileşenlerden birleşik sayısal bir renk değeri oluşturan rgb
gibi property’ler ve printColor gibi method’lar da tanımlayabilirsin; üstelik tanıdık söz dizimiyle. */

enum class Color231v2 (
    val r : Int,
    val g : Int,
    val b : Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);
    /* Bu örneğin, Kotlin syntax'ında semicolon kullanmanın **zorunlu olduğu tek yeri** gösterdiğini unutma: enum class
    içinde herhangi bir method tanımlarsan, semicolon enum sabitlerinin listesini method tanımlarından ayırır. */
    val rgb = (r * 256 + g) * 256 + b
    fun printColor() = println("this is rgb : $rgb")
}

fun main(){
    println(Color231v2.BLUE.rgb) // 255
    Color231v2.GREEN.printColor() // this is rgb : 65280
    val vtsList = listOf(
        DirectionVts231("10.0.0.101","K01", VtsType231.DIRECTION),
        DirectionVts231("10.0.0.102","K02", VtsType231.DIRECTION)
    )
    println(vtsList)
}

sealed class Vts231(
    open val ipAddress : String,
    open val name : String
)

data class DirectionVts231 (
    override val ipAddress: String,
    override val name : String,
    val vtsType : VtsType231
) : Vts231 (ipAddress,name)

enum class VtsType231{
    SPEED, DIRECTION, FLASH
}