package ch02.`when`

import ch02.Color

fun measureColor() = Color.ORANGE

fun getWarmthFromSensor() : String {
    return when(val color = measureColor()){
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm (red = ${color.r})"
        Color.GREEN -> "neutral (green = ${color.g})"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue=${color.b})"
    }
}

fun main() {
    println(getWarmthFromSensor())
}
