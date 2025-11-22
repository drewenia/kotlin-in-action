package ch02.`when`

import ch02.Color
import ch02.Color.*

// performans olarak ufak ufak set'ler oluşturmaktan çok daha iyidir
// extra hiç bir object oluşturulmaz
fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO

        else -> throw Exception("dirty color")
    }

fun main(){
    println(mixOptimized(BLUE,YELLOW))
}