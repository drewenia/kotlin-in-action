enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    val rgb = (r * 256 + g) * 256 + b
    fun printColor() = println("this is rgb : $rgb")
}

/* Bir when expression’ının argümanı herhangi bir object olabilir. Branch koşullarıyla eşitlik açısından kontrol
edilir. */
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        /* Karıştırılabilen renk pair’larını enumerate eder. */
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW,Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE,Color.VIOLET) -> Color.INDIGO
        /* Diğer branch’lerin hiçbiri eşleşmediğinde çalıştırılır. */
        else -> throw IllegalArgumentException("Dirty Color")
    }

fun main() {
    println(mix(Color.YELLOW, Color.RED))
}