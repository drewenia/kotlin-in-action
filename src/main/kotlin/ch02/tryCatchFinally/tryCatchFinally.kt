package ch02.tryCatchFinally

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader : BufferedReader) : Int? {
    try{
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException){
        return null
    } finally {
        reader.close()
    }
}

/*
    Hangi exception’ları handle etmek isteyip istemediğinize kendiniz karar verirsiniz. İsterseniz, readNumber
    fonksiyonunu tamamen try-catch yapıları olmadan da implemente edebilirsiniz.
*/
fun readNumberWithoutExceptionHandling(reader : BufferedReader) : Int{
    val line = reader.readLine()
    reader.close()
    return Integer.parseInt(line)
}

fun main() {
    val reader = BufferedReader(StringReader("asd"))
    println(readNumber(reader))
    println(readNumberWithoutExceptionHandling(reader))
}