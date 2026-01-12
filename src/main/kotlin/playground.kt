operator fun Box.plus(extra: Int): Box {
    return this.addWeight(extra)
}

fun main() {
    val myBox = Box(10)
    val heavyBox = myBox + 5
    println(heavyBox.weight) // 15
}

class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}