import java.io.BufferedReader
import java.io.StringReader

fun main() {
    val reader = BufferedReader(StringReader("11"))
    val reader2 = BufferedReader(StringReader("not a number"))
    readNumber(reader) // 11
    readNumber(reader2) // hiçbir şey yazdırılmaz
}

fun readNumber(reader : BufferedReader) {
    // Exception oluşmadığında bu value kullanılır.
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e : NumberFormatException){
        // Exception durumunda null value kullanılır.
        null
    }
    println(number)
}
