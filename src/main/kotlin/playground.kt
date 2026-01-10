operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun main() {
    val a = 'a'
    println(a * 3) // aaa
}

data class Point(val x: Int, val y: Int)

operator fun Point.times(scale: Double): Point =
    Point((x * scale).toInt(), (y * scale).toInt())

