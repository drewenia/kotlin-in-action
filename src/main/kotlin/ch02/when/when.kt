package ch02.`when`

enum class ColorWhenExample(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0);

    fun getMnemonic(color: ColorWhenExample) =
        when (color) {
            RED -> "Richard"
            ORANGE -> "Of"
            YELLOW -> "York"
        }
}

// Burada getMnemonic instance methodu olduğu için ColorWhenExample'a ihtiyacı var
fun main() {
    val color = ColorWhenExample.RED
    println(color.getMnemonic(color))
}

