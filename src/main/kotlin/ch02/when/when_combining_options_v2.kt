package ch02.`when`

// import ettiğimiz için full name kullanmıyoruz (ORANGE) yeterli
import ch02.Color.*

fun measurecolorV2() = ORANGE

fun getWarmth() : String {
    return when(val color = measurecolorV2()){
        RED,ORANGE,YELLOW -> "warm : ${color.r})"
        GREEN -> "neutral : ${color.g})"
        BLUE,INDIGO,VIOLET -> "cold : ${color.b})"
    }
}

fun main() {
    println(getWarmth())
}